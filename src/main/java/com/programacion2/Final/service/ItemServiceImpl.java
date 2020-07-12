package com.programacion2.Final.service;



import com.programacion2.Final.entity.ItemEntity;

import com.programacion2.Final.repository.ItemJPARepo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.programacion2.Final.repository.IngrJPARepo;

@Service("servicioItem")
public class ItemServiceImpl implements ItemService {

    @Autowired
    @Qualifier("itemJPARepo")
    private ItemJPARepo itemRepo;

    @Autowired
    @Qualifier("ingredienteJPARepo")
    private IngrJPARepo ingredienteRepo;

    @Override
    public ItemEntity addItem(ItemEntity item) {
        return itemRepo.save(item);
    }

    @Override
    public ItemEntity findById(int id) {
        return itemRepo.findByIdItem(id);
    }

    @Override
    public ItemEntity updateItem(ItemEntity item) {
        return itemRepo.save(item);

    }

    @Override
    public void removeItemEntity(ItemEntity item) {
            itemRepo.delete(item);
    }

    @Override
    public List<ItemEntity> getListItems() {
        return itemRepo.findAll();
    }
    @Override
    public List<ItemEntity> getListItemsActivos(boolean estadoItem) {
        return itemRepo.findAllByActivo(estadoItem);
    }

}
