package it.fides.cinema.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Proiezione {
	@Id
	@Column(name = "id")
	private Long id;	

	@Column(name = "DATA_PROIEZIONE")
	Date data_proiezione;

	@Column(name = "POSTI_DISPONIBILI")
	Long postiDisponibili;

	/////////
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_SALA", referencedColumnName = "ID")
	private Sala sala;
	/////

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_FILM", referencedColumnName = "ID")
	private Film film;


	@OneToMany(targetEntity = Biglietto.class , fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idProiezione")
	private Set<Biglietto> BigliettiSet;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getData_proiezione() {
		return data_proiezione;
	}


	public void setData_proiezione(Date data_proiezione) {
		this.data_proiezione = data_proiezione;
	}


	public Long getPostiDisponibili() {
		return postiDisponibili;
	}


	public void setPostiDisponibili(Long postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}


	public Film getFilm() {
		return film;
	}


	public void setFilm(Film film) {
		this.film = film;
	}


	public Set<Biglietto> getBigliettiSet() {
		return BigliettiSet;
	}


	public void setBigliettiSet(Set<Biglietto> bigliettiSet) {
		BigliettiSet = bigliettiSet;
	}










}
