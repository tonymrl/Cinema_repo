package it.fides.cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.ProiezioneDto;
import it.fides.cinema.service.GestioneProiezione;

@RestController
public class ProiezioneController {
	
	@Autowired
	GestioneProiezione gestioneProiezione;
	
	
	@GetMapping(value = "/postiDisponibili")
	public List<PostoDto> mostraPostiDisponibili(@RequestParam Long idProiezione){
		return gestioneProiezione.mostraPostiDisponibili(idProiezione);
	}
	
	@GetMapping(value = "/contaPostiDisponibili")
	public Long contaPostiDisponibili(@RequestParam Long idProiezione){
		return gestioneProiezione.contaPostiDisponibili(idProiezione);
	}
	
	
	@GetMapping("allProiezione")
		public List<ProiezioneDto> allProiezione(){
		return gestioneProiezione.getAllProiezione();
	}

}
