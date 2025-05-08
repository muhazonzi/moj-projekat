package org.acme.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.model.client.WeatherResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "weather-api")
public interface WeatherClient {
    @GET
    @Path("/weather/{city}")
    WeatherResponse getForecast(@PathParam("city") String city);
}
