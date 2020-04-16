package it.fides.cinema.service.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.entity.Persona;

public class MappatoreImpl{
	Mapper mapper = new DozerBeanMapper();
	
	public static PersonaDto convertToPersonaDto(Persona persona) {
		PersonaDto dto = new PersonaDto();
		
		return dto;
	}

}