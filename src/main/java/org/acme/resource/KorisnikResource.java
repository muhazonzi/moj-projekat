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
import org.acme.exception.KorisnikException;
import org.acme.model.Korisnik;
import org.acme.repository.KorisnikRepository;

@Path("/korisnik/")
public class KorisnikResource {

    @Inject
    private KorisnikRepository korisnikRepository;

    @ConfigProperty(name = "greeting.message")
    String message;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addKorisnik")
    public Response createKorisnik(Korisnik korisnik) {
        Korisnik k = korisnikRepository.createKorisnik(korisnik);
        return Response.ok().entity(k).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllKorisnici")
    public Response getAllKorisnici() {
        List<Korisnik> korisnici = korisnikRepository.getAllKorisnici();
        return Response.ok().entity(korisnici).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getKorisniciByName")
    public Response getKorisniciByName(@QueryParam(value = "name") String name) {
        List<Korisnik> korisnici;
        try {
            korisnici = korisnikRepository.getKorisniciByName(name);
        } catch (KorisnikException e) {
            return Response.ok().entity(e.getMessage()).build();
        }
        return Response.ok().entity(korisnici).build();
    }
}