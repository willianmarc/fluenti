package com.willian.portal_suporte.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.willian.portal_suporte.entity.ClientePlanos;
import com.willian.portal_suporte.repository.ClientePlanosRepository;
import com.willian.portal_suporte.service.exceptions.ResourceNotFoundException;

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
        return clientePlanosRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public ClientePlanos insert(ClientePlanos clientePlanos) {
        return clientePlanosRepository.save(clientePlanos);
    }

    public ClientePlanos update(Long id, ClientePlanos clientePlanos) {
        ClientePlanos clientePlanosExistente = clientePlanosRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
        clientePlanosExistente.setPlano(clientePlanos.getPlano());
       
        return clientePlanosRepository.save(clientePlanosExistente);
    }

    public void delete(Long id) {
    	clientePlanosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        clientePlanosRepository.deleteById(id);
    }
}

