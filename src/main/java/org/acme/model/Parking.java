package org.acme.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Parking {
    @Id
    @SequenceGenerator(name = "parking_seq", sequenceName = "parking_seq", allocationSize = 1)
    @GeneratedValue(generator = "parking_seq")
    private Long id;
    private String naziv;
    private String lokacija;

    @OneToMany(mappedBy = "parking")
    private List<ParkingMjesto> parkingMjesta = new ArrayList<>();

    public Parking() {
    }

    public Parking(Long id, String naziv, String lokacija, List<ParkingMjesto> parkingMjesta) {
        this.id = id;
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.parkingMjesta = parkingMjesta;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getLokacija() { return lokacija; }
    public void setLokacija(String lokacija) { this.lokacija = lokacija; }

    public List<ParkingMjesto> getParkingMjesta() { return parkingMjesta; }
    public void setParkingMjesta(List<ParkingMjesto> parkingMjesta) { this.parkingMjesta = parkingMjesta; }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", lokacija='" + lokacija + '\'' +
                ", parkingMjesta=" + parkingMjesta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Objects.equals(id, parking.id) && Objects.equals(naziv, parking.naziv) && Objects.equals(lokacija, parking.lokacija) && Objects.equals(parkingMjesta, parking.parkingMjesta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, lokacija, parkingMjesta);
    }
}
