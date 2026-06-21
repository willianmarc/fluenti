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
import com.willian.portal_suporte.entity.Usuario;
import com.willian.portal_suporte.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;

	public UsuarioController(UsuarioRepository usuarioRepository) {

		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping
	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{id}")
	public Usuario buscarPorId(@PathVariable Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@PutMapping("/{id}")
	public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
}
