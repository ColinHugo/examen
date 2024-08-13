package com.truper.examen.repository;

import com.truper.examen.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository< Producto, Integer > {
}