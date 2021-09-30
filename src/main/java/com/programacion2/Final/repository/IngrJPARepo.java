package com.programacion2.Final.repository;

import com.programacion2.Final.entity.IngredienteEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ingredienteJPARepo")
public interface IngrJPARepo extends JpaRepository<IngredienteEntity, Serializable> {

    public abstract IngredienteEntity findByIdIngrediente(int id);

    public abstract List<IngredienteEntity> findAllByActivo(boolean estadoIngrediente);

}
