package com.programacion2.Final.service;

import com.programacion2.Final.entity.ItemPedido;
import com.programacion2.Final.repository.ItemPedidoJPARepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicioItemPedido")
public class ItemPedidoSericeImpl implements ItemPedidoService {

    @Autowired
    @Qualifier("itemPedidoJPA")
    private ItemPedidoJPARepo itemPedidoRepo;

    @Override
    public ItemPedido findById(int id) {
        return itemPedidoRepo.findById(id);
    }

    @Override
    public List<ItemPedido> getListaItemsPedido() {
        return itemPedidoRepo.findAll();
    }

    @Override
    public ItemPedido saveItemPedido(ItemPedido item) {
        return itemPedidoRepo.save(item);
    }

    @Override
    public void removeAll() {
        itemPedidoRepo.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        itemPedidoRepo.deleteById(id);
    }

}
