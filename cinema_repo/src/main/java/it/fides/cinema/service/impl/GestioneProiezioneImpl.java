package it.fides.cinema.service.impl;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.FilmDto;
import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.ProiezioneDto;
import it.fides.cinema.dto.SalaDto;
//import it.fides.cinema.dto.SearchSalaDto;
import it.fides.cinema.entity.Proiezione;
import it.fides.cinema.repository.ProiezioneRepository;
import it.fides.cinema.repository.ProiezioneRepository.OnlyPosto;
import it.fides.cinema.service.GestioneProiezione;



@Service
@Transactional
public class GestioneProiezioneImpl implements GestioneProiezione {

	@Autowired
	GestioneSalaImpl gestioneSalaImpl;
	
	@Autowired
	ProiezioneRepository proiezioneRepository;
	
	public List<ProiezioneDto> getAllProiezione(){
		
		List<ProiezioneDto> listaProiezioniDto=new ArrayList<>();
		
		for ( Proiezione proiezione : proiezioneRepository.findAll()) {
			
			ProiezioneDto proiezioneDto=new ProiezioneDto();
			proiezioneDto.setId(proiezione.getId());
<<<<<<< Updated upstream
			proiezioneDto.setData_proiezione(proiezione.getData_proiezione());
			
			int countPosto=gestioneSalaImpl.getCountPosto(proiezione.getSala().getNomeSala());  //restituisce tutti i posti della sala a cui è associata la proiezione
			proiezioneDto.setPostiDisponibili((long) countPosto);
			
			proiezioneDto.setSala(proiezione.getSala());
			proiezioneDto.setFilm(proiezione.getFilm());
			listaProiezioniDto.add(proiezioneDto);
		
			
			
			System.out.println("countPostoProiezione: "+countPosto + " di: "+proiezione.getSala().getNomeSala());
=======
			proiezioneDto.setDataProiezione(proiezione.getDataProiezione());
			proiezioneDto.setPostiDisponibili(proiezioneRepository.contaPostiLiberi(proiezione.getId()));
			
			SalaDto salaDto = new SalaDto();
			salaDto.setNomeSala(proiezione.getIdSala().getNomeSala());
			proiezioneDto.setSala(salaDto);
>>>>>>> Stashed changes
			
			FilmDto filmDto = new FilmDto();
			filmDto.setTitolo(proiezione.getIdFilm().getTitolo());
			proiezioneDto.setFilm(filmDto);
			
			listaProiezioniDto.add(proiezioneDto);			
		}
		
		return listaProiezioniDto;
		
	}
	
	@Override
	public List<PostoDto> mostraPostiDisponibili(Long idProiezione) {
		
		List<OnlyPosto> posti = proiezioneRepository.ottieniPostiLiberi(idProiezione);
		List<PostoDto> postiDisponibili = new ArrayList<PostoDto>();
		
		for (OnlyPosto posto : posti) {
			PostoDto postoDto = new PostoDto();
			postoDto.setId(posto.getId());
			postoDto.setFila(posto.getFila());
			postoDto.setNumero(posto.getNumero());
			
			postiDisponibili.add(postoDto);
		}
		
		return postiDisponibili;
	}

	@Override
	public Long contaPostiDisponibili(Long idProiezione) {
		return proiezioneRepository.contaPostiLiberi(idProiezione);
	}

	

}
