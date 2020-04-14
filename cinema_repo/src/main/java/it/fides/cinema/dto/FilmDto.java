package it.fides.cinema.dto;

import java.io.Serializable;

public class FilmDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2766010974535992321L;
	/**
	 * 
	 */
	
	private Long id;
	private String titolo;
	private String genere;
	private String trama;
	private String durata;
	private String regista;
	private ProiezioneDto proiezione;
	
	public FilmDto() {
		// TODO Auto-generated constructor stub
	}

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

	public ProiezioneDto getProiezione() {
		return proiezione;
	}

	public void setProiezione(ProiezioneDto proiezione) {
		this.proiezione = proiezione;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
