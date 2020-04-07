package it.fides.cinema.dto;

import java.io.Serializable;
import java.util.Set;




public class BigliettoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -139883742683902897L;
	private Long id;
	private String fila;
	private Long NUMERO;
	private Set<ProiezioneDto> proiezioneSet;
	
	
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


	public Long getNUMERO() {
		return NUMERO;
	}


	public void setNUMERO(Long nUMERO) {
		NUMERO = nUMERO;
	}


	public Set<ProiezioneDto> getProiezioneSet() {
		return proiezioneSet;
	}


	public void setProiezioneSet(Set<ProiezioneDto> proiezioneSet) {
		this.proiezioneSet = proiezioneSet;
	}

	
	
	
}
