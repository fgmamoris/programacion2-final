package com.programacion2.Final.service;

import com.programacion2.Final.entity.ItemPedido;
import java.util.List;

public interface ItemPedidoService {

    public abstract ItemPedido findById(int id);

    public abstract List<ItemPedido> getListaItemsPedido();

    public abstract ItemPedido saveItemPedido(ItemPedido item);

    public abstract void removeAll();

    public abstract void deleteById(int id);
}
