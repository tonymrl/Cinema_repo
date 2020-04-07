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
	private String FILA;
	
	@Column 
	private Long NUMERO;
	
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

	public String getFILA() {
		return FILA;
	}

	public void setFILA(String fILA) {
		FILA = fILA;
	}

	public Long getNUMERO() {
		return NUMERO;
	}

	public void setNUMERO(Long nUMERO) {
		NUMERO = nUMERO;
	}

	public Proiezione getProiezione() {
		return idProiezione;
	}

	public void setProiezione(Proiezione proiezione) {
		this.idProiezione = proiezione;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
}
