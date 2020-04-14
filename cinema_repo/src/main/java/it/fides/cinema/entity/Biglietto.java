package it.fides.cinema.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Biglietto {
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column
	private String fila;
	
	@Column 
	private Long numero;
	
	@ManyToOne
	@JoinColumn (name ="id_proiezione", referencedColumnName = "id") //id proiezione è il nome della foreign key nel db e si riferisce ad una colonna id di proiezione
	private Proiezione idProiezione;
	
	@ManyToOne
	@JoinColumn (name ="id_persona", referencedColumnName = "id")
	private Persona persona;

	
	
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

	public Proiezione getIdProiezione() {
		return idProiezione;
	}

	public void setIdProiezione(Proiezione idProiezione) {
		this.idProiezione = idProiezione;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	

	
	
}
