package com.willian.portal_suporte.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.willian.portal_suporte.dto.UsuarioDTO;

import com.willian.portal_suporte.entity.Usuario;
import com.willian.portal_suporte.repository.UsuarioRepository;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<UsuarioDTO> listarUsuario() {
	    List<Usuario> lista = usuarioRepository.findAll();

	    return lista.stream()
	            .map(UsuarioDTO::new)
	            .toList();
	}

	public UsuarioDTO findById(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		return new UsuarioDTO(usuario);
	}

	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Long id, Usuario usuario) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		usuarioExistente.setNome(usuario.getNome());
		usuarioExistente.setEmail(usuario.getEmail());
		usuarioExistente.setAtivo(usuario.isAtivo());
		
		return usuarioRepository.save(usuarioExistente);
	}

	public void delete(Long id) {
		usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		usuarioRepository.deleteById(id);

	}

}
