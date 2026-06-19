package com.willian.portal_suporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.portal_suporte.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long >  {

}
