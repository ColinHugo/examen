package com.truper.examen.service.impl;

import com.truper.examen.dto.ArticuloDto;
import com.truper.examen.dto.CompraDto;
import com.truper.examen.entity.Cliente;
import com.truper.examen.entity.ListaCompra;
import com.truper.examen.entity.ListaCompraDetalle;
import com.truper.examen.entity.Producto;
import com.truper.examen.entity.llaves.PKListaCompraDetalle;
import com.truper.examen.exception.RecursoNoEncontradoExcepcion;
import com.truper.examen.repository.ListaCompraDetalleRepository;
import com.truper.examen.repository.ListaCompraRepository;
import com.truper.examen.repository.ProductoRepository;
import com.truper.examen.service.ClienteService;
import com.truper.examen.service.ListaCompraService;
import com.truper.examen.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ListaCompraServiceImpl implements ListaCompraService {

    private final ListaCompraRepository listaCompraRepository;

    private final ClienteService clienteService;
    private final ProductoService productoService;
    private final ListaCompraDetalleRepository listaCompraDetalleRepository;

    @Override
    public List< ListaCompra > obtenerListaUsuarioPorId( Integer customerId ) {

        List< ListaCompra > listas = listaCompraRepository.findByCustomerId( customerId );

        if ( listas.isEmpty() ) {
            throw new RecursoNoEncontradoExcepcion( "No hay listas de compras para el usuario con el id: " + customerId );
        }

        return listas;

    }

    @Override
    public CompraDto guardarListaCompra( CompraDto compraDto ) {

        Cliente cliente = clienteService.encontrarClientePorId( compraDto.getCliente() );

        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setCustomerId( cliente );
        listaCompra.setNombre( compraDto.getNombreLista() );
        listaCompra.setFechaRegistro( LocalDate.now() );
        listaCompra.setFechaUltimaActualizacion( null );
        listaCompra.setActivo( true );
        listaCompraRepository.save( listaCompra ); // me genera id

        for ( ArticuloDto articulo : compraDto.getArticulos() ) {

            Producto producto = productoService.obtenerProductoPorId( articulo.getIdProducto() );

            ListaCompraDetalle detalle = new ListaCompraDetalle();
            detalle.setIdListaCompra( listaCompra );
            detalle.setIdCodigoProducto( producto );
            detalle.setCantidad( articulo.getCantidad() );

            PKListaCompraDetalle pk = new PKListaCompraDetalle(listaCompra.getIdLista(), producto.getIdProducto());
            detalle.setPkListaCompraDetalle(pk);

            listaCompraDetalleRepository.save(detalle);

        }

        return compraDto;

    }

    @Override
    public CompraDto actualizarListaCompra( Integer idLista, CompraDto compraDto ) {

        Cliente cliente = clienteService.encontrarClientePorId( compraDto.getCliente() );

        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setCustomerId( cliente );
        listaCompra.setNombre( "Lista Actualizada" );
        listaCompra.setFechaUltimaActualizacion( LocalDate.now() );
        listaCompra.setActivo( true );
        listaCompraRepository.save( listaCompra ); // me genera id

        System.out.println("listaCompra = " + listaCompra);

        for ( ArticuloDto articulo : compraDto.getArticulos() ) {

            Producto producto = productoService.obtenerProductoPorId( articulo.getIdProducto() );

            ListaCompraDetalle detalle = new ListaCompraDetalle();
            detalle.setIdListaCompra( listaCompra );
            detalle.setIdCodigoProducto( producto );
            detalle.setCantidad( articulo.getCantidad() );

            PKListaCompraDetalle pk = new PKListaCompraDetalle(listaCompra.getIdLista(), producto.getIdProducto());
            detalle.setPkListaCompraDetalle(pk);

            listaCompraDetalleRepository.save(detalle);

        }

        return compraDto;

    }

}