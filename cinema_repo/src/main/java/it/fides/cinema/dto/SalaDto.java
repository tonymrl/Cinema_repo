package it.fides.cinema.dto;

import java.io.Serializable;
import java.util.Set;



public class SalaDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7736529611799169481L;
	private Long id;
	private String nomeSala;
	private Long numeroPosti;
	private Set<PostoDto> setPosti;
	private ProiezioneDto proiezione;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public Long getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(Long numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	public Set<PostoDto> getSetPosti() {
		return setPosti;
	}
	public void setSetPosti(Set<PostoDto> setPosti) {
		this.setPosti = setPosti;
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



