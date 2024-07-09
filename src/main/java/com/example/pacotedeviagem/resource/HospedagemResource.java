package com.example.pacotedeviagem.resource;

import com.example.pacotedeviagem.entities.Hospedagem;
import com.example.pacotedeviagem.services.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospedagem")
public class HospedagemResource {

    @Autowired
    private HospedagemService service;

    @GetMapping
    public ResponseEntity<List<Hospedagem>> findAll(){
        List<Hospedagem> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Hospedagem>> findById(@PathVariable Long id){
        Optional<Hospedagem> hospedagem = service.findById(id);
        return ResponseEntity.ok().body(hospedagem);
    }

    @PostMapping
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem) {
        hospedagem = service.insert(hospedagem);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hospedagem.getId()).toUri();
        return ResponseEntity.created(uri).body(hospedagem);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospedagem> updateHospedagem(@PathVariable Long id, @RequestBody Hospedagem obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
