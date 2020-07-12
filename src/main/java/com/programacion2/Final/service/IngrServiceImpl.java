package com.programacion2.Final.service;

import com.programacion2.Final.entity.IngredienteEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.programacion2.Final.repository.IngrJPARepo;

@Service("servicioIngrediente")
public class IngrServiceImpl implements IngrService {

    @Autowired
    @Qualifier("ingredienteJPARepo")
    private IngrJPARepo ingredienteRepo;

    @Override
    public IngredienteEntity addIngrediente(IngredienteEntity ingrediente) {
        return ingredienteRepo.save(ingrediente);
    }

    @Override
    public IngredienteEntity findById(int id) {
        return ingredienteRepo.findByIdIngrediente(id);
    }

    @Override
    public IngredienteEntity updateIngrediente(IngredienteEntity ingrediente) {

        return ingredienteRepo.save(ingrediente);

    }

    /*@Override
    public void removeIngredienteEntity(int id) {
        IngredienteEntity ingrediente = ingredienteRepo.findByIdIngrediente(id);
        if (ingrediente != null) {
            ingredienteRepo.delete(ingrediente);
        }
    }*/
    @Override
    public void removeIngredienteEntity(IngredienteEntity ingrediente) {
        ingredienteRepo.delete(ingrediente);
    }

    @Override
    public List<IngredienteEntity> getListIngredientes() {
        return ingredienteRepo.findAll();
    }
    
    @Override
    public List<IngredienteEntity> getListIngredientesActivos(boolean estadoIngrediente) {
        return ingredienteRepo.findAllByActivo(estadoIngrediente);
    }
    

}
