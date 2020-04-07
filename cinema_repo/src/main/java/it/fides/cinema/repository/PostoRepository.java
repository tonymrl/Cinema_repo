package it.fides.cinema.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fides.cinema.entity.Posto;


@Repository
public interface PostoRepository extends CrudRepository<Posto, Long> {

}
