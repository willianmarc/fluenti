package com.willian.portal_suporte.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.willian.portal_suporte.entity.Plano;
import com.willian.portal_suporte.repository.PlanoRepository;

@RestController
@RequestMapping("/planos")
public class PlanoController {
	private final PlanoRepository planoRepository;

	public PlanoController(PlanoRepository planoRepository) {
		this.planoRepository = planoRepository;
	}

	@GetMapping
	public List<Plano> listaPlano() {
		return planoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Plano buscarPorId(@PathVariable Long id) {
		return planoRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Plano cadastrar(@RequestBody Plano plano) {
		if (plano.getValorMensal().compareTo(BigDecimal.ZERO) <= 0) {
		    throw new RuntimeException("Valor inválido");
		}
		return planoRepository.save(plano);
	}

	@PutMapping("/{id}")
	public Plano atualizar(@PathVariable Long id, @RequestBody Plano plano) {
		plano.setId(id);
		return planoRepository.save(plano);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		planoRepository.deleteById(id);
	}

}
