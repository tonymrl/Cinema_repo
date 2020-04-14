package it.fides.cinema.service;

import java.util.List;




import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.dto.SearchSalaDto;
import it.fides.cinema.entity.Sala;

public interface GestioneSala {
	
	public List<SalaDto> getAllSala();

	public SalaDto findById(Long idSala);
	
	public void insertSala(SalaDto salaDto);

	public List<SalaDto> findByNomeSala(SearchSalaDto searchSalaDto);

	List<SalaDto> findByNomeSalaLike(SearchSalaDto searchSalaDto);
	
	public int getCountPosto(String nomeSala);

}
