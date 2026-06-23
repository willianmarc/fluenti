package com.willian.portal_suporte.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.willian.portal_suporte.entity.Cliente;
import com.willian.portal_suporte.repository.ClienteRepository;

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
		return clienteRepository.findById(id).get();
	}

	public Cliente insert(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente update(Long id, Cliente cliente) {
		cliente.setId(id);
		return clienteRepository.save(cliente);
	}

	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}
}