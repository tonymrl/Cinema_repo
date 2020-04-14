package it.fides.cinema.dto;

import java.io.Serializable;




public class BigliettoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -139883742683902897L;
	private Long id;
	private String fila;
	private Long numero;
	private ProiezioneDto proiezione;
	private PersonaDto persona;
	
	public BigliettoDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public ProiezioneDto getProiezione() {
		return proiezione;
	}

	public void setProiezione(ProiezioneDto proiezione) {
		this.proiezione = proiezione;
	}

	public PersonaDto getPersona() {
		return persona;
	}

	public void setPersona(PersonaDto persona) {
		this.persona = persona;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
