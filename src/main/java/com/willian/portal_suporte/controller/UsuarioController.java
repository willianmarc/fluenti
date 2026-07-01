package com.willian.portal_suporte.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.willian.portal_suporte.dto.UsuarioDTO;

import com.willian.portal_suporte.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public List<UsuarioDTO> listarUsuario() {
		return usuarioService.listarUsuario();
	}

	@GetMapping("/{id}")
	public UsuarioDTO buscarPorId(@PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@PostMapping
	public UsuarioDTO cadastrar(@RequestBody UsuarioDTO usuario) {
		return usuarioService.insert(usuario);
	}

	@PutMapping("/{id}")
	public UsuarioDTO atualizar(@PathVariable Long id, @RequestBody UsuarioDTO usuario) {
		return usuarioService.update(id, usuario);
	}
	@PatchMapping("/{id}")
	public UsuarioDTO atualizarPatch(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
	    return usuarioService.updatePatch(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		usuarioService.delete(id);
	}

}