package com.willian.portal_suporte.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.portal_suporte.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long >  {

	boolean existsByEmail(String email);
	Optional<Usuario> findByEmail(String email);
}
