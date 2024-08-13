package com.truper.examen.repository;

import com.truper.examen.entity.ListaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListaCompraRepository extends JpaRepository< ListaCompra, Integer > {

    @Query( "SELECT l FROM ListaCompra l WHERE l.customerId.idCliente = :customerId" )
    List< ListaCompra > findByCustomerId( Integer customerId );

}