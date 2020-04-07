package it.fides.cinema.service;

import java.util.List;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.ProiezioneDto;

public interface GestioneProiezione {
	public List<ProiezioneDto> getAllProiezione();

	public Long contaPostiDisponibili(Long idProiezione);

	public List<PostoDto> mostraPostiDisponibili(Long idProiezione);

}
