package model;

import java.util.ArrayList;
import java.util.List;

public class Vozilo {
    private Long id;
    private String model;
    private String registracija;

    private Korisnik korisnik; 
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
}
