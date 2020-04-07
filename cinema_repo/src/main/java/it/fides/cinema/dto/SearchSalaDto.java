package it.fides.cinema.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class SearchSalaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4721832370141906597L;
	@NotBlank(message = "nome sala obbligatorio")
	String nomeSala;

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	
	
}
