package com.truper.examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Producto {

    @Id
    private Integer idProducto;

    @Column( length = 15 )
    private String clave;

    @Column( length = 150 )
    private String descripcion;

    private boolean activo;

    @OneToMany( targetEntity = ListaCompraDetalle.class, mappedBy = "idCodigoProducto", fetch = FetchType.LAZY )
    @JsonIgnore
    private List< ListaCompraDetalle > listaCompraDetalle;

}