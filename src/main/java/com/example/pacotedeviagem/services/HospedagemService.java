package com.example.pacotedeviagem.services;

import com.example.pacotedeviagem.entities.Hospedagem;
import com.example.pacotedeviagem.repositories.HospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedagemService {

    @Autowired
    private HospedagemRepository repository;

    public List<Hospedagem> findAll(){
        return repository.findAll();
    }

    public Optional<Hospedagem> findById(Long id){
        return repository.findById(id);
    }

    public Hospedagem insert(Hospedagem obj){
        return repository.save(obj);
    }

    public void deleteById(Long id){
         repository.deleteById(id);
    }

    public Hospedagem update(Long id, Hospedagem obj) {
        Hospedagem entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Hospedagem entity, Hospedagem obj) {
        entity.setDescricao(obj.getDescricao());
        entity.setValor(obj.getValor());
    }
}
