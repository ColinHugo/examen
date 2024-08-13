package com.truper.examen.service.impl;

import com.truper.examen.entity.Cliente;
import com.truper.examen.exception.RecursoNoEncontradoExcepcion;
import com.truper.examen.repository.ClienteRepository;
import com.truper.examen.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List< Cliente > encontrarClientes() {

        List< Cliente > clientes = clienteRepository.findAll();

        if ( clientes.isEmpty() ) {
            throw new RecursoNoEncontradoExcepcion( "No hay clientes registrados" );
        }

        return clientes;

    }

    @Override
    public Cliente encontrarClientePorId( Integer clienteId ) {
        return clienteRepository
                .findById( clienteId )
                .orElseThrow( () -> new RecursoNoEncontradoExcepcion( "No se encontró el cliente con el id: " + clienteId ) );
    }

    @Override
    public Cliente registrarCliente( Cliente cliente ) {
        return clienteRepository.save( cliente );
    }

}