/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programacion2.Final.service;


import com.programacion2.Final.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    public abstract ItemEntity addItem(ItemEntity item);

    public abstract ItemEntity findById(int id);

    public abstract ItemEntity updateItem(ItemEntity item);

    public abstract void removeItemEntity(ItemEntity item);

    public abstract List<ItemEntity> getListItems();

      public abstract List<ItemEntity> getListItemsActivos(boolean estadoItem);
}
