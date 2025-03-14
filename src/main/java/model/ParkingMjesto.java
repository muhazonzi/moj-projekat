package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingMjesto {
    private Long id;
    private String oznaka;
    private boolean zauzeto;

    private Parking parking; 
    private List<Rezervacija> rezervacije = new ArrayList<>();

    public ParkingMjesto(Long id, String oznaka, boolean zauzeto, Parking parking, List<Rezervacija> rezervacije) {
        this.id = id;
        this.oznaka = oznaka;
        this.zauzeto = zauzeto;
        this.parking = parking;
        this.rezervacije = rezervacije;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOznaka() { return oznaka; }
    public void setOznaka(String oznaka) { this.oznaka = oznaka; }

    public boolean isZauzeto() { return zauzeto; }
    public void setZauzeto(boolean zauzeto) { this.zauzeto = zauzeto; }

    public Parking getParking() { return parking; }
    public void setParking(Parking parking) { this.parking = parking; }

    public List<Rezervacija> getRezervacije() { return rezervacije; } 
    public void setRezervacije(List<Rezervacija> rezervacije) { this.rezervacije = rezervacije; }

    @Override
    public String toString() {
        return "ParkingMjesto{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", zauzeto=" + zauzeto +
                ", parking=" + parking +
                ", rezervacije=" + rezervacije +
                '}';
    };

}
