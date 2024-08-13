package com.truper.examen.repository;

import com.truper.examen.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository< Cliente, Integer > {
}