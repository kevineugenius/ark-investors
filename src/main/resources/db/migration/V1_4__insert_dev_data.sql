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

INSERT INTO transaction(investor_id, type, amount, fund_id) VALUES (1, 1, 40.40, 1);
INSERT INTO transaction(investor_id, type, amount, fund_id) VALUES (1, 1, 41.41, 1);
INSERT INTO transaction(investor_id, type, amount, fund_id) VALUES (1, 3, 42.24, 1);
INSERT INTO transaction(investor_id, type, amount, fund_id) VALUES (2, 1, 140.10, 1);
INSERT INTO transaction(investor_id, type, amount, fund_id) VALUES (2, 4, 240.20, 1);
INSERT INTO transaction(investor_id, type, amount, fund_id) VALUES (2, 2, 340.30, 1);