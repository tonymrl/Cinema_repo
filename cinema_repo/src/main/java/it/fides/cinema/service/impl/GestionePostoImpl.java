package it.fides.cinema.service.impl;

import java.util.HashSet;



import java.util.Set;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.PostoDto;

import it.fides.cinema.entity.Posto;
import it.fides.cinema.repository.PostoRepository;
import it.fides.cinema.service.GestionePosto;


@Service
@Transactional
public class GestionePostoImpl implements GestionePosto {

	@Autowired
	private PostoRepository postoRepository;
	
	@Override
	public Set<PostoDto> showPosti(String nomeSala) {
		Set<PostoDto> setPosti = new HashSet<PostoDto>();
		
		for (Posto posto : postoRepository.findAll()) {
			PostoDto postoDto = new PostoDto();
			postoDto.setFila(posto.getFila());
			postoDto.setId(posto.getId());
			postoDto.setNumero(posto.getNumero());
			if(posto.getSala().getNomeSala().equalsIgnoreCase(nomeSala))
				setPosti.add(postoDto);
		}
		
		return setPosti;
	}
	
	
	
	


}
