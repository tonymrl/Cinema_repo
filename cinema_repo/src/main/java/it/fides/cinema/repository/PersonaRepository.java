package it.fides.cinema.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Persona;


@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
	
	Persona findByUsernameAndPassword(String username, String password);
	
	

}
