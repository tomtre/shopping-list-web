DO $$
DECLARE
	inserted_user_id bigint;
BEGIN
	INSERT INTO users VALUES (NEXTVAL('user_seq'), (current_timestamp - interval '1 hour'), (current_timestamp - interval '1 hour'), 'jackbrown@mail.comx', 'Jack', 'Brown', '$2a$10$D10WQvA6At6FhEygxdns/uxAoOUYfCfnh5pInw4aersqDuBXUuvw.', 'jack')
	RETURNING id INTO inserted_user_id;

	INSERT INTO users_roles VALUES (inserted_user_id, (SELECT id FROM roles WHERE name = 'ROLE_USER') );

	INSERT INTO products VALUES (NEXTVAL('product_seq'), (current_timestamp - interval '5 minute'), (current_timestamp - interval '5 minute'), false, 'Without lactose', '3', 'Milk', 'bottles', inserted_user_id);
	INSERT INTO products VALUES (NEXTVAL('product_seq'), (current_timestamp - interval '4 minute'), (current_timestamp - interval '4 minute'), false, 'Whole grain', '5', 'Bread', null, inserted_user_id);
	INSERT INTO products VALUES (NEXTVAL('product_seq'), (current_timestamp - interval '3 minute'), (current_timestamp - interval '3 minute'), true, 'Fresh! Buy fresh!', '3', 'Orange juice', 'litres', inserted_user_id);
	INSERT INTO products VALUES (NEXTVAL('product_seq'), (current_timestamp - interval '2 minute'), (current_timestamp - interval '2 minute'), false, null, null, 'Spices for barbecue', null, inserted_user_id);
	INSERT INTO products VALUES (NEXTVAL('product_seq'), (current_timestamp - interval '1 minute'), (current_timestamp - interval '1 minute'), false, 'Powdery', '3.5', 'Flour', 'kg', inserted_user_id);
END $$;
