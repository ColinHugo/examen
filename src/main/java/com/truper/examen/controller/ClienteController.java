package com.truper.examen.controller;

import com.truper.examen.entity.Cliente;
import com.truper.examen.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping( "/clientes" )
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity< List< Cliente > > obtenerClientes() {
        return ResponseEntity.ok( clienteService.encontrarClientes() );
    }

    @GetMapping( "/{clienteId}" )
    public ResponseEntity< Cliente > obtenerClientePorId( @PathVariable Integer clienteId ) {
        return ResponseEntity.ok( clienteService.encontrarClientePorId( clienteId ) );
    }

    @PostMapping( "/registrar" )
    public ResponseEntity< Cliente > registrarCliente( @Valid @RequestBody Cliente cliente ) {
        return ResponseEntity.status( HttpStatus.CREATED ).body( clienteService.registrarCliente( cliente ) );
    }

}