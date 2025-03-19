package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Rezervacija {
    @Id
    private Long id;
    private Date datumOd;
    private Date datumDo;

    @ManyToOne
    @JoinColumn(name = "parking_mjesto_id")
    private ParkingMjesto parkingMjesto;
    @ManyToOne
    private Vozilo vozilo;


    public Rezervacija() {
    }

    public Rezervacija(Long id, Date datumOd, Date datumDo, ParkingMjesto parkingMjesto, Vozilo vozilo) {
        this.id = id;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.parkingMjesto = parkingMjesto;
        this.vozilo = vozilo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getDatumOd() { return datumOd; }
    public void setDatumOd(Date datumOd) { this.datumOd = datumOd; }

    public Date getDatumDo() { return datumDo; }
    public void setDatumDo(Date datumDo) { this.datumDo = datumDo; }

    public ParkingMjesto getParkingMjesto() { return parkingMjesto; }
    public void setParkingMjesto(ParkingMjesto parkingMjesto) { this.parkingMjesto = parkingMjesto; }

    public Vozilo getVozilo() { return vozilo; }
    public void setVozilo(Vozilo vozilo) { this.vozilo = vozilo; }

    @Override
    public String toString() {
        return "Rezervacija{" +
                "id=" + id +
                ", datumOd=" + datumOd +
                ", datumDo=" + datumDo +
                ", parkingMjesto=" + parkingMjesto +
                ", vozilo=" + vozilo +
                '}';
    }
}
