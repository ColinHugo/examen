package com.truper.examen.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ArticuloDto {

    @NotNull( message = "El id del producto es obligatorio" )
    private Integer idProducto;

    @NotNull( message = "La cantidad del artículo es obligatoria" )
    private Integer cantidad;

}