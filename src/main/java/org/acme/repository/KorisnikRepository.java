package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import org.acme.model.Korisnik;
import org.acme.model.Vozilo;
import org.acme.exception.KorisnikException;

@Dependent
public class KorisnikRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Korisnik createKorisnik(Korisnik k) {
        return em.merge(k);
    }

    @Transactional
    public List<Korisnik> getAllKorisnici() {
        List<Korisnik> korisnici = em.createNamedQuery(Korisnik.GET_ALL_KORISNICI, Korisnik.class).getResultList();

        for (Korisnik korisnik : korisnici) {
            List<Vozilo> vozila = em.createNamedQuery(Vozilo.GET_VOZILA_FOR_KORISNIK, Vozilo.class)
                    .setParameter("id", korisnik.getId()).getResultList();

            korisnik.setVozila(vozila);
        }

        return korisnici;
    }

    public List<Korisnik> getKorisniciByName(String name) throws KorisnikException {
        List<Korisnik> korisnici = em.createNamedQuery(Korisnik.GET_KORISNICI_BY_NAME, Korisnik.class)
                .setParameter("name", name).getResultList();

        if (korisnici.size() == 0) {
            throw new KorisnikException("Ne postoje korisnici");
        }

        return korisnici;
    }
}