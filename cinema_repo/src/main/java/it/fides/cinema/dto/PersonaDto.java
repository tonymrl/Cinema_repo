package it.fides.cinema.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;




public class PersonaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date dataNascita;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String email;
	private String ruolo;
	private Set<BigliettoDto> setBiglietti;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
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
