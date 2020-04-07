package it.fides.cinema.controller;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.service.GestionePosto;


@RestController
public class GestionePostoController {
	
	@Autowired
	private GestionePosto gestionePosto;
	
	@GetMapping(value = "/listaPosti")
	public Set<PostoDto> mostraPosti(@RequestParam String nomeSala){
		return gestionePosto.showPosti(nomeSala); 
	}
}
