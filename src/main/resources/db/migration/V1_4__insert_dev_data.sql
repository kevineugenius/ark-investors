INSERT INTO client(name) VALUES ('Phil');
INSERT INTO client(name) VALUES ('Marie');
INSERT INTO client(name) VALUES ('Alex');

INSERT INTO investor(created_by, name) VALUES (1, 'Jorge');
INSERT INTO investor(created_by, name) VALUES (3, 'Filipa');

INSERT INTO fund(name, created_by) VALUES ('Phils Fund', 1);
INSERT INTO fund(name, created_by) VALUES ('Goat Fund', 3);

INSERT INTO fund_investor(fund, investor) VALUES (1, 1);
INSERT INTO fund_investor(fund, investor) VALUES (1, 2);

INSERT INTO transaction_type(name, multiplier) VALUES ('contribution', 1);
INSERT INTO transaction_type(name, multiplier) VALUES ('interest income', 1);
INSERT INTO transaction_type(name, multiplier) VALUES ('distribution', -1);
INSERT INTO transaction_type(name, multiplier) VALUES ('general expense', -1);
INSERT INTO transaction_type(name, multiplier) VALUES ('management fee', -1);