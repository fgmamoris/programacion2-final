package com.programacion2.Final.service;

import com.programacion2.Final.entity.EstadoPedidoEntity;
import com.programacion2.Final.repository.EstadoPedidoJPARepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicioEstadoPedido")
public class EstadoPedidoServiceImpl implements EstadoPedidoService {

    @Autowired
    @Qualifier("estadoPedidoJPARepo")
    private EstadoPedidoJPARepo estadoRepo;

    @Override
    public EstadoPedidoEntity findById(int id) {
        return estadoRepo.findById(id);
    }

    @Override
    public EstadoPedidoEntity findByEstado(String estado) {
        return estadoRepo.findByEstado(estado);
    }

    @Override
    public List<EstadoPedidoEntity> findAll() {
        return estadoRepo.findAll();
    }

}
