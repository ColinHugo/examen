package com.truper.examen.service.impl;

import com.truper.examen.entity.Producto;
import com.truper.examen.exception.RecursoNoEncontradoExcepcion;
import com.truper.examen.repository.ProductoRepository;
import com.truper.examen.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto obtenerProductoPorId( Integer productoId ) {
        return productoRepository
                .findById(productoId)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion( "No existe el producto con id: " + productoId ) );
    }
}