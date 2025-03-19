package model;

import java.util.ArrayList;
import java.util.List;

public class Kazna {
    private Long id;
    private String opis;
    private Double iznos;

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
    };
}
