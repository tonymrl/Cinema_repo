package it.fides.cinema.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Posto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "POSTO_SEQ")
	@SequenceGenerator(name = "POSTO_SEQ",sequenceName = "POSTO_SEQ",allocationSize = 1)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Column
	private String fila;

	@Column
	private Long numero;
	
	
	@ManyToOne(targetEntity = Sala.class,cascade = CascadeType.PERSIST)
	@JoinColumn (name ="ID_SALA", referencedColumnName = "ID")
	@JsonIgnore
	private Sala sala;


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


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
	
	

	
	
}
