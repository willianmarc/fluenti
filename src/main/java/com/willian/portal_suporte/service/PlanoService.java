package com.willian.portal_suporte.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.willian.portal_suporte.entity.Plano;
import com.willian.portal_suporte.repository.PlanoRepository;

@Service
public class PlanoService {

    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<Plano> listaPlano() {
        return planoRepository.findAll();
    }

    public Plano findById(Long id) {
        return planoRepository.findById(id).get();
    }

    public Plano insert(Plano plano) {
        return planoRepository.save(plano);
    }

    public Plano update(Long id, Plano plano) {
        plano.setId(id);
        return planoRepository.save(plano);
    }

    public void delete(Long id) {
        planoRepository.deleteById(id);
    }
}