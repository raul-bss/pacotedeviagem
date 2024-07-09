package com.example.pacotedeviagem.repositories;

import com.example.pacotedeviagem.entities.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacoteRepository extends JpaRepository<Pacote,Long> {
}
