package com.willian.portal_suporte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.willian.portal_suporte.dto.ClienteDTO;

import com.willian.portal_suporte.entity.Cliente;

import com.willian.portal_suporte.repository.ClienteRepository;
import com.willian.portal_suporte.service.exceptions.DataBaseException;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {

		this.clienteRepository = clienteRepository;
	}

	public List<ClienteDTO> listarCliente() {
		List<Cliente> lista = clienteRepository.findAll();

		return lista.stream().map(ClienteDTO::new).toList();
	}

	public ClienteDTO findById(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return new ClienteDTO(cliente);
	}

	public ClienteDTO insert(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		copiarDtoParaEntidade(dto, cliente);
		
		if(clienteRepository.existsByEmail(dto.getEmail())) {
			throw new DataBaseException("E-mail já cadastrado");
		}
		cliente = clienteRepository.save(cliente);

		return new ClienteDTO(cliente);
	}

	public ClienteDTO update(Long id, ClienteDTO dto) {
		Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		
		 Optional<Cliente> clienteComEmail = clienteRepository.findByEmail(dto.getEmail());

		    if (clienteComEmail.isPresent() && !clienteComEmail.get().getId().equals(id)) {
		        throw new DataBaseException("E-mail já cadastrado");
		    }

		copiarDtoParaEntidade(dto, clienteExistente);

		clienteExistente = clienteRepository.save(clienteExistente);

		return new ClienteDTO(clienteExistente);
	}
	
	public ClienteDTO updatePatch(Long id, ClienteDTO dto) {
		Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		
		if (dto.getTelefone() != null) {
		    clienteExistente.setTelefone(dto.getTelefone());
		}

		if (dto.getEmail() != null) {

		    Optional<Cliente> clienteComEmail = clienteRepository.findByEmail(dto.getEmail());

		    if (clienteComEmail.isPresent() && !clienteComEmail.get().getId().equals(id)) {
		        throw new DataBaseException("E-mail já cadastrado em outro cliente");
		    }

		    clienteExistente.setEmail(dto.getEmail());
		}

		clienteExistente = clienteRepository.save(clienteExistente);

		return new ClienteDTO(clienteExistente);
	}

	public void delete(Long id) {
		clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		clienteRepository.deleteById(id);
	}

	private void copiarDtoParaEntidade(ClienteDTO dto, Cliente cliente) {

		cliente.setCodigoCliente(dto.getCodigoCliente());
		cliente.setNomeEmpresa(dto.getNomeEmpresa());
		cliente.setEmail(dto.getEmail());
		cliente.setTelefone(dto.getTelefone());
		cliente.setAtivo(dto.isAtivo());

	}
}