package org.acme.resource;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.exception.KaznaException;
import org.acme.model.Kazna;
import org.acme.repository.KaznaRepository;

@Path("/kazna/")
public class KaznaResource {

    @Inject
    private KaznaRepository kaznaRepository;

    @ConfigProperty(name = "greeting.message")
    String message;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addKazna")
    public Response createKazna(Kazna kazna) {
        Kazna k = kaznaRepository.createKazna(kazna);
        return Response.ok().entity(k).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllKazne")
    public Response getAllKazne() {
        List<Kazna> kazne = kaznaRepository.getAllKazne();
        return Response.ok().entity(kazne).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getKazneByOpis")
    public Response getKazneByOpis(@QueryParam(value = "opis") String opis) {
        List<Kazna> kazne;
        try {
            kazne = kaznaRepository.getKazneByOpis(opis);
        } catch (KaznaException e) {
            return Response.ok().entity(e.getMessage()).build();
        }
        return Response.ok().entity(kazne).build();
    }
}
