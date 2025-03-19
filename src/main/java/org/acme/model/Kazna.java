package org.acme.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Kazna {
    @Id
    @SequenceGenerator(name = "kazna_seq", sequenceName = "kazna_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kazna_seq")
    private Long id;
    private String opis;
    private Double iznos;

    @ManyToMany(mappedBy = "kazne")
    private List<Korisnik> korisnici = new ArrayList<>();

    public Kazna() {}

    public Kazna(Long id, String opis, Double iznos, List<Korisnik> korisnici) {
        this.id = id;
        this.opis = opis;
        this.iznos = iznos;
            this.korisnici = korisnici;
        }
        
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }

    public Double getIznos() { return iznos; }
    public void setIznos(Double iznos) { this.iznos = iznos; }

    public List<Korisnik> getKorisnici() { return korisnici; }
    public void setKorisnici(List<Korisnik> korisnici) { this.korisnici = korisnici; }

    @Override
    public String toString() {
        return "Kazna{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                ", iznos=" + iznos +
                ", korisnici=" + korisnici +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Kazna kazna = (Kazna) o;
        return Objects.equals(id, kazna.id) && Objects.equals(opis, kazna.opis) && Objects.equals(iznos, kazna.iznos) && Objects.equals(korisnici, kazna.korisnici);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, opis, iznos, korisnici);
    }
}
