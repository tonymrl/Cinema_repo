package it.fides.cinema.service;


import java.util.Set;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.SalaDto;

public interface GestionePosto {
	public Set<PostoDto> showPosti(String nomeSala);

	Set<PostoDto> generatePosti(SalaDto sala);


}
