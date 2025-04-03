package org.acme.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class ParkingMjesto {
    @Id
    @SequenceGenerator(name = "parking_mjesto_seq", sequenceName = "parking_mjesto_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_mjesto_seq")
    private Long id;
    private String oznaka;
    private boolean zauzeto;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;
    @OneToMany(mappedBy = "parkingMjesto", cascade = CascadeType.ALL)
    private Set<Rezervacija> rezervacije = new HashSet<>();

    public ParkingMjesto() {
    }

    public ParkingMjesto(Long id, String oznaka, boolean zauzeto, Parking parking, Set<Rezervacija> rezervacije) {
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

    public Set<Rezervacija> getRezervacije() { return rezervacije; }
    public void setRezervacije(Set<Rezervacija> rezervacije) { this.rezervacije = rezervacije; }

    @Override
    public String toString() {
        return "ParkingMjesto{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", zauzeto=" + zauzeto +
                ", parking=" + parking +
                ", rezervacije=" + rezervacije +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParkingMjesto that = (ParkingMjesto) o;
        return zauzeto == that.zauzeto && Objects.equals(id, that.id) && Objects.equals(oznaka, that.oznaka) && Objects.equals(parking, that.parking) && Objects.equals(rezervacije, that.rezervacije);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, oznaka, zauzeto, parking, rezervacije);
    }
}