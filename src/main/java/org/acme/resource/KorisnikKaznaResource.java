package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.KorisnikKazna;
import org.acme.repository.KorisnikKaznaRepository;

@Path("/korisnikKazna")
public class KorisnikKaznaResource {

    @Inject
    KorisnikKaznaRepository korisnikKaznaRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")

    public Response createKorisnikKazna(KorisnikKazna kk) {
        KorisnikKazna kka = korisnikKaznaRepository.createKorisnikKazna(kk);
        return Response.ok().entity(kka).build();
    }
}
