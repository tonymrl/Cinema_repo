package it.fides.cinema.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Persona {
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column
	private String username;
	
	@Column
	private String password;

	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column(name = "DATA_NASCITA")
	private Date data_nascita;
	
	@Column
	private String email;
	
	@Column
	private String ruolo;

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}



	
	
	
	
	
}
