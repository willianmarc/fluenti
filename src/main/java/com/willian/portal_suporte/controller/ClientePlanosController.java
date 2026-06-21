package com.willian.portal_suporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.willian.portal_suporte.entity.ClientePlanos;
import com.willian.portal_suporte.repository.ClientePlanosRepository;

@RestController
@RequestMapping("/cliente-planos")
public class ClientePlanosController {

    private final ClientePlanosRepository clientePlanosRepository;

    public ClientePlanosController(ClientePlanosRepository clientePlanosRepository) {
        this.clientePlanosRepository = clientePlanosRepository;
    }

    @GetMapping
    public List<ClientePlanos> listar() {
        return clientePlanosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClientePlanos buscarPorId(@PathVariable Long id) {
        return clientePlanosRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ClientePlanos cadastrar(@RequestBody ClientePlanos clientePlanos) {
        return clientePlanosRepository.save(clientePlanos);
    }

    @PutMapping("/{id}")
    public ClientePlanos atualizar(@PathVariable Long id, @RequestBody ClientePlanos clientePlanos) {
        clientePlanos.setId(id);
        return clientePlanosRepository.save(clientePlanos);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clientePlanosRepository.deleteById(id);
    }
}