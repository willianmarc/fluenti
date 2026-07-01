package com.willian.portal_suporte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.willian.portal_suporte.dto.UsuarioDTO;

import com.willian.portal_suporte.entity.Usuario;
import com.willian.portal_suporte.repository.UsuarioRepository;
import com.willian.portal_suporte.service.exceptions.DataBaseException;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<UsuarioDTO> listarUsuario() {
		List<Usuario> lista = usuarioRepository.findAll();

		return lista.stream().map(UsuarioDTO::new).toList();
	}

	public UsuarioDTO findById(Long id) {
		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		return new UsuarioDTO(usuario);
	}

	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario usuarioExistente = new Usuario();
		copiarDtoParaEntidade(dto, usuarioExistente);

		usuarioExistente = usuarioRepository.save(usuarioExistente);

		return new UsuarioDTO(usuarioExistente);
	}

	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		copiarDtoParaEntidade(dto, usuarioExistente);
		usuarioExistente = usuarioRepository.save(usuarioExistente);

		return new UsuarioDTO(usuarioExistente);
	}

	public UsuarioDTO updatePatch(Long id, UsuarioDTO dto) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		if (dto.getTelefone() != null) {
			usuarioExistente.setTelefone(dto.getTelefone());
		}

		if (dto.getEmail() != null) {

			Optional<Usuario> usuarioComEmail = usuarioRepository.findByEmail(dto.getEmail());

			if (usuarioComEmail.isPresent() && !usuarioComEmail.get().getId().equals(id)) {
				throw new DataBaseException("E-mail já cadastrado em outro usuário");
			}

			usuarioExistente.setEmail(dto.getEmail());
		}

		usuarioExistente = usuarioRepository.save(usuarioExistente);

		return new UsuarioDTO(usuarioExistente);
	}

	public void delete(Long id) {
		usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

		usuarioRepository.deleteById(id);

	}

	public void copiarDtoParaEntidade(UsuarioDTO dto, Usuario usuario) {
		usuario.setNome(dto.getNome());
		usuario.setPerfil(dto.getPerfil());
		usuario.setEmail(dto.getEmail());
		usuario.setTelefone(dto.getTelefone());
		usuario.setAtivo(dto.isAtivo());

	}

}
