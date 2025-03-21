package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.Korisnik;

@Dependent
public class KorisnikSource {

    @Inject
    EntityManager em;

    @Transactional
    public Korisnik dodajKorisnika(Korisnik korisnik){
        return em.merge(korisnik);
    }

}
