package com.example.pacotedeviagem.resource;



import com.example.pacotedeviagem.services.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.pacotedeviagem.entities.Pacote;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacote")
public class PacoteResource {

    @Autowired
    private PacoteService service;

    @GetMapping
    public ResponseEntity<List<Pacote>> findAll(){
        List<Pacote> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Pacote>> findById(@PathVariable Long id){
        Optional<Pacote> Pacote = service.findById(id);
        return ResponseEntity.ok().body(Pacote);
    }

    @PostMapping
    public ResponseEntity<Pacote> insert(@RequestBody Pacote obj) {
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
    public ResponseEntity<Pacote> updatePacote(@PathVariable Long id, @RequestBody Pacote obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}

