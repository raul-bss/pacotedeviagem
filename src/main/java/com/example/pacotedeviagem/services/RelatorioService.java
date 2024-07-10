package com.example.pacotedeviagem.services;

import com.example.pacotedeviagem.entities.Relatorio;
import com.example.pacotedeviagem.entities.Venda;
import com.example.pacotedeviagem.repositories.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelatorioService {
    @Autowired
    private RelatorioRepository repository;

    public List<Relatorio> findAll(){
        return repository.findAll();
    }

    public Optional<Relatorio> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Relatorio insert(Relatorio obj) {
        return repository.save(obj);
    }
}
