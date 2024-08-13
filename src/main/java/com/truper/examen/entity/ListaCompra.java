package com.truper.examen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ListaCompra {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Integer idLista;

    @ManyToOne( targetEntity = Cliente.class )
    @JoinColumn( name = "customer_id", nullable = false )
    private Cliente customerId;

    @Column( length = 50, nullable = false )
    private String nombre;

    private LocalDate fechaRegistro;

    private LocalDate fechaUltimaActualizacion;

    private boolean activo;

    @OneToMany( mappedBy = "idListaCompra", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    private List< ListaCompraDetalle > detalles;

}