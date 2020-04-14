package it.fides.cinema.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fides.cinema.service.GestioneSala;
import it.fides.cinema.dto.PostoDto;
import it.fides.cinema.dto.SalaDto;
import it.fides.cinema.dto.SearchSalaDto;
import it.fides.cinema.entity.Posto;
import it.fides.cinema.entity.Sala;
import it.fides.cinema.repository.SalaRepository;


@Service
@Transactional
public class GestioneSalaImpl implements GestioneSala {

	@Autowired
	SalaRepository salaRepository;

	DozerBeanMapper mapper;

	@Override
	public List<SalaDto> getAllSala() {
		List<SalaDto> listaSaleDto = new ArrayList<>();
		for (Sala sala : salaRepository.findAll()) {
			SalaDto salaDto = new SalaDto();
			salaDto.setNomeSala(sala.getNomeSala());
			salaDto.setId(sala.getId());
			salaDto.setNumeroPosti(sala.getNumeroPosti());
			listaSaleDto.add(salaDto);
		}
		return listaSaleDto;
	}

<<<<<<< Updated upstream



	//insertSala senza Dozer//

	/*@Override
	public void inserSala(SalaDto salaDto) {
		Sala sala=new Sala();

		Set<Posto> listaPosti=new HashSet<>();

		sala.setNomeSala(sala.getNomeSala());

		for (PostoDto postoDto : salaDto.getPostoSet()) {
			Posto posto=new Posto();

			posto.setFila(postoDto.getFila());
			posto.setNumero(postoDto.getNumero());
			posto.setSala(sala);

			listaPosti.add(posto);

		}
		sala.setNomeSala(salaDto.getNomeSala());
		sala.setNumeroPosti(salaDto.getNumeroPosti());
		sala.setPostoSet(listaPosti);

		salaRepository.save(sala);


	}*/





=======
>>>>>>> Stashed changes
	@Override
	public void insertSala(SalaDto salaDto) {

		mapper = new DozerBeanMapper();

		Sala sala=mapper.map(salaDto, Sala.class);

		Set<Posto> listaPosti = new HashSet<>();

		for (PostoDto postoDto  : salaDto.getSetPosti()) {

			Posto posto=mapper.map(postoDto, Posto.class);

			posto.setSala(sala);
			listaPosti.add(posto);
		}

		sala.setSetPosti(listaPosti);
		salaRepository.save(sala);
	}

	@Override
	public SalaDto findById(Long idSala) {
		Sala sala = salaRepository.findById(idSala).get();
		SalaDto salaDto = new SalaDto();
		salaDto.setNomeSala(sala.getNomeSala());
		salaDto.setNumeroPosti(sala.getNumeroPosti());
		
		Set<PostoDto> postoSet= new HashSet<>();
		for (Posto posto : sala.getSetPosti()) {
			PostoDto postoDto= new PostoDto();
			postoDto.setId(posto.getId());
			postoDto.setFila(posto.getFila());
			postoDto.setNumero(posto.getNumero());
			
			postoSet.add(postoDto);		
		}
		salaDto.setSetPosti(postoSet);
		return salaDto;
	}


	@Override
	public List<SalaDto> findByNomeSala(SearchSalaDto searchSalaDto) {

		List<Sala> listaSala = salaRepository.findByNomeSalaLike(searchSalaDto.getNomeSala());
		List<SalaDto> listaSalaDto=new ArrayList<>();
		Set<PostoDto> postoSet= new HashSet<>();
		SalaDto salaDto=new SalaDto();
		int countPosto;
		if (listaSala != null && !listaSala.isEmpty()) {

			for (Sala sala : listaSala) {
				salaDto.setId(sala.getId());
				salaDto.setNomeSala(sala.getNomeSala());
				salaDto.setNumeroPosti(sala.getNumeroPosti());
				
				for (Posto posto  : sala.getSetPosti()) {
					PostoDto postoDto = new PostoDto();
					postoDto.setId(posto.getId());
					postoDto.setFila(posto.getFila());
					postoDto.setNumero(posto.getNumero());
					
					
					postoSet.add(postoDto);
				}
				listaSalaDto.add(salaDto);
			}
			salaDto.setSetPosti(postoSet);
			
			countPosto=postoSet.size();
			System.out.println("posti disponibili in sala: "+countPosto);

		}

		return listaSalaDto;
	}


	
	
	
	
	public int getCountPosto(String nomeSala) {  //conta i posti delle sale
		List<Sala> listaSala = salaRepository.findByNomeSala(nomeSala);
		
		List<SalaDto> listaSalaDto=new ArrayList<>();
		Set<PostoDto> postoSet= new HashSet<>();
		SalaDto salaDto=new SalaDto();
		int countPosto = 0;
		if (listaSala != null && !listaSala.isEmpty()) {

			for (Sala sala : listaSala) {
				
				for (Posto posto  : sala.getPostoSet()) {
					PostoDto postoDto=new PostoDto();

					postoSet.add(postoDto);
				}
				listaSalaDto.add(salaDto);
			}
			salaDto.setPostoSet(postoSet);
			
			countPosto=postoSet.size();
			System.out.println("posti disponibili in sala: "+countPosto+ " da salaImpl");

		}

		return countPosto;

		
	}
	
	
	
	
	

	@Override
	public List<SalaDto> findByNomeSalaLike(SearchSalaDto searchSalaDto) {

		List<Sala> listaSala = salaRepository.findByNomeSala(searchSalaDto.getNomeSala());
		List<SalaDto> listaSalaDto=new ArrayList<>();

		if (listaSala != null && !listaSala.isEmpty()) {

			for (Sala sala : listaSala) {
				SalaDto salaDto=new SalaDto();
				salaDto.setId(sala.getId());
				salaDto.setNomeSala(sala.getNomeSala());
				salaDto.setNumeroPosti(sala.getNumeroPosti());
			
				listaSalaDto.add(salaDto);
			}
			
			
		}


		return listaSalaDto;
	}


}
