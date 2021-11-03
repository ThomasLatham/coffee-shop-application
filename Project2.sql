tables

create table users(
   user_id serial primary key,
   first_name varchar(50),
   last_name varchar(50),
   username varchar(50),
   u_password varchar(50),
   user_role int references user_role(role_id) 	
);

create table user_roles(
    role_id serial primary key,
	role_name varchar(50)
	
);


create table shops(
    shop_id serial primary key,
	shop_location varchar(50),
	shop_pic int references pictures(pic_id)
);


create table menu_items(
    item_id serial primary key,
    item_name varchar(50),
    item_price bigint,
    item_prep_time bigint,
    menu_cat int references categories(category_id),
    item_pic varchar(50) references pictures(pic_id),
    
);


create table categories(
	category_id serial primary key,
	category varchar(50)
);


create table orders(
    order_id serial primary key,
    order_time bigint,
    order_status int references status(status_id),
    oredered_by int references users(user_id),
    order_payment int
);


create table status(
	status_id serial primary key,
	status varchar(50)
);

--Junction table for menu_items and order_item
create table order_item(
	order_id references orders(order_id),
	item_id references menu_items(item_id),
	item_count int
);

create table pictures(
	pic_id serial primary key,
	pic_name varchar(50),
	pic_type bytea 
);















