package org.acme.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.Korisnik;

public class KorisnikSource {

    @Inject
    EntityManager em;

    @Transactional
    public Korisnik dodajKorisnika(Korisnik korisnik){
        return em.merge(korisnik);
    }

}
