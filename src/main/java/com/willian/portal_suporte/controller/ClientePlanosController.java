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
import com.willian.portal_suporte.dto.ClientePlanosDTO;
import com.willian.portal_suporte.service.ClientePlanosService;

@RestController
@RequestMapping("/cliente-planos")
public class ClientePlanosController {

    private final ClientePlanosService clientePlanosService;

    public ClientePlanosController(ClientePlanosService clientePlanosService) {
        this.clientePlanosService = clientePlanosService;
    }

    @GetMapping
    public List<ClientePlanosDTO> listar() {
        return clientePlanosService.listarClientePlanos();
    }

    @GetMapping("/{id}")
    public ClientePlanosDTO buscarPorId(@PathVariable Long id) {
        return clientePlanosService.findById(id);
    }

    @PostMapping
    public ClientePlanosDTO cadastrar(@RequestBody ClientePlanosDTO clientePlanos) {
        return clientePlanosService.insert(clientePlanos);
    }

    @PutMapping("/{id}")
    public ClientePlanosDTO atualizar(@PathVariable Long id, @RequestBody ClientePlanosDTO clientePlanos) {
        return clientePlanosService.update(id, clientePlanos);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clientePlanosService.delete(id);
    }
}