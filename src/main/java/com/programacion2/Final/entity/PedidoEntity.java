package com.programacion2.Final.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "id")
    private EstadoPedidoEntity estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemPedido> listaItemsPedido = new ArrayList<>();

    public PedidoEntity(int id, EstadoPedidoEntity estado) {
        this.id = id;
        this.estado = estado;
    }

    public PedidoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EstadoPedidoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedidoEntity estado) {
        this.estado = estado;
    }

    public List<ItemPedido> getListaItemsPedido() {
        return listaItemsPedido;
    }

    public void setListaItemsPedido(List<ItemPedido> listaItemsPedido) {
        this.listaItemsPedido = listaItemsPedido;
    }

}
