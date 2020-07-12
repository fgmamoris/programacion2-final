package com.programacion2.Final.controller;

import com.programacion2.Final.constantes.Constantes;
import com.programacion2.Final.entity.EstadoPedidoEntity;
import com.programacion2.Final.entity.IngredienteEntity;
import com.programacion2.Final.entity.ItemPedido;
import com.programacion2.Final.entity.ItemEntity;
import com.programacion2.Final.entity.PedidoEntity;
import com.programacion2.Final.service.EstadoPedidoService;
import com.programacion2.Final.service.IngrService;
import com.programacion2.Final.service.ItemService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.programacion2.Final.service.ItemPedidoService;
import com.programacion2.Final.service.PedidoService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/vendedor")
public class VendedorController {

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

    private ArrayList<ItemPedido> obtenerPedido(HttpServletRequest request) {
        ArrayList<ItemPedido> ItemsPedido = (ArrayList<ItemPedido>) request.getSession().getAttribute("pedido");
        if (ItemsPedido == null) {
            ItemsPedido = new ArrayList<>();
        }
        return ItemsPedido;
    }

    private void guardarPedido(ArrayList<ItemPedido> ItemsPedido, HttpServletRequest request) {
        request.getSession().setAttribute("pedido", ItemsPedido);

    }

    @GetMapping(value = "/")
    public String interfazVenta(Model model, HttpServletRequest request) {
        model.addAttribute("listaItems", servicioItem.getListItemsActivos(true));
        ArrayList<ItemPedido> pedido = this.obtenerPedido(request);
        this.guardarPedido(pedido, request);
        return Constantes.VENDEDOR_LISTA;
    }

    @GetMapping("/agregarItemPedido")
    public String agregarItemPedido(
            @RequestParam(name = "idItem", required = false) int idItem,
            Model model) {
        int[] cantidades = {1, 2, 3, 4, 5};
        model.addAttribute("item", servicioItem.findById(idItem));
        model.addAttribute("listaIngredientesActivos", servicioIngrediente.getListIngredientesActivos(true));
        model.addAttribute("cantidades", cantidades);
        model.addAttribute("invalidCantidad", 1);
        return Constantes.VENDEDOR_AGREGARITEM;
    }

    @PostMapping("/confirmarAgregarItemPedido")
    public String confirmarAgregarItemPedido(
            @ModelAttribute("item") ItemEntity item, HttpServletRequest request,
            //No bindea el objeto Item correctamente, no trae ni la lista ni el nombre.
            //Lo recupero con el findby, podria hacer lo mismo que con el pedido, pero no aporta nada
            @RequestParam(name = "listaIngredientesAgregar", required = false) int[] listaIngredientesAgregar,
            @RequestParam(name = "listaIngredientesQuitar", required = false) int[] listaIngredientesQuitar,
            @RequestParam(name = "cantidad", required = false) int cantidad,
            Model model
    ) {

        ArrayList<ItemPedido> pedido = this.obtenerPedido(request);
        ItemPedido itemAgregar = new ItemPedido();
        for (int i = 0; i < cantidad; i++) {
            List<IngredienteEntity> listaAgregar = new ArrayList<>();
            List<IngredienteEntity> listaQuitar = new ArrayList<>();
            if (listaIngredientesAgregar != null) {
                for (int j : listaIngredientesAgregar) {
                    listaAgregar.add(servicioIngrediente.findById(j));
                }
                itemAgregar.setListaIngredientesAgregar(listaAgregar);
            }
            if (listaIngredientesQuitar != null) {
                for (int j : listaIngredientesQuitar) {
                    listaQuitar.add(servicioIngrediente.findById(j));
                }
                itemAgregar.setListaIngredientesQuitar(listaQuitar);
            }
            itemAgregar.setItem(servicioItem.findById(item.getIdItem()));
            pedido.add(itemAgregar);
        }
        this.guardarPedido(pedido, request);
        return "redirect:" + Constantes.VENDEDOR_PATH;
    }

    @GetMapping("/cancelarAgregarItemPedido")
    public String cancelarAgregarItemPedido(Model model) {
        return "redirect:" + Constantes.VENDEDOR_PATH;
    }

    @GetMapping("/quitarItemPedido")
    public String quitarItemPedido(Model model,
            @RequestParam(name = "idItem", required = false) int idItemPedido, HttpServletRequest request) {
        ArrayList<ItemPedido> pedido = this.obtenerPedido(request);
        pedido.remove(idItemPedido);
        return "redirect:" + Constantes.VENDEDOR_PATH;
    }

    @PostMapping("/confirmarPedido")
    public String confirmarPedido(Model model, HttpServletRequest request) //            @ModelAttribute("pedido") PedidoEntity pedido) //@RequestParam(name = "idPedido", required = false) int idPedido) {
    {
        ArrayList<ItemPedido> listaItemPedido = this.obtenerPedido(request);
        PedidoEntity pedidoNuevo = new PedidoEntity();

        pedidoNuevo.setEstado(servicioEstadoPedido.findByEstado(Constantes.ESTADO_PEDIDO_PREP));
//        Lo guardo antes para obtener un id pedido y poder hacer la relacion con los items del pedido.
        pedidoNuevo = servicioPedido.guardarPedido(pedidoNuevo);
        for (ItemPedido i : listaItemPedido) {
            ItemPedido j = new ItemPedido();
            j.setItem(i.getItem());
            j.setListaIngredientesAgregar(i.getListaIngredientesAgregar());
            j.setListaIngredientesQuitar(i.getListaIngredientesQuitar());
            j.setPedido(pedidoNuevo);
            j = servicioItemPedido.saveItemPedido(j);
            //pedidoNuevo.getListaItemsPedido().add(j);
        }

        /*listaItempedido.stream().forEach((p) -> {
            p.setPedido(pedidoNuevo);
        });*/
        this.limpiarPedido(request);
        return "redirect:" + Constantes.VENDEDOR_PATH;

    }

    private void limpiarPedido(HttpServletRequest request) {
        this.guardarPedido(new ArrayList<>(), request);
    }

    @GetMapping("/cancelarPedido")
    public String cancelarPedido(Model model, HttpServletRequest request) {
        this.limpiarPedido(request);
        return "redirect:" + Constantes.VENDEDOR_PATH;

    }

}
