--Notes: need to talk about:


--DROPPERS--





--CREATORS--
create table users(
   user_id serial primary key,
   first_name varchar(50),
   last_name varchar(50),
   phone_number varchar(50),
   email_address varchar(100),
   username varchar(50),
   password varchar(50),
   user_role int references user_role(role_id) 	
);

create table user_addresses(
	address_id serial primary key,
	user_id int references users(user_id),
	street varchar(50),
	city varchar(50),
	zip_code int
);

create table user_roles(
    role_id serial primary key,
	role_name varchar(50)
);

create table daily_specials(
	daily_special_id serial primary key,
	shop_id int references shops(shop_id),
	day_of_week int,
	menu_item_id references menu_items(menu_item_id)
);


create table shops(
    shop_id serial primary key,
	shop_location varchar(50),
	shop_pic int references pictures(pic_id)
);


create table menu_items(
    item_id serial primary key,
    item_name varchar(50),
    item_price numeric (4,2),
    item_prep_time bigint,
    item_category int references item_categories(category_id),
    item_pic varchar(50) references pictures(pic_id)
);

--Junction table--
create table menu_item_ingredients(
	item_id int references menu_items(item_id),
	ingredient_id int references ingredients(ingredient_id)
);

create table ingredients(
	ingredient_id serial primary key,
	ingredient_name varchar(50),
	cost numeric(4,2)
);


create table item_categories(
	category_id serial primary key,
	category varchar(50)
);


create table orders(
    order_id serial primary key,
    order_time bigint,
    order_status int references order_statuses(status_id),
    oredered_by int references users(user_id),
    order_payment int references payment_types(payment_type_id),
    delivery boolean
);

create table payment_types(
	payment_type_id serial primary key,
	payment_type_name varchar(50)
);


create table order_statuses(
	status_id serial primary key,
	status varchar(50)
);


--Junction table for menu_items and order_item
create table order_items(
	order_item_id serial primary key,
	order_id int references orders(order_id),
	item_id int references menu_items(item_id),
	item_count int
);

--Junction table for extra_ingredients and order_items
create table ingredient_order_items(
	order_item_id int references order_items(order_item_id),
	ingredient_id int references ingredients(ingredient_id),
	ingredient_count int
);

create table pictures(
	pic_id serial primary key,
	pic_name varchar(50),
	pic_type bytea 
);



insert into order_statuses values 
	(default, 'Order Received'),
	(default, 'In Progress'),
	(default, 'Ready'),
	(default, 'Delivery in Progress')
	(default, 'Delivered'),
	(default, 'Order Complete');











