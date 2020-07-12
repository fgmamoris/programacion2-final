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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredientes")
public class IngredienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idingrediente")
    private int idIngrediente;

    @Column(name = "nombreingrediente")
    private String nombreIngrediente;

    @Column(name = "activo")
    private boolean activo;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaIngredientes", cascade = CascadeType.MERGE)
    private List<ItemEntity> listaItems = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaIngredientesAgregar", cascade = CascadeType.MERGE)
    private List<ItemPedido> listaItemsAgregar = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "listaIngredientesQuitar", cascade = CascadeType.MERGE)
    private List<ItemPedido> listaItemsQuitar = new ArrayList<>();

    public IngredienteEntity(int idIngrediente, String nombreIngrediente, boolean activo, boolean modificable) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.activo = activo;
    }

    public IngredienteEntity() {
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<ItemEntity> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<ItemEntity> listaItems) {
        this.listaItems = listaItems;
    }

    public List<ItemPedido> getListaItemsAgregar() {
        return listaItemsAgregar;
    }

    public void setListaItemsAgregar(List<ItemPedido> listaItemsAgregar) {
        this.listaItemsAgregar = listaItemsAgregar;
    }

    public List<ItemPedido> getListaItemsQuitar() {
        return listaItemsQuitar;
    }

    public void setListaItemsQuitar(List<ItemPedido> listaItemsQuitar) {
        this.listaItemsQuitar = listaItemsQuitar;
    }

}
