package com.willian.portal_suporte.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.willian.portal_suporte.dto.PlanoDTO;
import com.willian.portal_suporte.service.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public List<PlanoDTO> listaPlano() {
        return planoService.listarPlano();
    }

    @GetMapping("/{id}")
    public PlanoDTO buscarPorId(@PathVariable Long id) {
        return planoService.findById(id);
    }

    @PostMapping
    public PlanoDTO cadastrar(@RequestBody PlanoDTO plano) {
        return planoService.insert(plano);
    }

    @PutMapping("/{id}")
    public PlanoDTO atualizar(@PathVariable Long id, @RequestBody PlanoDTO plano) {
        return planoService.update(id, plano);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        planoService.delete(id);
    }
}