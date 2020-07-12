/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.programacion2.Final.constantes;

/**
 *
 * @author User
 */
public class Constantes {

    public static final String LOGIN_PATH = "login";
    public static final String LOGIN_ERROR = "login?error";
    public static final String LOGOUT_PATH = "logout";

    public static final String GERENTE_PATH = "/gerente/";
    public static final String GERENTE = "/gerente/gerente";
    public static final String GERENTE_USER = "/gerente/agregarusuario";
    public static final String GERENTE_USER_ERROR = "/admin/addUser?invalidData";
    public static final String GERENTE_USERLIST = "/gerente/listaUsuarios";

    public static final String GERENTE_ITEM_PATH = "/gerente/agregaritem";
    public static final String GERENTE_ITEMS_LISTA = "/gerente/listaItems";

    public static final String GERENTE_INGREDIENTE_PATH = "/gerente/agregaringrediente";
    public static final String GERENTE_INGREDIENTES_LISTA = "/gerente/listaIngredientes";

    public static final String GERENTE_PEDIDO_DETALLE = "/gerente/detallePedido";
    public static final String GERENTE_PEDIDOS_LISTA = "/gerente/listaPedidos";

    public static final String COCINERO_PATH = "/cocinero/";
    public static final String COCINERO_LISTA = "/cocinero/pedidoscocinero";
    public static final String COCINERO_DETALLE = "/cocinero/detallecocinero";

    public static final String VENDEDOR_PATH = "/vendedor/";
    public static final String VENDEDOR_LISTA = "/vendedor/vendedor";
    public static final String VENDEDOR_AGREGARITEM = "/vendedor/agregarItemPedido";

    public static final String ESTADO_ACT = "activo";
    public static final String ESTADO_DESACT = "inactivo";

    public static final String ESTADO_PEDIDO_PREP = "preparacion";
    public static final String ESTADO_PEDIDO_ENTR = "entregado";
    public static final String ESTADO_PEDIDO_CANCEL = "cancelado";

}
