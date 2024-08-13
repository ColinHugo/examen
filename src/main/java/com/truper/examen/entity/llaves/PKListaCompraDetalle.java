package com.truper.examen.entity.llaves;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class PKListaCompraDetalle {

    private Integer idListaCompra;
    private Integer idCodigoProducto;

}