package com.programacion2.Final.repository;

import com.programacion2.Final.entity.UsuarioEntity;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuarioJPARepo")
public interface UsuarioJPARepo extends JpaRepository<UsuarioEntity, Serializable> {
//public interface UsuarioJPARepo extends JpaRepository<Usuario, Integer> {

    //IMPLEMENTACIONES GRACIAS A JPA
    public abstract UsuarioEntity findByLegajoAndPassword(int legajo, String password);

    public abstract List<UsuarioEntity> findByLegajoOrderByNombre(int legajo);

    public abstract UsuarioEntity findTopByOrderByIdDesc();

    public abstract UsuarioEntity findByLegajo(int legajo);

    
    ////////
    public abstract UsuarioEntity findById(int id);

}
