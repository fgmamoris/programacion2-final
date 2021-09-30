/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programacion2.Final.service;

import com.programacion2.Final.entity.EstadoPedidoEntity;
import com.programacion2.Final.entity.PedidoEntity;
import com.programacion2.Final.repository.PedidoJPARepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicioPedido")
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    @Qualifier("pedidoJPARepo")
    private PedidoJPARepo pedidoRepo;

    @Override
    public PedidoEntity findById(int id) {
        return pedidoRepo.findById(id);
    }

    @Override
    public List<PedidoEntity> findByEstado(EstadoPedidoEntity estado) {
        return pedidoRepo.findByEstado(estado);
    }

    @Override
    public PedidoEntity guardarPedido(PedidoEntity pedido) {
        return pedidoRepo.save(pedido);
    }

    @Override
    public PedidoEntity actualizarPedido(PedidoEntity pedido) {
        return pedidoRepo.save(pedido);
    }

    @Override
    public void borrarPedido(PedidoEntity pedido) {
        pedidoRepo.delete(pedido);
    }

    @Override
    public List<PedidoEntity> getListaPedidos() {
        return pedidoRepo.findAll();
    }

    @Override
    public List<PedidoEntity> getListaPedidosOrdenada() {
        return pedidoRepo.findAllByOrderByIdAsc();
    }

    @Override
    public List<PedidoEntity> findListaPorEstadoOrdenada(EstadoPedidoEntity estado) {
        return pedidoRepo.findByEstadoOrderByIdAsc(estado);
    }

}
