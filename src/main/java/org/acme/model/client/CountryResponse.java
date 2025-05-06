package org.acme.model.client;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "date"})
)
public class CountryResponse {
    @Id
    @SequenceGenerator( name = "country_response_seq", sequenceName = "country_response_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "country_response_seq" )
    private Long id;
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private String counties = null;
    private String launchYear = null;
    @OneToMany(mappedBy = "countryResponse", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<HolidayType> types = new ArrayList<>();


    public CountryResponse() {
    }

    public CountryResponse( String date, String localName, String name, String countryCode, boolean fixed,
            boolean global, String counties, String launchYear, List<HolidayType> types ) {
        this.date = date;
        this.localName = localName;
        this.name = name;
        this.countryCode = countryCode;
        this.fixed = fixed;
        this.global = global;
        this.counties = counties;
        this.launchYear = launchYear;
        this.types = types;
    }

    public String getDate() {
        return date;
    }

    public String getLocalName() {
        return localName;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean getFixed() {
        return fixed;
    }

    public boolean getGlobal() {
        return global;
    }

    public String getCounties() {
        return counties;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public List<HolidayType> getTypes() {
        return types;
    }


    public void setDate( String date ) {
        this.date = date;
    }

    public void setLocalName( String localName ) {
        this.localName = localName;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public void setTypes( List<HolidayType> types ) {
        this.types = types;
    }

    public void setFixed( boolean fixed ) {
        this.fixed = fixed;
    }

    public void setGlobal( boolean global ) {
        this.global = global;
    }

    public void setCounties( String counties ) {
        this.counties = counties;
    }

    public void setLaunchYear( String launchYear ) {
        this.launchYear = launchYear;
    }

    @Override
    public String toString() {
        return "CountryResponse{" +
                "date='" + date + '\'' +
                ", localName='" + localName + '\'' +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", fixed=" + fixed +
                ", global=" + global +
                ", counties='" + counties + '\'' +
                ", launchYear='" + launchYear + '\'' +
                ", types=" + types +
                '}';
    }
}
