package org.acme.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class KorisnikKazna {

	@Id
	@SequenceGenerator(name = "korisnikkazna_seq", sequenceName = "korisnikkazna_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "korisnikkazna_seq")
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	Korisnik korisnik;

	@ManyToOne(cascade = CascadeType.ALL)
	Kazna kazna;

	public KorisnikKazna() {
		super();
	}

	public KorisnikKazna(Korisnik korisnik, Kazna kazna) {
		super();
		this.korisnik = korisnik;
		this.kazna = kazna;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Kazna getKazna() {
		return kazna;
	}

	public void setKazna(Kazna kazna) {
		this.kazna = kazna;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kazna == null) ? 0 : kazna.hashCode());
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KorisnikKazna other = (KorisnikKazna) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kazna == null) {
			if (other.kazna != null)
				return false;
		} else if (!kazna.equals(other.kazna))
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KorisnikKazna [id=" + id + ", korisnik=" + korisnik + ", kazna=" + kazna + "]";
	}
}
