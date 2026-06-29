package com.willian.portal_suporte.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.willian.portal_suporte.dto.PlanoDTO;
import com.willian.portal_suporte.entity.Plano;
import com.willian.portal_suporte.repository.PlanoRepository;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class PlanoService {

	private PlanoRepository planoRepository;

	public PlanoService(PlanoRepository planoRepository) {
		this.planoRepository = planoRepository;
	}

	public List<PlanoDTO> listarPlano() {
		List<Plano> lista = planoRepository.findAll();

		return lista.stream().map(PlanoDTO::new).toList();
	}

	public PlanoDTO findById(Long id) {
		Plano plano = planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		return new PlanoDTO(plano);
	}

	public PlanoDTO insert(PlanoDTO dto) {
		Plano plano = new Plano();

		copiarDtoParaEntidade(dto, plano);

		plano = planoRepository.save(plano);

		return new PlanoDTO(plano);
	}

	public PlanoDTO update(Long id, PlanoDTO dto) {
		Plano planoExistente = planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		copiarDtoParaEntidade(dto, planoExistente);

		planoExistente = planoRepository.save(planoExistente);

		return new PlanoDTO(planoExistente);
	}

	public void delete(Long id) {
		planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		planoRepository.deleteById(id);
	}

	private void copiarDtoParaEntidade(PlanoDTO dto, Plano plano) {
		plano.setNomePlano(dto.getNomePlano());
		plano.setLimiteMensagens(dto.getLimiteMensagens());
		plano.setValorMensal(dto.getValorMensal());
		plano.setAtivo(dto.isAtivo());
	}
}