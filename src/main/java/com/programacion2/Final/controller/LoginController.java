package com.programacion2.Final.controller;

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
import com.programacion2.Final.constantes.Constantes;
import com.programacion2.Final.entity.UsuarioEntity;
import com.programacion2.Final.service.EstadoPedidoService;
import com.programacion2.Final.service.ItemService;
import com.programacion2.Final.service.PedidoService;

@Controller
public class LoginController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("servicioUsuario")
    private UsuarioService usuarioServicio;

    @Autowired
    @Qualifier("servicioPedido")
    private PedidoService servicioPedido;

    @Autowired
    @Qualifier("servicioEstadoPedido")
    private EstadoPedidoService servicioEstadoPedido;

    @Autowired
    @Qualifier("servicioItem")
    private ItemService servicioItem;

    @GetMapping(path = {"/", "/login", "index"})//nivel de metodo
    public String loginPath(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return Constantes.LOGIN_PATH;
    }

    @PostMapping("/loginCheck")
    public String listadoCheck(@ModelAttribute("usuario") UsuarioEntity userLogin, Model model) {
        UsuarioEntity userLog = usuarioServicio.findUserCredential(userLogin.getLegajo(), userLogin.getPassword());
        if (usuarioServicio.findUserCredential(userLogin.getLegajo(), userLogin.getPassword()) != null) {
            return "redirect:/" + userLog.getRolUsuario().getTipoRol().toLowerCase() + "/";                                                                                                                                                                     
        }
        model.addAttribute("error", "vacio");
        // return "redirect:/" + Constantes.LOGIN_PATH; con el redirect le tengo que pasar los atributos flash para validar
//        Con redirect puedo entrar directamente a un metodo GET
        return Constantes.LOGIN_PATH;
    }
}
