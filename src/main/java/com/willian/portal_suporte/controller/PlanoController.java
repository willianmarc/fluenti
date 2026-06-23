package com.willian.portal_suporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.willian.portal_suporte.entity.Plano;
import com.willian.portal_suporte.service.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @GetMapping
    public List<Plano> listaPlano() {
        return planoService.listaPlano();
    }

    @GetMapping("/{id}")
    public Plano buscarPorId(@PathVariable Long id) {
        return planoService.findById(id);
    }

    @PostMapping
    public Plano cadastrar(@RequestBody Plano plano) {
        return planoService.insert(plano);
    }

    @PutMapping("/{id}")
    public Plano atualizar(@PathVariable Long id, @RequestBody Plano plano) {
        return planoService.update(id, plano);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        planoService.delete(id);
    }
}