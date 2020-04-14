package it.fides.cinema.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Biglietto {
	
	@Id
	@SequenceGenerator(name = "idGeneratorBiglietto", sequenceName = "bigliettoid_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGeneratorBiglietto")
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
	private Persona idPersona;

	
<<<<<<< Updated upstream
	
	
	
	
	
	
=======
>>>>>>> Stashed changes
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

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}
<<<<<<< Updated upstream
	
	
	
=======
>>>>>>> Stashed changes
}
