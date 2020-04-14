package it.fides.cinema.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;



public class ProiezioneDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3604594399487823769L;
	private Long id;	
	private Date dataProiezione;
	private Long postiDisponibili;
	private SalaDto sala;
	private FilmDto film;
	private Set<BigliettoDto> setBiglietti;
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
	public SalaDto getSala() {
		return sala;
	}
	public void setSala(SalaDto sala) {
		this.sala = sala;
	}
	public FilmDto getFilm() {
		return film;
	}
	public void setFilm(FilmDto film) {
		this.film = film;
	}
	public Set<BigliettoDto> getSetBiglietti() {
		return setBiglietti;
	}
	public void setSetBiglietti(Set<BigliettoDto> setBiglietti) {
		this.setBiglietti = setBiglietti;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
