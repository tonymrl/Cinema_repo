package it.fides.cinema.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.LoginDto;
import it.fides.cinema.dto.PersonaDto;
import it.fides.cinema.enumeration.RuoloEnum;
import it.fides.cinema.service.GestionePersona;

@RestController
public class GestionePersonaController {

	@Autowired
	private GestionePersona gestionePersona;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpServletRequest request){

		PersonaDto persona= gestionePersona.findUser(loginDto);

		if(persona != null) {	
			HttpSession httpSession= request.getSession();
			httpSession.setAttribute("ruolo", persona.getRuolo());
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}
	
	
	
	


	@PostMapping(value = "/loginAdmin")
	public ResponseEntity<?> loginAdmin(@RequestBody LoginDto loginDto, HttpServletRequest request){

		PersonaDto persona= gestionePersona.findUser(loginDto);
		HttpSession httpSession= request.getSession();
		httpSession.setAttribute("ruolo", persona.getRuolo());
		String ruolo= (String) httpSession.getAttribute("ruolo");
		
		if(RuoloEnum.ADMIN.ruolo().equals(ruolo)) {
			return ResponseEntity.ok(HttpStatus.OK);

		}else {
			System.out.println("errore: " +"'"+ ruolo+"'" + " non ha i permessi per accedere");
			loginDto.setUsername("");
			loginDto.setPassword("");
			httpSession.invalidate();
			httpSession.removeAttribute("ruolo");
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	
		}


	}


	
	
	
	@PostMapping(value = "/logout")
	public ResponseEntity<?> login(HttpServletRequest request){


		HttpSession httpSession= request.getSession();
		httpSession.removeAttribute("ruolo");
		httpSession.invalidate();
		return ResponseEntity.ok(HttpStatus.OK);


	}
}
