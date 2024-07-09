package com.example.pacotedeviagem.resource;


import com.example.pacotedeviagem.entities.Pacote;
import com.example.pacotedeviagem.entities.Transporte;
import com.example.pacotedeviagem.services.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/transporte")
public class TransporteResource {

    @Autowired
    private TransporteService service;

    @GetMapping
    public ResponseEntity<List<Transporte>> findAll(){
        List<Transporte> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Transporte>> findById(@PathVariable Long id){
        Optional<Transporte> Transporte = service.findById(id);
        return ResponseEntity.ok().body(Transporte);
    }

    @PostMapping
    public ResponseEntity<Transporte> insert(@RequestBody Transporte obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transporte> updateTransporte(@PathVariable Long id, @RequestBody Transporte obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}

