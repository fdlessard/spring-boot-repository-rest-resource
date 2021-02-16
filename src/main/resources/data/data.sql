INSERT INTO customer(company, first_name, last_name) VALUES ('company-1', 'first-name-1', 'last-name-1');
INSERT INTO customer(company, first_name, last_name) VALUES ('company-2', 'first-name-2', 'last-name-2');


INSERT INTO address(number, street, city, postal_code, province, country, customer_id) VALUES ('1', 'street-1', 'city-1', 'postalCode-1', 'province-1', 'country-1', 1);
INSERT INTO address(number, street, city, postal_code, province, country, customer_id) VALUES ('1', 'street-2', 'city-2', 'postalCode-2', 'province-2', 'country-2', 1);

INSERT INTO customer_group(name) VALUES ('group-name-1');

INSERT INTO customer_group_customer(customer_group_id, customer_id) VALUES (1, 1);
INSERT INTO customer_group_customer(customer_group_id, customer_id) VALUES (1, 2);