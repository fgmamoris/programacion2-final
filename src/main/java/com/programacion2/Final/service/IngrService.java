package com.programacion2.Final.service;


import com.programacion2.Final.entity.IngredienteEntity;

import java.util.List;

public interface IngrService {

//*************CRUD
    public abstract IngredienteEntity addIngrediente(IngredienteEntity ingrediente);

    public abstract IngredienteEntity findById(int id);

    public abstract IngredienteEntity updateIngrediente(IngredienteEntity ingrediente);

    //public abstract void removeIngredienteEntity(int id);
    public abstract void removeIngredienteEntity(IngredienteEntity ingrediente);

//***************
    public abstract List<IngredienteEntity> getListIngredientes();

    public abstract List<IngredienteEntity> getListIngredientesActivos(boolean estadoIngrediente);

    //SErVIRA PARA CAMBIAR EL ROL Y LA CONTRASEÑA
}
