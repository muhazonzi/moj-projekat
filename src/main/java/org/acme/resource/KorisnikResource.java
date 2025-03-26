package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.Korisnik;
import org.acme.repository.KorisnikSource;

@Path("/korisnik/")
public class KorisnikResource {

    @Inject
    KorisnikSource KorisnikSource;

    @Path("/dodajKorisnika/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dodajKorisnika(Korisnik k) {
        Korisnik korisnik = KorisnikSource.dodajKorisnika(k);
        return Response.ok(korisnik).build();
    }
}
