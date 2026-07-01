package com.willian.portal_suporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.willian.portal_suporte.dto.ClienteDTO;

import com.willian.portal_suporte.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> listarCliente() {
        return clienteService.listarCliente();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public ClienteDTO cadastrar(@RequestBody ClienteDTO dto) {
        return clienteService.insert(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return clienteService.update(id, dto);
    }
    
    @PatchMapping("/{id}")
    public ClienteDTO atualizarPatch(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return clienteService.updatePatch(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.delete(id);
    }
}