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
import com.programacion2.Final.service.RolService;
import org.springframework.stereotype.Controller;
import com.programacion2.Final.service.IngrService;
import com.programacion2.Final.service.ItemPedidoService;
import com.programacion2.Final.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gerente")
public class PedidoController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);


    @Autowired
    @Qualifier("servicioPedido")
    private PedidoService servicioPedido;

    @Autowired
    @Qualifier("servicioEstadoPedido")
    private EstadoPedidoService servicioEstadoPedido;

    @GetMapping("/filtrarPedido")
    public String filtrarPedido(
            @RequestParam(name = "idEstado", required = false) int idEstado,
            Model model) {
        model.addAttribute("estadosPedido", servicioEstadoPedido.findAll());
        model.addAttribute("listaPedidos", servicioPedido.findListaPorEstadoOrdenada(servicioEstadoPedido.findById(idEstado)));
        return Constantes.GERENTE_PEDIDOS_LISTA;
    }

    @GetMapping("/detallePedido")
    public String detallePedido(
            @RequestParam(name = "id", required = false) int idPedido,
            Model model) {
        model.addAttribute("pedido", servicioPedido.findById(idPedido));
        return Constantes.GERENTE_PEDIDO_DETALLE;
    }

}
