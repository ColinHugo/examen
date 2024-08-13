package com.truper.examen.service;

import com.truper.examen.entity.ListaCompraDetalle;

public interface ListaCompraDetalleService {

    ListaCompraDetalle encontrarPorId( Integer idListaCompra );

    ListaCompraDetalle registrar( ListaCompraDetalle listaCompraDetalle );

}