package com.willian.portal_suporte.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.willian.portal_suporte.entity.ClientePlanos;
import com.willian.portal_suporte.repository.ClientePlanosRepository;

@Service
public class ClientePlanosService {

    private final ClientePlanosRepository clientePlanosRepository;

    public ClientePlanosService(ClientePlanosRepository clientePlanosRepository) {
        this.clientePlanosRepository = clientePlanosRepository;
    }

    public List<ClientePlanos> listar() {
        return clientePlanosRepository.findAll();
    }

    public ClientePlanos findById(Long id) {
        return clientePlanosRepository.findById(id).get();
    }

    public ClientePlanos insert(ClientePlanos clientePlanos) {
        return clientePlanosRepository.save(clientePlanos);
    }

    public ClientePlanos update(Long id, ClientePlanos clientePlanos) {
        clientePlanos.setId(id);
        return clientePlanosRepository.save(clientePlanos);
    }

    public void delete(Long id) {
        clientePlanosRepository.deleteById(id);
    }
}

