package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import org.acme.model.Kazna;
import org.acme.exception.KaznaException;

@Dependent
public class KaznaRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Kazna createKazna(Kazna k) {
        return em.merge(k);
    }

    @Transactional
    public List<Kazna> getAllKazne() {
        List<Kazna> kazne = em.createNamedQuery(Kazna.GET_ALL_KAZNE, Kazna.class).getResultList();
        return kazne;
    }

    public List<Kazna> getKazneByOpis(String opis) throws KaznaException {
        List<Kazna> kazne = em.createNamedQuery(Kazna.GET_KAZNE_BY_OPIS, Kazna.class)
                .setParameter("opis", opis).getResultList();

        if (kazne.size() == 0) {
            throw new KaznaException("Ne postoje kazne sa datim opisom");
        }

        return kazne;
    }
}
