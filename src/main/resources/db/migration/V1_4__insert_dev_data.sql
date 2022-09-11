INSERT INTO client(name) VALUES ('Phil');
INSERT INTO client(name) VALUES ('Marie');
INSERT INTO client(name) VALUES ('Alex');

INSERT INTO investor(created_by, name) VALUES (1, 'Jorge');
INSERT INTO investor(created_by, name) VALUES (3, 'Filipa');

INSERT INTO fund(name, created_by) VALUES ('Phils Fund', 1);
INSERT INTO fund(name, created_by) VALUES ('Goat Fund', 3);

INSERT INTO fund_investor(fund, investor) VALUES (1, 1);
INSERT INTO fund_investor(fund, investor) VALUES (1, 2);
