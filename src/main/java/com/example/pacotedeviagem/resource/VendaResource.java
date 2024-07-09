package com.example.pacotedeviagem.resource;

import com.example.pacotedeviagem.entities.Venda;
import com.example.pacotedeviagem.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/venda")
public class VendaResource {
    @Autowired
    private VendaService service;

    @GetMapping
    public ResponseEntity<List<Venda>> findAll(){
        List<Venda> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Venda>> findById(@PathVariable Long id){
        Optional<Venda> Venda = service.findById(id);
        return ResponseEntity.ok().body(Venda);
    }

    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody Venda obj) {
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
    public ResponseEntity<Venda> updateVenda(@PathVariable Long id, @RequestBody Venda obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
