package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.model.KorisnikKazna;

@Dependent
public class KorisnikKaznaRepository {
    @Inject
    EntityManager em;

    @Transactional
    public KorisnikKazna createKorisnikKazna(KorisnikKazna kk) {
        return em.merge(kk);
    }



}
