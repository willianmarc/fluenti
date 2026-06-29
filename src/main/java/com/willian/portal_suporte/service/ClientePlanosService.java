package com.willian.portal_suporte.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willian.portal_suporte.dto.ClientePlanosDTO;
import com.willian.portal_suporte.entity.Cliente;
import com.willian.portal_suporte.entity.ClientePlanos;
import com.willian.portal_suporte.entity.Plano;
import com.willian.portal_suporte.repository.ClientePlanosRepository;
import com.willian.portal_suporte.repository.ClienteRepository;
import com.willian.portal_suporte.repository.PlanoRepository;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class ClientePlanosService {

	private final ClientePlanosRepository clientePlanosRepository;
	private final ClienteRepository clienteRepository;
	private final PlanoRepository planoRepository;

	public ClientePlanosService(ClientePlanosRepository clientePlanosRepository, ClienteRepository clienteRepository,
			PlanoRepository planoRepository) {
		this.clientePlanosRepository = clientePlanosRepository;
		this.clienteRepository = clienteRepository;
		this.planoRepository = planoRepository;
	}

	public List<ClientePlanosDTO> listarClientePlanos() {
		List<ClientePlanos> lista = clientePlanosRepository.findAll();

		return lista.stream().map(ClientePlanosDTO::new).toList();
	}

	public ClientePlanosDTO findById(Long id) {
		ClientePlanos clientePlanos = clientePlanosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));

		return new ClientePlanosDTO(clientePlanos);
	}

	public ClientePlanosDTO insert(ClientePlanosDTO dto) {
		ClientePlanos clientePlanos = new ClientePlanos();

		copiarDtoParaEntidade(dto, clientePlanos);

		clientePlanos = clientePlanosRepository.save(clientePlanos);

		return new ClientePlanosDTO(clientePlanos);
	}

	public ClientePlanosDTO update(Long id, ClientePlanosDTO dto) {
		ClientePlanos clientePlanos = clientePlanosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));

		copiarDtoParaEntidade(dto, clientePlanos);

		clientePlanos = clientePlanosRepository.save(clientePlanos);

		return new ClientePlanosDTO(clientePlanos);
	}

	public void delete(Long id) {
		ClientePlanos clientePlanos = clientePlanosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id));

		clientePlanosRepository.delete(clientePlanos);
	}

	private void copiarDtoParaEntidade(ClientePlanosDTO dto, ClientePlanos clientePlanos) {
		Cliente cliente = clienteRepository.findById(dto.getClienteId())
				.orElseThrow(() -> new ResourceNotFoundException(dto.getClienteId()));

		Plano plano = planoRepository.findById(dto.getPlanoId())
				.orElseThrow(() -> new ResourceNotFoundException(dto.getPlanoId()));

		clientePlanos.setCliente(cliente);
		clientePlanos.setPlano(plano);
		clientePlanos.setDataInicio(dto.getDataInicio());
		clientePlanos.setDataFim(dto.getDataFim());
	}
}
