-- init products
insert into PRO_PRODUCT (PRO_ID, PRO_NM, PRO_PRICE) values (1000, 'power of habit', 50.00);
insert into PRO_PRODUCT (PRO_ID, PRO_NM, PRO_PRICE) values (1001, 'power of habit', 50.00);

--Store
insert  into str_store (str_id, str_nm) values (100, 'Americanas - unidade shopping partage');

-- Store Address
insert into add_address (add_city, add_country, add_fu, add_neighborhood, add_number, add_postal_code, add_street, str_id, tp_endereco, add_id)  values ('Campina Grande', 'Brasil', 'PB', 'Centro', '1000', '28062040', 'Av. Brasília', 100, 'S', 100);


-- Order
insert into ord_order (ord_dt_confirmation, ord_status, ord_date_time, str_id) values (null, 2, '2019-04-03T23:56:36', 100);

-- Order Address
insert into add_address (add_city, add_country, add_fu, add_neighborhood, add_number, add_postal_code, add_street, str_id, tp_endereco, add_id, ord_date_time)  values ('João Pessoa', 'Brasil', 'PB', 'Centro', '101', '58062048', 'Av. deputado geraldo mariz', 100, 'O', 101, '2019-04-03T23:56:36');

-- items from order
insert into ori_item (ori_quantity, ori_unit_price, pro_id, ord_date_time, str_id) values (100, 10.5, 1000, '2019-04-03T23:56:36', 100);
insert into ori_item (ori_quantity, ori_unit_price, pro_id, ord_date_time, str_id) values (10, 25.3, 1001, '2019-04-03T23:56:36', 100);