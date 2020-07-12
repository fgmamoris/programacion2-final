package com.programacion2.Final.entity;

import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "fk_iditem")
    private ItemEntity item;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = IngredienteEntity.class)
    @JoinTable(name = "rel_itemaddingrediente", joinColumns = {
        @JoinColumn(name = "fk_id_item")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_id_ingrediente")})
    private List<IngredienteEntity> listaIngredientesAgregar = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = IngredienteEntity.class)
    @JoinTable(name = "rel_itemremoveingrediente", joinColumns = {
        @JoinColumn(name = "fk_id_item")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_id_ingrediente")})
    private List<IngredienteEntity> listaIngredientesQuitar = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pedido") // tiene que ser lazt por que sino los trae siempre
    private PedidoEntity pedido;

    public ItemPedido(int id, ItemEntity item, PedidoEntity pedido) {
        this.id = id;
        this.item = item;
        this.pedido = pedido;
    }

    public ItemPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public List<IngredienteEntity> getListaIngredientesAgregar() {
        return listaIngredientesAgregar;
    }

    public void setListaIngredientesAgregar(List<IngredienteEntity> listaIngredientesAgregar) {
        this.listaIngredientesAgregar = listaIngredientesAgregar;
    }

    public List<IngredienteEntity> getListaIngredientesQuitar() {
        return listaIngredientesQuitar;
    }

    public void setListaIngredientesQuitar(List<IngredienteEntity> listaIngredientesQuitar) {
        this.listaIngredientesQuitar = listaIngredientesQuitar;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

}
