package org.acme.model.dto;

import java.util.List;

public class CountryResDto {
    private String date;
    private String localName;
    private String name;
    private String countryCode;
    private boolean fixed;
    private boolean global;
    private String counties;
    private String launchYear;
    private List<String> types;

    public CountryResDto() {
    }

    public CountryResDto( String date, String localName, String name, String countryCode, boolean fixed,
            boolean global, String counties, String launchYear, List<String> types ) {
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

    public boolean isFixed() {
        return fixed;
    }

    public boolean isGlobal() {
        return global;
    }

    public String getCounties() {
        return counties;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public List<String> getTypes() {
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

    public void setTypes( List<String> types ) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "CountryResDto{" +
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
