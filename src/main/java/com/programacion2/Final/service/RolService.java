package com.programacion2.Final.service;

import com.programacion2.Final.entity.RolEntity;
import java.util.List;

public interface RolService {

//METODOS DE LA INTERFACE DECLARAR LOS METODOS DE ACCESO A BD  TRABAJA CON LAS ENTITY
    public abstract List<RolEntity> getListRoles();

    ////metodo entidad
    public abstract RolEntity findById(int id);

    public abstract void removeRol(int id);
}
