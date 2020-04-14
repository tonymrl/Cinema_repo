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
private Set<PostoDto> postoSet;
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

public Set<PostoDto> getPostoSet() {
	return postoSet;
}
public void setPostoSet(Set<PostoDto> postoSet) {
	this.postoSet = postoSet;
}
public Long getNumeroPosti() {
	return numeroPosti;
}
public void setNumeroPosti(Long numeroPosti) {
	this.numeroPosti = numeroPosti;
}
public ProiezioneDto getProiezione() {
	return proiezione;
}
public void setProiezione(ProiezioneDto proiezione) {
	this.proiezione = proiezione;
}


}



