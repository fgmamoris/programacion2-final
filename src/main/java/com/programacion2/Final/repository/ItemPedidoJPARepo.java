package com.programacion2.Final.repository;

import com.programacion2.Final.entity.ItemPedido;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemPedidoJPA")
public interface ItemPedidoJPARepo extends JpaRepository<ItemPedido, Serializable> {

    public ItemPedido findById(int id);

    public List<ItemPedido> findAll();

}
