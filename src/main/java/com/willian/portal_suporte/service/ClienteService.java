package com.willian.portal_suporte.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.willian.portal_suporte.dto.ClienteDTO;

import com.willian.portal_suporte.entity.Cliente;

import com.willian.portal_suporte.repository.ClienteRepository;
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
		cliente = clienteRepository.save(cliente);

		return new ClienteDTO(cliente);
	}

	public ClienteDTO update(Long id, ClienteDTO dto) {
		Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		copiarDtoParaEntidade(dto, clienteExistente);

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