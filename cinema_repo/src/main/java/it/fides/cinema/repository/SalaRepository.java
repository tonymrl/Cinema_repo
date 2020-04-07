package it.fides.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Sala;


@Repository
public interface SalaRepository extends CrudRepository<Sala, Long>{

	public List<Sala> findByNomeSala(String nomeSala);
	
	
	@Query("select s from Sala s where lower(s.nomeSala) like %:nomeSalaInput% order by s.nomeSala")
	public List<Sala> findByNomeSalaLike(@Param("nomeSalaInput") String nomeSala);
	
	 
}
