--DROPPERS--
drop table if exists menu_item_ingredients;
drop table if exists ingredient_order_items;
	drop table if exists ingredients;
	drop table if exists order_items;
		drop table if exists orders;
			drop table if exists order_statuses;
			drop table if exists payment_types;

drop table if exists daily_specials;
	drop table if exists menu_items;
		drop table if exists item_categories;
	drop table if exists shops;
		drop table if exists pictures;

drop table if exists user_addresses;
	drop table if exists users;
		drop table if exists user_roles;

--CREATORS--
create table pictures(
	pic_id serial primary key,
	pic_name varchar(50),
	pic_type bytea 
);

create table user_roles(
    role_id serial primary key,
	role_name varchar(50)
);

create table users(
   user_id serial primary key,
   first_name varchar(50),
   last_name varchar(50),
   phone_number varchar(50),
   email_address varchar(100),
   username varchar(50),
   password varchar(50),
   user_role int references user_roles(role_id) 	
);

create table user_addresses(
	address_id serial primary key,
	user_id int references users(user_id),
	street varchar(50),
	city varchar(50),
	zip_code int
);

create table shops(
    shop_id serial primary key,
	shop_location varchar(50),
	shop_pic int references pictures(pic_id)
);

create table item_categories(
	category_id serial primary key,
	category varchar(50)
);

create table menu_items(
    item_id serial primary key,
    item_name varchar(50),
    item_price numeric (4,2),
    item_prep_time bigint,
    item_category int references item_categories(category_id),
    item_pic int references pictures(pic_id)
);

create table daily_specials(
	daily_special_id serial primary key,
	shop_id int references shops(shop_id),
	day_of_week int,
	menu_item_id int references menu_items(item_id)
);

create table ingredients(
	ingredient_id serial primary key,
	ingredient_name varchar(50),
	cost numeric(4,2)
);

--Junction table: menu_items and ingredients--
create table menu_item_ingredients(
	item_id int references menu_items(item_id),
	ingredient_id int references ingredients(ingredient_id)
);

create table order_statuses(
	status_id serial primary key,
	status varchar(50)
);

create table payment_types(
	payment_type_id serial primary key,
	payment_type_name varchar(50)
);

create table orders(
    order_id serial primary key,
    order_time bigint,
    order_status int references order_statuses(status_id),
    oredered_by int references users(user_id),
    order_payment int references payment_types(payment_type_id),
    delivery boolean
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


--POPULATORS--

	--REFERENCE TABLES--
insert into order_statuses values 
	(default, 'Order Received'),
	(default, 'In Progress'),
	(default, 'Ready'),
	(default, 'Delivery in Progress'),
	(default, 'Delivered'),
	(default, 'Order Complete');

insert into item_categories values
	(default, 'Drinks'),
	(default, 'Food');

insert into payment_types values
	(default, 'cash');

insert into user_roles values
	(default, 'customer'),
	(default, 'manager');

insert into pictures values
	(default, 'dummyUrl', '\\xDEADBEEF'),
	(default, 'dummyUrl', '\\xDEADBEEF'),
	(default, 'dummyUrl', '\\xDEADBEEF'),
	(default, 'dummyUrl', '\\xDEADBEEF');


	--MEAT TABLES--
insert into menu_items values
	(default, 'espresso', 2.50, 120000, 1, 1),
	(default, 'americano', 2.75, 150000, 1, 1),
	(default, 'machiatto', 3.00, 180000, 1, 1),
	(default, 'cappuccino', 3.25, 120000, 1, 1),
	(default, 'latte', 3.50, 150000, 1, 1),
	(default, 'croissant', 3.00, 30000, 2, 1),
	(default, 'breakfast sandwich', 5.00, 300000, 2, 1),
	(default, 'cheese Danish', 3.00, 30000, 2, 1),
	(default, 'sugar cookie', 2.50, 30000, 2, 1);

insert into ingredients values 
	(default, 'almond milk', 0.50),
	(default, 'sugar', 0.25),
	(default, 'artificial sweetener', 0.50),
	(default, 'soy milk', 1.00),
	(default, 'honey', 0.50),
	(default, 'extra cheese', 0.50),
	(default, 'extra spicy', 0.75);
	

insert into menu_item_ingredients values
	(1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
	(2, 1), (2, 2), (2, 3), (2, 4), (2, 5),
	(3, 1), (3, 2), (3, 3), (3, 4), (3, 5),
	(4, 1), (4, 2), (4, 3), (4, 4), (4, 5),
	(5, 1), (5, 2), (5, 3), (5, 4), (5, 5),
	(6, 5),
	(7, 6), (7, 7),
	(8, 5),
	(9, 5);


	
	


	
	









