package it.fides.cinema.dto;

import java.io.Serializable;




public class BigliettoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -139883742683902897L;
	private Long id;
	private String fila;
<<<<<<< Updated upstream
	private Long NUMERO;
	private Set<ProiezioneDto> proiezioneSet;
	
=======
	private Long numero;
	private ProiezioneDto proiezione;
	private PersonaDto persona;
>>>>>>> Stashed changes
	
	public BigliettoDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	public void setId(Long id) {
		this.id = id;
	}

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	public String getFila() {
		return fila;
	}

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	public void setFila(String fila) {
		this.fila = fila;
	}

<<<<<<< Updated upstream

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

	
	
	
=======
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

	
>>>>>>> Stashed changes
}
