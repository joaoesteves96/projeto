package com.example.demo.repository;

import com.example.demo.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao,Integer> {
}
