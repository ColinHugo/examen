package com.truper.examen.controller;

import com.truper.examen.entity.Producto;
import com.truper.examen.exception.RecursoNoEncontradoExcepcion;
import com.truper.examen.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping( "/productos" )
public class ProductoController {

    private final ProductoRepository productoRepository;

    @GetMapping
    public ResponseEntity< List< Producto > > obtenerProductos() {
        return ResponseEntity.ok( productoRepository.findAll() );
    }

    @GetMapping( "/{productoId}" )
    public ResponseEntity< Optional< Producto > > obtenerProductoPorId( @PathVariable Integer productoId ) {
        return ResponseEntity.ok( Optional.ofNullable(
                productoRepository
                        .findById( productoId )
                        .orElseThrow( () -> new RecursoNoEncontradoExcepcion( "No existe el producto con el id: " + productoId ) )
        ) );
    }

}