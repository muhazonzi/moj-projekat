package org.acme.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Vozilo {
    @Id
    private Long id;
    private String model;
    private String registracija;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;
    @OneToMany(mappedBy = "vozilo")
    private List<Rezervacija> rezervacije = new ArrayList<>();


    public Vozilo() {
    }

    public Vozilo(Long id, String model, String registracija, Korisnik korisnik, List<Rezervacija> rezervacije) {
        this.id = id;
        this.model = model;
        this.registracija = registracija;
        this.korisnik = korisnik;
        this.rezervacije = rezervacije;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getRegistracija() { return registracija; }
    public void setRegistracija(String registracija) { this.registracija = registracija; }

    public Korisnik getKorisnik() { return korisnik; }
    public void setKorisnik(Korisnik korisnik) { this.korisnik = korisnik; }

    public List<Rezervacija> getRezervacije() { return rezervacije; }
    public void setRezervacije(List<Rezervacija> rezervacije) { this.rezervacije = rezervacije; }

    @Override
    public String toString() {
        return "Vozilo{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", registracija='" + registracija + '\'' +
                ", korisnik=" + korisnik +
                ", rezervacije=" + rezervacije +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vozilo vozilo = (Vozilo) o;
        return Objects.equals(id, vozilo.id) && Objects.equals(model, vozilo.model) && Objects.equals(registracija, vozilo.registracija) && Objects.equals(korisnik, vozilo.korisnik) && Objects.equals(rezervacije, vozilo.rezervacije);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, registracija, korisnik, rezervacije);
    }
}
