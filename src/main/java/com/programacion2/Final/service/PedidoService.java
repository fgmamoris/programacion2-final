package com.programacion2.Final.service;

import com.programacion2.Final.entity.EstadoPedidoEntity;
import com.programacion2.Final.entity.PedidoEntity;
import java.util.List;

public interface PedidoService {

    public abstract PedidoEntity findById(int id);

    public abstract List<PedidoEntity> findByEstado(EstadoPedidoEntity estado);

    public abstract List<PedidoEntity> findListaPorEstadoOrdenada(EstadoPedidoEntity estado);

    public abstract PedidoEntity guardarPedido(PedidoEntity pedido);

    public abstract PedidoEntity actualizarPedido(PedidoEntity pedido);

    public abstract void borrarPedido(PedidoEntity pedido);

    public abstract List<PedidoEntity> getListaPedidos();

    public abstract List<PedidoEntity> getListaPedidosOrdenada();

}
