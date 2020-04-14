package it.fides.cinema.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.entity.Posto;
import it.fides.cinema.repository.PostoRepository;
import it.fides.cinema.service.GestionePosto;


@Service
@Transactional
public class GestionePostoImpl implements GestionePosto {

	@Autowired
	private PostoRepository postoRepository;
	
	@Override
	public Set<PostoDto> showPosti(String nomeSala) {
		Set<PostoDto> setPosti = new HashSet<PostoDto>();
		
		for (Posto posto : postoRepository.findAll()) {
			PostoDto postoDto = new PostoDto();
			postoDto.setFila(posto.getFila());
			postoDto.setId(posto.getId());
			postoDto.setNumero(posto.getNumero());
			if(posto.getSala().getNomeSala().equalsIgnoreCase(nomeSala))
				setPosti.add(postoDto);
		}
		
		return setPosti;
	}
	
	@Override
	public Set<PostoDto> generatePosti(SalaDto sala) {
		Set<PostoDto> setPostiGenerated = new HashSet<PostoDto>();
		
		//Calcolo il numero di file, posti ed eventuali dispari
		int[] arrayLPRfull = determinaFilePosti(sala.getNumeroPosti().intValue());
		
		int numeroFile = arrayLPRfull[0];
		int numeroPosti = arrayLPRfull[1];
		int numRimanenti = arrayLPRfull[2];
		
		//Creo la lista di posti generati
		setPostiGenerated = printPosti(numeroFile, numeroPosti, numRimanenti, sala);
		
		return setPostiGenerated;
	}
	

	private Set<PostoDto> printPosti(int numFile, int numPosti, int numRimanenti, SalaDto sala){
		PostoDto posto = new PostoDto();
		Set<PostoDto> setPosti = new HashSet<PostoDto>();
		String letteraS = new String();
		char lettera = 'A';
		letteraS = "" + lettera;
		if(numRimanenti == 0){
			for(int i=0; i<numFile; i++){
				for(int j = 1; j<=numPosti; j++){
					posto = new PostoDto();
					posto.setFila(letteraS);
					posto.setSala(sala);
					Long numeroPosto = new Long(j);
					posto.setNumero(numeroPosto);
					setPosti.add(posto);
				}
				lettera++;
				letteraS = "" + lettera;
			}
		}else{
			for(int i = 0; i<numFile; i++){
				for(int j = 1; j<=numPosti; j++){
					posto = new PostoDto();
					posto.setFila(letteraS);
					posto.setSala(sala);
					Long numeroPosto = new Long(j);
					posto.setNumero(numeroPosto);
					setPosti.add(posto);
				}
				lettera++;
				letteraS = "" + lettera;
			}
			for(int j = 1; j<=numRimanenti; j++){
				posto = new PostoDto();
				posto.setFila(letteraS);
				posto.setSala(sala);
				Long numeroPosto = new Long(j);
				posto.setNumero(numeroPosto);
				setPosti.add(posto);
			}
		}
		return setPosti;
	}

	private int[] determinaFilePosti(int numPosti){

		int file = 0, posti = 0, remainder = 0;
		if(numPosti == 1){
			posti = 1;
			file = 1;
			remainder = 0;
		}
		else if(isBetween(numPosti, 2, 5)){
			posti = numPosti/(numPosti/2);
			file = numPosti/posti;
			remainder = numPosti%posti;
		}
		else if(isBetween(numPosti, 6, 50)){
			posti = 5;
			file = numPosti/posti;
			remainder = numPosti%posti;
		}
		else if(isBetween(numPosti, 51, 100)){
			posti = 10;
			file = numPosti/posti;
			remainder = numPosti%posti;
		}else if(numPosti>100){
			posti = 20;
			file = numPosti/posti;
			remainder = numPosti%posti;
		}  
		int[] arrayLPR = {file, posti, remainder};
		return arrayLPR;
	}

	private boolean isBetween(int x, int lower, int upper) {
		return lower <= x && x <= upper;
	}
	
	
	


}
