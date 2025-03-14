package model;

import java.util.ArrayList;
import java.util.List;

public class Korisnik {
    private Long id;
    private String ime;
    private String prezime;
    private String email;

    private List<Vozilo> vozila = new ArrayList<>();
    private List<Kazna> kazne = new ArrayList<>();

    public Korisnik(Long id, String ime, String prezime, String email, List<Vozilo> vozila, List<Kazna> kazne) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.vozila = vozila;
        this.kazne = kazne;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Vozilo> getVozila() { return vozila; }
    public void setVozila(List<Vozilo> vozila) { this.vozila = vozila; }

    public List<Kazna> getKazne() { return kazne; }
    public void setKazne(List<Kazna> kazne) { this.kazne = kazne; }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", vozila=" + vozila +
                ", kazne=" + kazne +
                '}';
    };
}
