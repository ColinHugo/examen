package com.truper.examen.service;

import com.truper.examen.dto.CompraDto;
import com.truper.examen.entity.ListaCompra;

import java.util.List;

public interface ListaCompraService {

    List< ListaCompra > obtenerListaUsuarioPorId( Integer customerId );

    CompraDto guardarListaCompra( CompraDto compraDto );

    CompraDto actualizarListaCompra( Integer idLista, CompraDto compraDto );

}