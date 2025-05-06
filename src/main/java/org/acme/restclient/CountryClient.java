package org.acme.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.model.client.CountryResponse;
import org.acme.model.dto.CountryResDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "country-api")
public interface CountryClient {

    @GET
    @Path("/AvailableCountries")
    List <CountryResponse> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<CountryResDto> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
}
