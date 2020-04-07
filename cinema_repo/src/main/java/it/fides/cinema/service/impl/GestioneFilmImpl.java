package it.fides.cinema.service.impl;


import java.util.ArrayList;

import java.util.List;


import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.FilmDto;

import it.fides.cinema.entity.Film;

import it.fides.cinema.repository.FilmRepository;
import it.fides.cinema.service.GestioneFilm;
@Service
@Transactional
public class GestioneFilmImpl implements GestioneFilm {

	@Autowired
	FilmRepository filmRepository;

	@Override
	public FilmDto findByNome(String nomeFilm) {
		FilmDto filmDto= new FilmDto();

		for (Film film: filmRepository.findAll()) {
			filmDto.setId(film.getId());
			filmDto.setGenere(film.getGenere());
			filmDto.setDurata(film.getDurata());
			filmDto.setRegista(film.getRegista());
			filmDto.setTitolo(film.getTitolo());
			filmDto.setTrama(film.getTrama());

			if(film.getTitolo().equals(nomeFilm))
				return filmDto;


		}
		return filmDto;

	}

	
	
/*	@Override
	public FilmDto findById(Long id) {
		FilmDto filmDto=new FilmDto(); 
		filmDto.setTitolo(filmRepository.findById(id).get().getTitolo());
		filmDto.setGenere(filmRepository.findById(id).get().getGenere());
		filmDto.setDurata(filmRepository.findById(id).get().getDurata());
		filmDto.setTrama(filmRepository.findById(id).get().getTrama());
		filmDto.setRegista(filmRepository.findById(id).get().getRegista());
		filmDto.setId(filmRepository.findById(id).get().getId());
		return filmDto;
	}	
*/	
	
	//dozer mapping//
	public FilmDto findById(Long id) {
		Film film=new Film();
		film=filmRepository.findById(id).get();
		FilmDto filmDto=new DozerBeanMapper().map(film, FilmDto.class); 
				
		return filmDto;
	}
	
	
	
	
	@Override
	public List<FilmDto> getAllFilm() {
        List<FilmDto> listafilmDto = new ArrayList<>();
        for (Film film: filmRepository.findByOrderByIdAsc()) {
            FilmDto filmDto=new FilmDto();
            filmDto.setId(film.getId());
			filmDto.setGenere(film.getGenere());
			filmDto.setDurata(film.getDurata());
			filmDto.setRegista(film.getRegista());
			filmDto.setTitolo(film.getTitolo());
			filmDto.setTrama(film.getTrama());
            listafilmDto.add(filmDto);
        }
        return listafilmDto;
    }
	
	
	
	@Override
	public void addFilm(Long id,String titolo, String genere,String trama, String durata,String regista) {
		Film film=new Film();
		
		film.setId(id);
		film.setTitolo(titolo);
		film.setGenere(genere);
		film.setTrama(trama);
		film.setDurata(durata);
		film.setRegista(regista);
		
		filmRepository.save(film);
		
		
	}



	@Override
	public void deleteFilm(Long id) {
		filmRepository.deleteById(id);
		
	}
	
	





}
