package it.fides.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Biglietto;


@Repository
public interface BigliettoRepository extends CrudRepository<Biglietto, Long> {

}
