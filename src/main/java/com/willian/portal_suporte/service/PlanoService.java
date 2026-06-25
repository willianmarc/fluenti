package com.willian.portal_suporte.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.willian.portal_suporte.entity.Plano;
import com.willian.portal_suporte.repository.PlanoRepository;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class PlanoService {

	private final PlanoRepository planoRepository;

	public PlanoService(PlanoRepository planoRepository) {
		this.planoRepository = planoRepository;
	}

	public List<Plano> listaPlano() {
		return planoRepository.findAll();

	}

	public Plano findById(Long id) {
	 return planoRepository.findById(id)
	.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public Plano insert(Plano plano) {
		return planoRepository.save(plano);
	}

	public Plano update(Long id, Plano plano) {
		Plano planoExistente = planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		planoExistente.setNomePlano(plano.getNomePlano());
		planoExistente.setLimiteMensagens(plano.getLimiteMensagens());
		planoExistente.setValorMensal(plano.getValorMensal());
		planoExistente.setAtivo(plano.isAtivo());

		return planoRepository.save(plano);
	}

	public void delete(Long id) {
		planoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		planoRepository.deleteById(id);
	}
}