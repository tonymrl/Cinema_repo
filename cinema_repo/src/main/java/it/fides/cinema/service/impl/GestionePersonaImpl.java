package it.fides.cinema.service.impl;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.entity.Persona;
import it.fides.cinema.repository.PersonaRepository;
import it.fides.cinema.service.GestionePersona;
@Service
@Transactional
public class GestionePersonaImpl implements GestionePersona {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public PersonaDto findUser(LoginDto loginDto) {
		Persona persona = personaRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		
		PersonaDto personaDto=new PersonaDto();
		personaDto.setRuolo(persona.getRuolo());
		
		return personaDto;
	}

	
	
}
