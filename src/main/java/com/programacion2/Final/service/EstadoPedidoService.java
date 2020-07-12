package com.programacion2.Final.service;


import com.programacion2.Final.entity.EstadoPedidoEntity;
import java.util.List;

public interface EstadoPedidoService {

    public abstract EstadoPedidoEntity findById(int id);

    public abstract EstadoPedidoEntity findByEstado(String estado);

    public List<EstadoPedidoEntity> findAll();

}
