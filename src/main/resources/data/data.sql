INSERT INTO product(code, name, price) VALUES('productCode-1', 'productName-1', 10.00);
INSERT INTO product(code, name, price) VALUES('productCode-2', 'productName-2', 20.00);
INSERT INTO product(code, name, price) VALUES('productCode-3', 'productName-3', 30.00);
INSERT INTO product(code, name, price) VALUES('productCode-4', 'productName-4', 40.00);
INSERT INTO product(code, name, price) VALUES('productCode-5', 'productName-5', 50.00);
INSERT INTO product(code, name, price) VALUES('productCode-6', 'productName-6', 60.00);
INSERT INTO product(code, name, price) VALUES('productCode-7', 'productName-7', 70.00);
INSERT INTO product(code, name, price) VALUES('productCode-8', 'productName-8', 80.00);


INSERT INTO product(code, name, price) VALUES('productCode-9', 'productName-9', 90.00);
INSERT INTO product(code, name, price) VALUES('productCode-10', 'productName-10', 100.00);
INSERT INTO product(code, name, price) VALUES('productCode-11', 'productName-11', 110.00);

INSERT INTO customer_category(category) VALUES ('customer-category-1');
INSERT INTO customer_category(category) VALUES ('customer-category-2');


INSERT INTO customer(category_id, company, first_name, last_name) VALUES (1, 'company-1', 'first-name-1', 'last-name-1');
INSERT INTO customer(category_id, company, first_name, last_name) VALUES (1, 'company-2', 'first-name-2', 'last-name-2');


INSERT INTO address(number, street, city, postal_code, province, country, customer_id) VALUES ('1', 'street-1', 'city-1', 'postalCode-1', 'province-1', 'country-1', 1);
INSERT INTO address(number, street, city, postal_code, province, country, customer_id) VALUES ('1', 'street-2', 'city-2', 'postalCode-2', 'province-2', 'country-2', 1);
