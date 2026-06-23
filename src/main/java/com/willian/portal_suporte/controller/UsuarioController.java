package com.willian.portal_suporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.willian.portal_suporte.entity.Usuario;
import com.willian.portal_suporte.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public List<Usuario> listarUsuario() {
		return usuarioService.listarUsuario();
	}

	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		return usuarioService.insert(usuario);
	}

	@PutMapping("/{id}")
	public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		return usuarioService.update(id, usuario);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		usuarioService.delete(id);
	}

}