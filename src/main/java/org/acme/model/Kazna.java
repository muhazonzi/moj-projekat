package org.acme.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = Kazna.GET_ALL_KAZNE, query = "SELECT k FROM Kazna k"),
        @NamedQuery(name = Kazna.GET_KAZNE_BY_OPIS, query = "SELECT k FROM Kazna k WHERE k.opis = :opis")
})
public class Kazna {

    public static final String GET_ALL_KAZNE = "Kazna.getAllKazne";
    public static final String GET_KAZNE_BY_OPIS = "Kazna.getKazneByOpis";
    @Id
    @SequenceGenerator(name = "kazna_seq", sequenceName = "kazna_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kazna_seq")
    private Long id;
    private String opis;
    private Double iznos;


    public Kazna() {}

    public Kazna(Long id, String opis, Double iznos) {
        this.id = id;
        this.opis = opis;
        this.iznos = iznos;
        }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }

    public Double getIznos() { return iznos; }
    public void setIznos(Double iznos) { this.iznos = iznos; }


    @Override
    public String toString() {
        return "Kazna{" +
                "id=" + id +
                ", opis='" + opis + '\'' +
                ", iznos=" + iznos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Kazna kazna = (Kazna) o;
        return Objects.equals(id, kazna.id) && Objects.equals(opis, kazna.opis) && Objects.equals(iznos, kazna.iznos);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, opis, iznos);
    }
}
