package com.willian.portal_suporte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.willian.portal_suporte.entity.Usuario;
import com.willian.portal_suporte.repository.UsuarioRepository;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Long id, Usuario usuario) {
	    Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

	    usuarioExistente.orElseThrow(() -> new ResourceNotFoundException(id));

	    usuario.setId(id);

	    return usuarioRepository.save(usuario);
	}
	

	public void delete(Long id) {

	    Optional<Usuario> usuario = usuarioRepository.findById(id);

	    usuario.orElseThrow(() -> new ResourceNotFoundException(id));

	    usuarioRepository.deleteById(id);
	}

}
