insert into estadopedido value ('1','entregado');
insert into estadopedido value ('2','preparacion');
insert into roles value ('1', 'Gerente');
insert into roles value ('2', 'Vendedor');
insert into roles value ('3', 'Cocinero');
##insert into usuarios value ('1', 'ApellidoUsuario', 'legajo', 'NombreUsuario','password','rol');
insert into usuarios value ('1', 'Mamoris', '1', 'Federico','1','1');

##Items
insert into items value ('1',true,false,'Coca Cola');
insert into items value ('2',true,false,'Sprite');
insert into items value ('3',true,true, 'Whopper');
insert into items value ('4',true, true,'King de Pollo');
insert into items value ('5',true, false,'Ensalada Stacker con o sin pollo');
insert into items value ('6',true, true,'Extra Burger');
insert into items value ('7',true, true,'Doble BBQ Bacon XL');
insert into items value ('8',true,false,'Sundae');

##Ingredientes
insert into ingredientes value ('1',true,'Lechuga');
insert into ingredientes value ('2',true,'Tomate');
insert into ingredientes value ('3',true,'Pepino');
insert into ingredientes value ('4',true,'Cebolla');
insert into ingredientes value ('5',true,'Panceta');
insert into ingredientes value ('6',true,'Mayonesa');
insert into ingredientes value ('7',true,'Mostaza');
insert into ingredientes value ('8',true,'Ketchup');
insert into ingredientes value ('9',true,'Queso Chedar');
insert into ingredientes value ('10',true,'Barbacoa');

##Relacion Item-Ingredientes
insert into rel_item_ingrediente value ('3','1');
insert into rel_item_ingrediente value ('3','2');
insert into rel_item_ingrediente value ('3','3');
insert into rel_item_ingrediente value ('3','4');
insert into rel_item_ingrediente value ('3','6');
insert into rel_item_ingrediente value ('3','8');
insert into rel_item_ingrediente value ('4','6');
insert into rel_item_ingrediente value ('4','1');
insert into rel_item_ingrediente value ('6','5');
insert into rel_item_ingrediente value ('6','7');
insert into rel_item_ingrediente value ('6','8');
insert into rel_item_ingrediente value ('6','9');
insert into rel_item_ingrediente value ('7','9');
insert into rel_item_ingrediente value ('7','10');
insert into rel_item_ingrediente value ('7','5');

##Pedidos
insert into pedidos value ('1','1');
insert into pedidos value ('2','1');
insert into pedidos value ('3','1');
insert into pedidos value ('4','2');
insert into pedidos value ('5','2');

##Relacion entre Pedidos-Item
insert into itempedido  value ('1','1','1');
insert into itempedido  value ('2','2','1');
insert into itempedido  value ('3','3','1');
insert into itempedido  value ('4','4','1');
insert into itempedido  value ('5','5','1');
insert into itempedido  value ('6','6','2');
insert into itempedido  value ('7','7','2');
insert into itempedido  value ('8','8','2');
insert into itempedido  value ('9','8','2');
insert into itempedido  value ('10','8','2');
insert into itempedido  value ('11','7','3');
insert into itempedido  value ('12','7','3');
insert into itempedido  value ('13','6','3');
insert into itempedido  value ('14','6','3');
insert into itempedido  value ('15','6','4');
insert into itempedido  value ('16','5','4');
insert into itempedido  value ('17','4','4');
insert into itempedido  value ('18','3','5');
insert into itempedido  value ('19','2','5');
insert into itempedido  value ('20','1','5');
