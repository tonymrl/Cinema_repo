package it.fides.cinema.dto;

import java.io.Serializable;

import org.dozer.Mapping;

public class PostoDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6077864272206253419L;
	private Long id;
	private String fila;
	private Long numero;
	@Mapping("sala")
	private SalaDto sala;
	
	
	
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
	public SalaDto getSala() {
		return sala;
	}
	public void setSala(SalaDto sala) {
		this.sala = sala;
	}
	
	

	


	
}
