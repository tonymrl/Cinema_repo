package it.fides.cinema.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Proiezione;


@Repository
public interface ProiezioneRepository extends CrudRepository<Proiezione, Long>{

	@Query(value = "select * from (select p.id as id, p.fila as fila, p.numero as numero from posto p, sala s, proiezione pro where p.id_sala = s.id and pro.id_sala = s.id and pro.id = :idProiezione and (p.fila, p.numero) NOT IN ( select b1.fila, b1.numero from biglietto b1, proiezione p1 where b1.id_proiezione = p1.id and p1.id = :idProiezione))", nativeQuery = true)
	public List<OnlyPosto> ottieniPostiLiberi(@Param("idProiezione") Long idProiezione);

	//List<Posto> getPostiDisponibili(@Param("idProiezione") Long idProiezione);
	
	@Query(value = "select count(*) from (select p.id, p.numero, p.fila from posto p, sala s, proiezione pro where p.id_sala = s.id and pro.id_sala = s.id and pro.id = :idProiezione and (p.fila, p.numero) NOT IN ( select b1.fila, b1.numero from biglietto b1, proiezione p1 where b1.id_proiezione = p1.id and p1.id = :idProiezione))", nativeQuery = true)
	public Long contaPostiLiberi(@Param("idProiezione") Long idProiezione);

	public static interface OnlyPosto{
		Long getId();
		String getFila();
		Long getNumero();
	}
	
	
}
