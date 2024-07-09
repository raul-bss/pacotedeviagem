package com.example.pacotedeviagem.services;

import com.example.pacotedeviagem.entities.Pacote;
import com.example.pacotedeviagem.repositories.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository repository;

    public List<Pacote> findAll(){
        return repository.findAll();
    }

    public Optional<Pacote> findById(Long id){
        return repository.findById(id);
    }

    public Pacote insert(Pacote obj){
        return repository.save(obj);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Pacote update(Long id, Pacote obj) {
        Pacote entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Pacote entity, Pacote obj) {
        entity.setDestino(obj.getDestino());
        entity.setQuantidadeDias(obj.getQuantidadeDias());
    }
}

