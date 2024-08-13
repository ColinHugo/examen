package com.truper.examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.truper.examen.entity.llaves.PKListaCompraDetalle;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ListaCompraDetalle {

    @EmbeddedId
    private PKListaCompraDetalle pkListaCompraDetalle;

    @ManyToOne( fetch = FetchType.LAZY )
    @MapsId( "idListaCompra" )
    @JoinColumn( name = "id_lista_compra", nullable = false )
    @JsonIgnore
    private ListaCompra idListaCompra;

    @ManyToOne( fetch = FetchType.LAZY )
    @MapsId( "idCodigoProducto" )
    @JoinColumn( name = "id_codigo_producto", nullable = false )
    @JsonIgnore
    private Producto idCodigoProducto;

    private Integer cantidad;

}