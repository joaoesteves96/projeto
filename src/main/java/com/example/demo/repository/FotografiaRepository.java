package com.example.demo.repository;

import com.example.demo.model.Contentor;
import com.example.demo.model.Fotografia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotografiaRepository extends JpaRepository<Fotografia, Integer> {
}
