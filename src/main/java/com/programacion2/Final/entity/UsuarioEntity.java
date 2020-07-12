package com.programacion2.Final.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "legajo")
    private int legajo;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    private RolEntity rolUsuario;

    public UsuarioEntity(int id, String nombre, String apellido, int legajo, String password, RolEntity rolUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.password = password;
        this.rolUsuario = rolUsuario;
    }

    public UsuarioEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolEntity getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(RolEntity rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

}
