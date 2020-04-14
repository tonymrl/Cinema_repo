package it.fides.cinema.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity                 //(name = "Sala") per cambiare nome da cercare
public class Sala {

	@Id
	@SequenceGenerator(name = "idGeneratorSala", sequenceName = "salaid_gen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGeneratorSala")
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "NOME_SALA")
	private String nomeSala;
	
	@Column(name = "NUMERO_POSTI")
	private Long numeroPosti;

	@JsonIgnore
	@OneToOne(mappedBy = "idSala")
	private Proiezione proiezione;

	@OneToMany(targetEntity = Posto.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "sala")
	@OrderBy("fila ASC, numero ASC")
	private Set<Posto> setPosti;

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

	public Proiezione getProiezione() {
		return proiezione;
	}

	public void setProiezione(Proiezione proiezione) {
		this.proiezione = proiezione;
	}

	public Set<Posto> getSetPosti() {
		return setPosti;
	}

	public void setSetPosti(Set<Posto> setPosti) {
		this.setPosti = setPosti;
	}

	
}
