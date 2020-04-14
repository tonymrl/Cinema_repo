package it.fides.cinema.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Film {
	
	@Id
	@SequenceGenerator(name = "idGenerator", sequenceName = "filmid_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
	@OrderBy("id ASC")
	private Long id;
	
	@Column
	private String titolo;
	
	@Column
	private String genere;
	
	@Column
	private String trama;
	
	@Column
	private String durata;
	
	@Column
	private String regista;
	
	
	@OneToOne(mappedBy = "idFilm")
	@JsonIgnore
	private Proiezione proiezione;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	public String getTrama() {
		return trama;
	}


	public void setTrama(String trama) {
		this.trama = trama;
	}


	public String getDurata() {
		return durata;
	}


	public void setDurata(String durata) {
		this.durata = durata;
	}


	public String getRegista() {
		return regista;
	}


	public void setRegista(String regista) {
		this.regista = regista;
	}


	public Proiezione getProiezione() {
		return proiezione;
	}


	public void setProiezione(Proiezione proiezione) {
		this.proiezione = proiezione;
	}
	

}
