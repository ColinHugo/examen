package com.truper.examen.service;

import com.truper.examen.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List< Cliente > encontrarClientes();

    Cliente encontrarClientePorId( Integer clienteId );

    Cliente registrarCliente( Cliente cliente );

}