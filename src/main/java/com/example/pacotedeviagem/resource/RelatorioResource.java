package com.example.pacotedeviagem.resource;

import com.example.pacotedeviagem.entities.Relatorio;
import com.example.pacotedeviagem.services.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/venda/relatorio")
public class RelatorioResource {

    @Autowired
    private RelatorioService service;

    @GetMapping
    public ResponseEntity<List<Relatorio>> findAll() {
        List<Relatorio> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Relatorio>> findById(@PathVariable Long id) {
        Optional<Relatorio> obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
