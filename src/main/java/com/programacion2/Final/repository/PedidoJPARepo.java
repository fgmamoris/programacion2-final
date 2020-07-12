/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programacion2.Final.repository;

import com.programacion2.Final.entity.EstadoPedidoEntity;
import com.programacion2.Final.entity.PedidoEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pedidoJPARepo")
public interface PedidoJPARepo extends JpaRepository<PedidoEntity, Serializable> {

    public PedidoEntity findById(int id);

    public List<PedidoEntity> findAllByEstado(EstadoPedidoEntity estadoPedido);

    //DEBERIA BUSCAR POR ESTADO DIRECTAMENTE OSEA AGRUPAR BY
    public List<PedidoEntity> findByEstado(EstadoPedidoEntity estadoPedido);

    public List<PedidoEntity> findAllByOrderByIdAsc();

    public List<PedidoEntity> findByEstadoOrderByIdAsc(EstadoPedidoEntity estado);
}
