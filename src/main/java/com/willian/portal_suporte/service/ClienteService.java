package com.willian.portal_suporte.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.willian.portal_suporte.entity.Cliente;
import com.willian.portal_suporte.repository.ClienteRepository;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {

		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> listarCliente() {

		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
	    return clienteRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Cliente insert(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente update(Long id, Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		clienteExistente.setNomeEmpresa(cliente.getNomeEmpresa());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setAtivo(cliente.isAtivo());
		clienteExistente.setTelefone(cliente.getTelefone());

		return clienteRepository.save(clienteExistente);
	}

	public void delete(Long id) {
		clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		clienteRepository.deleteById(id);
	}
}