package com.programacion2.Final.controller;

import com.programacion2.Final.constantes.Constantes;

import com.programacion2.Final.entity.IngredienteEntity;
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
public class IngredientesController {

    @Autowired
    @Qualifier("servicioIngrediente")
    private IngrService servicioIngrediente;

    @GetMapping("/agregarIngrediente")
    public String addIngrediente(@RequestParam(name = "id", required = false) int id, Model model) {
        IngredienteEntity ingredienteForm = new IngredienteEntity();
        model.addAttribute("ingredienteForm", ingredienteForm);
        return Constantes.GERENTE_INGREDIENTE_PATH;
    }

    @PostMapping("/confirmarAgregarIngrediente")//nivel de metodo
    public String confirmarAgregarIngrediente(@ModelAttribute IngredienteEntity ingredienteForm, Model model) {
        if (ingredienteForm.getNombreIngrediente().isEmpty()) {
            model.addAttribute("invalidData", "1");
            model.addAttribute("ingredienteForm", ingredienteForm);
            return Constantes.GERENTE_INGREDIENTE_PATH;

        } else {
            if (ingredienteForm.getIdIngrediente() == 0) {
                ingredienteForm.setActivo(true);
                servicioIngrediente.addIngrediente(ingredienteForm);
                model.addAttribute("tipoAccion", "agregado");
            } else {
                IngredienteEntity ingredienteAModificar = servicioIngrediente.findById(ingredienteForm.getIdIngrediente());
                ingredienteAModificar.setActivo(false);
                ingredienteForm.setIdIngrediente(0);
                ingredienteForm.setActivo(true);
                servicioIngrediente.updateIngrediente(ingredienteAModificar);
                servicioIngrediente.addIngrediente(ingredienteForm);
                model.addAttribute("tipoAccion", "modificado");
            }
            model.addAttribute("listaIngredientes",
                    servicioIngrediente.getListIngredientesActivos(true));
            return Constantes.GERENTE_INGREDIENTES_LISTA;
        }
    }

//******************EDIT INGREDIENTE
    @GetMapping("/editarIngrediente")
    public String editarIngrediente(@RequestParam(name = "id", required = true) int id, Model model) {
        IngredienteEntity ingredienteForm = servicioIngrediente.findById(id);
        model.addAttribute("ingredienteForm", ingredienteForm);
        return Constantes.GERENTE_INGREDIENTE_PATH;
    }

//******ELIMINAR INGREDIENTE
    @GetMapping("/eliminarIngrediente")
    public String eliminarIngrediente(@RequestParam(name = "id", required = true) int id, Model model) {
        IngredienteEntity ingredienteForm = servicioIngrediente.findById(id);
        ingredienteForm.setActivo(false);
        servicioIngrediente.updateIngrediente(ingredienteForm);
        model.addAttribute("tipoAccion", "eliminado");
        model.addAttribute("listaIngredientes",
                servicioIngrediente.getListIngredientesActivos(true));
        return Constantes.GERENTE_INGREDIENTES_LISTA;// return abmIngredientes(model);
    }

//*****************CANCELAR INGREDIENTE
    @GetMapping("/CancelarAgregarIngrediente")
    public String CancelarAgregarIngrediente(Model model) {
        model.addAttribute("listaIngredientes",
                servicioIngrediente.getListIngredientesActivos(true));
        return Constantes.GERENTE_INGREDIENTES_LISTA;
    }
}
