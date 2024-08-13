package com.truper.examen.controller;

import com.truper.examen.dto.CompraDto;
import com.truper.examen.entity.ListaCompra;
import com.truper.examen.service.ListaCompraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping( "/lista-compras" )
public class ListaCompraController {

    private final ListaCompraService listaCompraService;

    @GetMapping( "/obtener-lista/{customerId}" )
    public ResponseEntity< List < ListaCompra > > obtenerListaCompra( @PathVariable Integer customerId ) {
        return ResponseEntity.ok( listaCompraService.obtenerListaUsuarioPorId( customerId ) );
    }

    @PostMapping( "/registrar-compra" )
    public ResponseEntity< CompraDto > guardarCompra( @Valid @RequestBody CompraDto compraDto ) {
        return ResponseEntity.status( HttpStatus.CREATED ).body( listaCompraService.guardarListaCompra( compraDto ) );
    }

    @PutMapping( "/actualizar-lista/{customerId}" )
    public ResponseEntity< CompraDto > actualizarCompra( @PathVariable Integer customerId, @Valid @RequestBody CompraDto compraDto ) {
        return ResponseEntity.status( HttpStatus.OK ).body( listaCompraService.actualizarListaCompra( customerId, compraDto ) );
    }

    @DeleteMapping( "/eliminar-lista/{listaId}" )
    public ResponseEntity< CompraDto > eliminarCompra( @PathVariable Integer listaId ){
        return null;
    }

}