
INSERT INTO pricelist(price_forkm, price_for_one_day ) VALUES (10, 12);
INSERT INTO pricelist(price_forkm, price_for_one_day) VALUES (12, 11 );
INSERT INTO pricelist(price_forkm, price_for_one_day) VALUES (14, 12 );

INSERT INTO ad(end_date, start_date, id_price_list) VALUES ('2025-01-11 01:00:00', '2023-06-14 04:00:00', 1);
INSERT INTO ad(end_date, start_date, id_price_list) VALUES ('2024-02-12 02:00:00', '2022-07-15 05:00:00', 1);
INSERT INTO ad(end_date, start_date, id_price_list) VALUES ('2023-03-13 03:00:00', '2021-08-16 06:00:00', 1);

INSERT INTO discount(discount, for_more_thanxdays, version, id_price_list) VALUES (5, 15, 0, 1);

