package com.willian.portal_suporte.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.portal_suporte.entity.Cliente;


	public interface ClienteRepository extends JpaRepository<Cliente,Long >  {
		
		boolean existsByEmail(String email);
		Optional<Cliente> findByEmail(String email);

	}

