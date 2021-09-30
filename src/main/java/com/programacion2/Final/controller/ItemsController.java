package com.programacion2.Final.controller;

import com.programacion2.Final.constantes.Constantes;

import com.programacion2.Final.entity.IngredienteEntity;
import com.programacion2.Final.entity.ItemEntity;
import com.programacion2.Final.service.ItemService;
import java.util.ArrayList;
import java.util.List;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.programacion2.Final.service.IngrService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (path="/gerente")
public class ItemsController {

    @Autowired
    @Qualifier("servicioIngrediente")
    private IngrService servicioIngrediente;

    @Autowired
    @Qualifier("servicioItem")
    private ItemService servicioItem;

    @GetMapping("/agregarItem")
    public String agregarItem(Model model) {
        model.addAttribute("listaIngredientes", servicioIngrediente.getListIngredientesActivos(true));
        model.addAttribute("itemForm", new ItemEntity());
        return Constantes.GERENTE_ITEM_PATH;
    }
//MODEL ATRIBUTE TRAE EL ATRIBUTO DEL MODELO QUE ES UN OBJETO INYECTADO
    //REQUEST PARAM TRE UN ATRIBUTO DEL MODELO QUE NO ESTA INYECTADO y no es parte del modelo
    //@RequestParam("lista") int[] lista

    @PostMapping("/confirmarAgregarItem")
    public String confirmarAgregarItem(@ModelAttribute("itemForm") ItemEntity itemForm,
            @RequestParam(name = "lista", required = false) int[] lista,
            Model model) {
        if (itemForm.getNombreItem().isEmpty()) {
            model.addAttribute("invalidData", "1");
            model.addAttribute("listaIngredientes", servicioIngrediente.getListIngredientesActivos(true));
            model.addAttribute("itemForm", itemForm);
            return Constantes.GERENTE_ITEM_PATH;
        }// No seria necesario el estado por que lo traigo con el service
        //EstadoItemEntity estado = new EstadoItemEntity();
        List<IngredienteEntity> listaAgregar = new ArrayList<>();
        if (itemForm.getIdItem() == 0) {
            if (lista != null) {
                for (int i : lista) {
                    listaAgregar.add(servicioIngrediente.findById(i));
                }
                itemForm.setListaIngredientes(listaAgregar);
                //Preguntar si esta bien la logica???????
            }
            itemForm.setActivo(true);
            servicioItem.addItem(itemForm);
            model.addAttribute("tipoAccion", "agregado");
        } else {
            ItemEntity itemAModificar = servicioItem.findById(itemForm.getIdItem());
            itemAModificar.setActivo(false);
            itemForm.setIdItem(0);
            itemForm.setActivo(true);
            if (lista != null) {
                //*********NO ES NECESARIO BORRAR LA CARDINALIDAD DE ITEM E INGREDIENTE
                //COMO PASA EN EL CASO DE LOS INGREDIENTES
                //paso el item a modificar
                for (int i : lista) {
                    listaAgregar.add(servicioIngrediente.findById(i));
                }
                itemForm.setListaIngredientes(listaAgregar);
            }
            LOGGER.warn("Lista del item que debe ocultarse" + itemAModificar.getListaIngredientes().size());
            servicioItem.updateItem(itemAModificar);
            servicioItem.addItem(itemForm);
            model.addAttribute("tipoAccion", "modificado");
        }

        model.addAttribute(
                "listaItems", servicioItem.getListItemsActivos(true));
        return Constantes.GERENTE_ITEMS_LISTA;

    }
//**********EDITAR ITEM

    @GetMapping("/editarItem")
    public String editarItem(@RequestParam(name = "id", required = true) int id, Model model) {
        ItemEntity itemForm = servicioItem.findById(id);
        model.addAttribute("listaIngredientes", servicioIngrediente.getListIngredientesActivos(true));
        model.addAttribute("itemForm", itemForm);
        return Constantes.GERENTE_ITEM_PATH;
    }

    //******ELIMINAR ITEM
    @GetMapping("/eliminarItem")
    public String eliminarItem(@RequestParam(name = "id", required = true) int id, Model model) {
        ItemEntity itemForm = servicioItem.findById(id);
        itemForm.setActivo(false);
        servicioItem.updateItem(itemForm);
        model.addAttribute("tipoAccion", "eliminado");
        model.addAttribute("listaItems", servicioItem.getListItemsActivos(true));
        return Constantes.GERENTE_ITEMS_LISTA;
    }

    //*******CANCEL ADD ITEM****************
    @GetMapping("/cancelarAgregarItem")
    public String cancelarAgregarItem(Model model) {
        model.addAttribute("listaItems",
                servicioItem.getListItemsActivos(true));
        return Constantes.GERENTE_ITEMS_LISTA;
    }
}
