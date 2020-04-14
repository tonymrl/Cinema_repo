package it.fides.cinema.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.dto.SearchSalaDto;
import it.fides.cinema.service.GestioneSala;




@RestController
public class GestioneSalaController {
	
	@Autowired
	private GestioneSala gestioneSala;
	
	@GetMapping("/allSala")
	public List<SalaDto> allSala(){
		return gestioneSala.getAllSala();
	}
	
<<<<<<< Updated upstream
	@GetMapping(value = "/findByIdSala")
	public SalaDto idSala(@RequestParam Long idSala) {
=======
	@GetMapping(value = "/findByIdSala/{id}")
	public SalaDto idSala(@PathVariable(value = "id") Long idSala) {
>>>>>>> Stashed changes
	return gestioneSala.findById(idSala);
	}
	
	
	
	@PostMapping(value = "/insertSala")
	public void insertSala(@RequestBody SalaDto salaDto) {
		gestioneSala.insertSala(salaDto);
	}
	
	@PostMapping(value = "searchSala")
	public ResponseEntity<?> searchSala(@Valid @RequestBody SearchSalaDto searchSalaDto, Errors errors){
		
		List<SalaDto> result= gestioneSala.findByNomeSala(searchSalaDto);
		return ResponseEntity.ok(result);
		
	}
	

	
}






















//	@GetMapping(value = "/porco")
//	public String hello(@RequestParam Long idSala) {
//		return "hello" + idSala;
//	}
//
//
//	@PostMapping(value = "/post")
//	 public @ResponseBody ResponseEntity<String> post() {
//	  return new ResponseEntity<String> ("post", HttpStatus.OK);
//	 }