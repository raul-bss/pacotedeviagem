package com.example.pacotedeviagem.services;


import com.example.pacotedeviagem.entities.Transporte;
import com.example.pacotedeviagem.repositories.TransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransporteService {

    @Autowired
    private TransporteRepository repository;

    public List<Transporte> findAll(){
        return repository.findAll();
    }

    public Optional<Transporte> findById(Long id){
        return repository.findById(id);
    }

    public Transporte insert(Transporte obj){
        return repository.save(obj);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Transporte update(Long id, Transporte obj) {
        Transporte entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Transporte entity, Transporte obj) {
        entity.setTipo(obj.getTipo());
        entity.setValor(obj.getValor());
    }
}
