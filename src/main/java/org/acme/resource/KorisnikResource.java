package org.acme.resource;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.model.client.CountryResponse;
import org.acme.model.client.WeatherResponse;
import org.acme.model.dto.CountryResDto;
import org.acme.restclient.CountryClient;
import org.acme.restclient.WeatherClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.exception.KorisnikException;
import org.acme.model.Korisnik;
import org.acme.repository.KorisnikRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/korisnik/")
public class KorisnikResource {

    @Inject
    EntityManager em;

    @Inject
    private KorisnikRepository korisnikRepository;

    @RestClient
    WeatherClient weatherClient;

    @RestClient
    CountryClient countryClient;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/AvailableCountries")
    public Response getAvailableCountries() {
        List<CountryResponse> countries = countryClient.getAvailableCountries();
        return Response.ok().entity(countries).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/NextPublicHolidays/{countryCode}")
    @Transactional
    public Response getNextPublicHolidays(@PathParam("countryCode") String countryCode) {
        List<CountryResDto> dtos = countryClient.getNextPublicHolidays(countryCode);

        List<CountryResponse> holidays = korisnikRepository.fromDtoList(dtos);
        List<CountryResponse> resultHolidays = new ArrayList<>();

        for (CountryResponse holiday : holidays) {
            String name = holiday.getName();
            String date = holiday.getDate();

            String query = "SELECT c FROM CountryResponse c WHERE c.name = :name AND c.date = :date";

            List<CountryResponse> existingHolidays = em.createQuery(query, CountryResponse.class)
                    .setParameter("name", name)
                    .setParameter("date", date)
                    .getResultList();

            if (existingHolidays.isEmpty()) {
                em.persist(holiday);
                resultHolidays.add(holiday);
            } else {
                resultHolidays.add(existingHolidays.get(0));
            }
        }
        return Response.ok().entity(resultHolidays).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getForecast")
    @Transactional
    public Response getForecast(@QueryParam(value = "city") String city) {
        WeatherResponse weather = weatherClient.getForecast(city);
        korisnikRepository.noDuplicates(weather);
        return Response.ok().entity(weather).build();
    }


}
