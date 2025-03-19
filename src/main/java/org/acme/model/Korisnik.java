package org.acme.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Korisnik {
    @Id
    @SequenceGenerator(name = "korisnik_seq", sequenceName = "korisnik_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "korisnik_seq")
    private Long id;
    private String ime;
    private String prezime;
    private String email;

    @OneToMany(mappedBy = "korisnik")
    private List<Vozilo> vozila = new ArrayList<>();
    @ManyToMany
    private List<Kazna> kazne = new ArrayList<>();

    public Korisnik() {
    }

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
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(id, korisnik.id) && Objects.equals(ime, korisnik.ime) && Objects.equals(prezime, korisnik.prezime) && Objects.equals(email, korisnik.email) && Objects.equals(vozila, korisnik.vozila) && Objects.equals(kazne, korisnik.kazne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ime, prezime, email, vozila, kazne);
    }
}
