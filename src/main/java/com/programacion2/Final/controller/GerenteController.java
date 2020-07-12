package com.programacion2.Final.controller;

import com.programacion2.Final.service.UsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.programacion2.Final.constantes.Constantes;
import com.programacion2.Final.service.EstadoPedidoService;
import com.programacion2.Final.service.ItemService;
import org.springframework.stereotype.Controller;
import com.programacion2.Final.service.IngrService;
import com.programacion2.Final.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gerente")
public class GerenteController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("servicioUsuario")
    private UsuarioService servicioUsuario;

    @Autowired
    @Qualifier("servicioIngrediente")
    private IngrService servicioIngrediente;

    @Autowired
    @Qualifier("servicioItem")
    private ItemService servicioItem;

    @Autowired
    @Qualifier("servicioPedido")
    private PedidoService servicioPedido;

    @Autowired
    @Qualifier("servicioEstadoPedido")
    private EstadoPedidoService servicioEstadoPedido;

    @GetMapping(value = "/")
    public String interfazGerencia(Model model) {
        return Constantes.GERENTE;
    }

//**********ADMINISTRACION USUARIOS
    @GetMapping("/abmUsers")//nivel de metodo
    public String abmUsuarios(Model model) {
        model.addAttribute("listadoUsuarios", servicioUsuario.getListUser());
        return Constantes.GERENTE_USERLIST;
    }

    @GetMapping("/volverGerente")//nivel de metodo
    public String volverGerente(Model model) {
        return Constantes.GERENTE;
    }

//**************INGREDIENTES********************************************************/////
    @GetMapping("/abmIngredientes")//nivel de metodo
    public String abmIngredientes(Model model) {

        model.addAttribute("listaIngredientes", servicioIngrediente.getListIngredientesActivos(true));

        return Constantes.GERENTE_INGREDIENTES_LISTA;
    }

    //**************ITEMS******************************************************
    @GetMapping("/abmItems")//nivel de metodo
    public String abmItems(Model model) {

        model.addAttribute("listaItems",
                servicioItem.getListItemsActivos(true));
        return Constantes.GERENTE_ITEMS_LISTA;
    }

    @GetMapping("/pedidos")//nivel de metodo
    public String pedidos(Model model) {
        model.addAttribute("listaPedidos", servicioPedido.getListaPedidosOrdenada());
        model.addAttribute("estadosPedido", servicioEstadoPedido.findAll());
        return Constantes.GERENTE_PEDIDOS_LISTA;
    }

}
