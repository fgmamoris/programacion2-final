package com.programacion2.Final.controller;

import com.programacion2.Final.constantes.Constantes;
import com.programacion2.Final.entity.UsuarioEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping(path = {"/logout", "/salir"})//nivel de metodo
    public String loginPath(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return Constantes.LOGIN_PATH;
    }
}
