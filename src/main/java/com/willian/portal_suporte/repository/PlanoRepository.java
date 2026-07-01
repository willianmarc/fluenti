package com.willian.portal_suporte.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.willian.portal_suporte.entity.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
	

    boolean existsByNome(String nome);

    Optional<Plano> findByNome(String nome);
}
