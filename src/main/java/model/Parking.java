package model;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private Long id;
    private String naziv;
    private String lokacija;

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
    };
}
