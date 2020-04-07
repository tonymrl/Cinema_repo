package it.fides.cinema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.enumeration.RuoloEnum;
//import it.fides.cinema.repository.FilmRepository;
import it.fides.cinema.service.GestioneFilm;

@RestController
@Transactional
public class GestioneFilmController {
	@Autowired
	private GestioneFilm gestioneFilm;
	//private FilmRepository filmRepository;


	@GetMapping("/findFilm")
	public FilmDto film(@RequestParam String nomeFilm) {
		return gestioneFilm.findByNome(nomeFilm);
	}


	@GetMapping("/findIdFilm")
	public FilmDto filmId(@RequestParam Long Id) {
		return gestioneFilm.findById(Id);
	}


	@GetMapping("/allFilm")
	public List<FilmDto> allFilm(){
		return gestioneFilm.getAllFilm();
	}



	@PostMapping("/insertFilm")
	public void insertFilm(@RequestBody FilmDto filmDto,HttpServletRequest request) {
		HttpSession session=request.getSession();
		String ruolo= (String) session.getAttribute("ruolo");

		if(RuoloEnum.ADMIN.ruolo().equals(ruolo)) {
			System.out.println("inserito: " +"'"+ ruolo+"'" + " ha inserito correttamente");
			gestioneFilm.addFilm(filmDto.getId(),filmDto.getTitolo(),filmDto.getGenere(),filmDto.getTrama(),filmDto.getDurata(),filmDto.getRegista());
			
		}
		else
		System.out.println("non inserito: " +"'"+ ruolo+"'" + " non ha i permessi per inserire");

		
	}



	@DeleteMapping("/deleteFilm")
	public void deleteFilm(@RequestParam Long id) {
		gestioneFilm.deleteFilm(id);
	}

}


