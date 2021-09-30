package com.programacion2.Final.repository;

import com.programacion2.Final.entity.EstadoPedidoEntity;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("estadoPedidoJPARepo")
public interface EstadoPedidoJPARepo extends JpaRepository<EstadoPedidoEntity, Serializable> {

    public abstract EstadoPedidoEntity findById(int id);

    public abstract EstadoPedidoEntity findByEstado(String estado);

}
