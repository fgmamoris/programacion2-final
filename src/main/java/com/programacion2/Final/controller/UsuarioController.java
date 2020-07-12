package com.programacion2.Final.controller;

import com.programacion2.Final.constantes.Constantes;
import com.programacion2.Final.entity.RolEntity;
import com.programacion2.Final.entity.UsuarioEntity;
import com.programacion2.Final.service.RolService;
import com.programacion2.Final.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/gerente")
public class UsuarioController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("servicioUsuario")
    private UsuarioService servicioUsuario;

    @Autowired
    @Qualifier("servicioRol")
    private RolService servicioRol;

    @GetMapping("/usuario")
    public String usuario(@RequestParam(name = "id", required = false) int id, Model model) {
//deberia agregar invaliddata null para que no me muestre cartel de error
//Busco si tengo el usuario en base de datos e decir si es para modificar ya que viene
//por parametro id, y agrego los datos al formulario
        UsuarioEntity userForm = new UsuarioEntity();
        if (id == 0) {
            userForm.setLegajo(servicioUsuario.findLegajo());
        } else {
            userForm = servicioUsuario.findById(id);
        }
        model.addAttribute("listaRoles", servicioRol.getListRoles());
        model.addAttribute("usuario", userForm);
        return Constantes.GERENTE_USER;
    }
//////////////////
//Si se ingreso o falta algun dato error y muesta la vista de addUser
    //Si viene un usuario con id 0 es un usuario nuevo, busco el ultimo para obtener el legajo y sumarle uno
    //Si viene con id !=0 significa que es para modificar, y paso a modificarlo 

    @PostMapping("/confirmarAgregarUsuario")//nivel de metodo
    public String confirmarAgregarUsuario(@ModelAttribute("usuario") UsuarioEntity userForm,
            Model model) {
        if (userForm.getNombre().isEmpty() || userForm.getApellido().isEmpty()
                || userForm.getPassword().isEmpty() || (userForm.getRolUsuario() == null)) {
            model.addAttribute("invalidData", "1");
            model.addAttribute("listaRoles", servicioRol.getListRoles());
            model.addAttribute("userForm", userForm);

            return Constantes.GERENTE_USER;

        } else {
            if (userForm.getId() == 0) {
                //****************VER COMO LO PUEDO DESACOPLAR
                //PREGUNTAR SI ESTA BIEN PENSADO ASI?????

                userForm.setRolUsuario(servicioRol.findById(userForm.getRolUsuario().getIdRol()));
                model.addAttribute("tipoAccion", "agregado");
                servicioUsuario.addUsuario(userForm);
            } else {

                userForm.setRolUsuario(servicioRol.findById(userForm.getRolUsuario().getIdRol()));
                servicioUsuario.addUsuario(userForm);
                model.addAttribute("tipoAccion", "modificado");
            }

            model.addAttribute("listadoUsuarios", servicioUsuario.getListUser());
            return Constantes.GERENTE_USERLIST;
        }
    }

    @GetMapping("/cancelarAgrearUsuario")
    public String cancelarAgrearUsuario(Model model) {
        model.addAttribute("listadoUsuarios", servicioUsuario.getListUser());
        return Constantes.GERENTE_USERLIST;
    }

//******ELIMINAR USUARIO
    @GetMapping("/eliminarUsuario")
    public String eliminarUsuario(@RequestParam(name = "id", required = true) int id, Model model) {
        model.addAttribute("tipoAccion", "eliminado");
        servicioUsuario.removeUser(id);
        model.addAttribute("listadoUsuarios", servicioUsuario.getListUser());
        return Constantes.GERENTE_USERLIST;
        // return abmUsuarios(model);
    }
}
