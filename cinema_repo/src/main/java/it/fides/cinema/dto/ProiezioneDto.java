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
<<<<<<< Updated upstream
	Date data_proiezione;
	Long postiDisponibili;
	private Sala sala;
	private Film film;
	private Set<BigliettoDto> bigliettiSet;
	
	
	
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




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public ProiezioneDto() {
		// TODO Auto-generated constructor stub
	}




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




	public Set<BigliettoDto> getBigliettiSet() {
		return bigliettiSet;
	}




	public void setBigliettiSet(Set<BigliettoDto> bigliettiSet) {
		this.bigliettiSet = bigliettiSet;
=======
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
>>>>>>> Stashed changes
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
