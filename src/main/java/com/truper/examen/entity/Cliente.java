package com.truper.examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Cliente {

    @NotNull( message = "El parámetro id es obligatorio" )
    @Column( unique = true, nullable = false )
    @Id
    private Integer idCliente;

    @NotBlank( message = "El nombre no puede ir vacio" )
    @NotNull( message = "El parámetro nombre es obligatorio" )
    @Column( length = 50, nullable = false )
    private String nombre;

    private boolean activo;

    @OneToMany( targetEntity = ListaCompra.class, mappedBy = "customerId", fetch = FetchType.LAZY )
    @JsonIgnore
    private List< ListaCompra > listaCompras;

}