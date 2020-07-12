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
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditem")
    private int idItem;

    @Column(name = "nombreitem")
    private String nombreItem;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "modificable")
    private boolean modificable;

//Unidireccional ya que no es necesaria la relacion bidireccional, no necesito la navegacion inversa
/*    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "idestado")
    private EstadoItemEntity estado;
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, targetEntity = IngredienteEntity.class)
    @JoinTable(name = "rel_item_ingrediente", joinColumns = {
        @JoinColumn(name = "fk_id_item")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_id_ingrediente")})
    private List<IngredienteEntity> listaIngredientes = new ArrayList<>();

    public ItemEntity(int idItem, String nombreItem, boolean activo, boolean modificable) {
        this.idItem = idItem;
        this.nombreItem = nombreItem;
        this.activo = activo;
        this.modificable = modificable;
    }

    public ItemEntity() {
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isModificable() {
        return modificable;
    }

    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }

    public List<IngredienteEntity> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<IngredienteEntity> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

}
