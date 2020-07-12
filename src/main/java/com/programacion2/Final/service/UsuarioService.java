package com.programacion2.Final.service;

import com.programacion2.Final.entity.UsuarioEntity;
import java.util.List;

public interface UsuarioService {

//METODOS DE LA INTERFACE DECLARAR LOS METODOS DE ACCESO A BD  TRABAJA CON LAS ENTITY
    public abstract List<UsuarioEntity> getListUser();

    public abstract UsuarioEntity addUsuario(UsuarioEntity usuario);

    //SErVIRA PARA CAMBIAR EL ROL Y LA CONTRASEÑA
    public abstract UsuarioEntity updateUsuario(UsuarioEntity usuario);

    public abstract UsuarioEntity findUserCredential(int legajo, String passoword);

    public abstract UsuarioEntity findUserLegajo(int legajo);

    //////////PRUEBA ULTIMO LEGAJO
    public abstract int findLegajo();

    ////metodo entidad
    public abstract UsuarioEntity findById(int id);

    public abstract void removeUser(int id);
}
