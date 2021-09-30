package com.programacion2.Final.repository;


import com.programacion2.Final.entity.ItemEntity;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("itemJPARepo")
public interface ItemJPARepo extends JpaRepository<ItemEntity, Serializable> {

    public ItemEntity findByIdItem(int id);

    public List<ItemEntity> findAllByActivo(boolean estadoItem);

}
