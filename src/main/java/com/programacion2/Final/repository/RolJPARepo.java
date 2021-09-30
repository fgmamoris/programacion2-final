package com.programacion2.Final.repository;

import com.programacion2.Final.entity.RolEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

@Repository("rolJPARepo")
public interface RolJPARepo extends JpaRepository<RolEntity, Serializable> {

    public RolEntity findByIdRol(int id);
}
