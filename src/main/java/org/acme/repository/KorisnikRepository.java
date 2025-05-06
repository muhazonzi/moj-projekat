package org.acme.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;
import org.acme.model.Korisnik;
import org.acme.model.Vozilo;
import org.acme.exception.KorisnikException;
import org.acme.model.client.CountryResponse;
import org.acme.model.client.HolidayType;
import org.acme.model.dto.CountryResDto;
import org.acme.restclient.CountryClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

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

    public CountryResponse fromDto(CountryResDto dto) {
        CountryResponse holiday = new CountryResponse();
        holiday.setLocalName(dto.getLocalName());
        holiday.setName(dto.getName());
        holiday.setDate(dto.getDate());
        holiday.setCountryCode(dto.getCountryCode());
        holiday.setGlobal(dto.isGlobal());
        holiday.setCounties(dto.getCounties());
        holiday.setLaunchYear(dto.getLaunchYear());

        List<HolidayType> typeEntities = new ArrayList<>();
        if (dto.getTypes() != null) {
            for (String type : dto.getTypes()) {
                HolidayType t = new HolidayType();
                t.setType(type);
                t.setCountryResponse(holiday);
                typeEntities.add(t);
            }
        }

        holiday.setTypes(typeEntities);
        return holiday;
    }
    public List<CountryResponse> fromDtoList(List<CountryResDto> dtoList) {
        List<CountryResponse> holidays = new ArrayList<>();
        for (CountryResDto dto : dtoList) {
            CountryResponse holiday = fromDto(dto);
            holidays.add(holiday);
        }
        return holidays;
    }
}