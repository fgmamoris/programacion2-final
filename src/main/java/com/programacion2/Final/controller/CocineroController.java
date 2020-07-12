package com.programacion2.Final.controller;

import com.programacion2.Final.constantes.Constantes;

import com.programacion2.Final.entity.PedidoEntity;

import com.programacion2.Final.service.EstadoPedidoService;
import com.programacion2.Final.service.IngrService;
import com.programacion2.Final.service.ItemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.programacion2.Final.service.ItemPedidoService;
import com.programacion2.Final.service.PedidoService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cocinero")
public class CocineroController {

    private static final Log LOGGER = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("servicioIngrediente")
    private IngrService servicioIngrediente;

    @Autowired
    @Qualifier("servicioItem")
    private ItemService servicioItem;

    @Autowired
    @Qualifier("servicioItemPedido")
    private ItemPedidoService servicioItemPedido;

    @Autowired
    @Qualifier("servicioPedido")
    private PedidoService servicioPedido;

    @Autowired
    @Qualifier("servicioEstadoPedido")
    private EstadoPedidoService servicioEstadoPedido;

    @GetMapping(value = "/")
    public String interfazCocina(Model model) {
        model.addAttribute(
                "pedidos", servicioPedido.findByEstado(servicioEstadoPedido.findByEstado(Constantes.ESTADO_PEDIDO_PREP)));
        return Constantes.COCINERO_LISTA;
    }

    @GetMapping("/prepararPedido")//nivel de metodo
    public String prepararPedido(@RequestParam(name = "id") int idPedido,
            Model model) {
        model.addAttribute("pedido", servicioPedido.findById(idPedido));
        return Constantes.COCINERO_DETALLE;
    }

    @PostMapping("/confirmarEntrega")//nivel de metodo
    public String confirmarEntrega(@ModelAttribute("pedido") PedidoEntity pedido,
            Model model) {
        PedidoEntity pedidoConfirmar = servicioPedido.findById(pedido.getId());
        pedidoConfirmar.setEstado(servicioEstadoPedido.findByEstado(Constantes.ESTADO_PEDIDO_ENTR));
        servicioPedido.actualizarPedido(pedidoConfirmar);
        return "redirect:" + Constantes.COCINERO_PATH;
    }

    @GetMapping("/pedidos")
    public String listarPedidos() {
        return "redirect:" + Constantes.COCINERO_PATH;

    }

    @GetMapping("/volver")
    public String volver() {
        return "redirect:" + Constantes.COCINERO_PATH;

    }
}
