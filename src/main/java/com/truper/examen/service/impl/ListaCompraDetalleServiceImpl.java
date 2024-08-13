package com.truper.examen.service.impl;

import com.truper.examen.entity.ListaCompraDetalle;
import com.truper.examen.exception.RecursoNoEncontradoExcepcion;
import com.truper.examen.repository.ListaCompraDetalleRepository;
import com.truper.examen.service.ListaCompraDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListaCompraDetalleServiceImpl implements ListaCompraDetalleService {

    private final ListaCompraDetalleRepository listaCompraDetalleRepository;

    @Override
    public ListaCompraDetalle encontrarPorId( Integer idListaCompra ) {
        return listaCompraDetalleRepository
                .findById( idListaCompra )
                .orElseThrow( () -> new RecursoNoEncontradoExcepcion( "No hay detalle de la lista con el id: " + idListaCompra ) );
    }

    @Override
    public ListaCompraDetalle registrar( ListaCompraDetalle listaCompraDetalle ) {
        return listaCompraDetalleRepository.save( listaCompraDetalle );
    }

}