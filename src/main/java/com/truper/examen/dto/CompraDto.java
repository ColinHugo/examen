package com.truper.examen.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class CompraDto {

    @NotNull( message = "El id del clientes es obligatorio" )
    private Integer cliente;

    @NotBlank( message = "El nombre de la lista no puede ir vacio" )
    @NotNull( message = "El nombre de la lista es obligatorio" )
    private String nombreLista;

    @Valid
    @NotNull( message = "La lista de los artículos es obligatoria" )
    private List< ArticuloDto > articulos;

}