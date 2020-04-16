package it.fides.cinema.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Proiezione implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1955159881619946867L;

	@Id
	@SequenceGenerator(name = "idGeneratorProiezione", sequenceName = "proiezioneid_gen", schema = "\"dario\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGeneratorProiezione")
	private Long id;

	@Column(name = "DATA_PROIEZIONE")
	private Date dataProiezione;

	@Column(name = "POSTI_DISPONIBILI")
	private Long postiDisponibili;

	/////////
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_SALA", referencedColumnName = "ID")
	private Sala idSala;
	/////

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_FILM", referencedColumnName = "ID")
	private Film idFilm;


	@OneToMany(targetEntity = Biglietto.class , fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "idProiezione")
	private Set<Biglietto> setBiglietti;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDataProiezione() {
		return dataProiezione;
	}


	public void setDataProiezione(Date dataProiezione) {
		this.dataProiezione = dataProiezione;
	}


	public Long getPostiDisponibili() {
		return postiDisponibili;
	}


	public void setPostiDisponibili(Long postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}


	public Sala getIdSala() {
		return idSala;
	}


	public void setIdSala(Sala idSala) {
		this.idSala = idSala;
	}


	public Film getIdFilm() {
		return idFilm;
	}


	public void setIdFilm(Film idFilm) {
		this.idFilm = idFilm;
	}


	public Set<Biglietto> getSetBiglietti() {
		return setBiglietti;
	}


	public void setSetBiglietti(Set<Biglietto> setBiglietti) {
		this.setBiglietti = setBiglietti;
	}


	

}
