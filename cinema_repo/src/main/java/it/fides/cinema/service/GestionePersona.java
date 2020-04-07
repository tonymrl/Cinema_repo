package it.fides.cinema.service;

import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;

public interface GestionePersona {

	PersonaDto findUser(LoginDto loginDto);


}
