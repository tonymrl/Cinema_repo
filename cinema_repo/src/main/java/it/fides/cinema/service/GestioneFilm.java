package it.fides.cinema.service;

import java.util.List;

import it.fides.cinema.dto.FilmDto;

public interface GestioneFilm {
	
	public FilmDto findByNome(String nomeFilm);

	FilmDto findById(Long id);

	List<FilmDto> getAllFilm();


	void addFilm(Long id, String titolo, String genere, String trama, String durata, String regista);
	
	void deleteFilm(Long id);
	

}
