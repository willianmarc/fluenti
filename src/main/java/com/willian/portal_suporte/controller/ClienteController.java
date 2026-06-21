package com.willian.portal_suporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.willian.portal_suporte.entity.Cliente;
import com.willian.portal_suporte.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteRepository clienteRepository;

	public ClienteController(ClienteRepository clienteRepository) {

		this.clienteRepository = clienteRepository;
	}

	@GetMapping
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Cliente cadastrar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/{id}")
	 public void deletar(@PathVariable Long id) {
	     clienteRepository.deleteById(id);
	
	}}
