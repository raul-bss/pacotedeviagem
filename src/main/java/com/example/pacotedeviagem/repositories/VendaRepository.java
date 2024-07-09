package com.example.pacotedeviagem.repositories;

import com.example.pacotedeviagem.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
