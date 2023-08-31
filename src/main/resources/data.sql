INSERT INTO
    application_user (first_name, last_name, pesel, email, password)
VALUES
    ('Damian', 'Kołcz', 'pesel', 'damian@gmail.com', '{bcrypt}$2a$10$Ruu5GtmSVkfLeuGfz/wHUuzflCcMbwJHSBo/.Wui0EM0KIM52Gs2S');
INSERT INTO
    user_role (name, description)
VALUES
    ('ADMIN', 'Ma dostęp do wszystkiego');
INSERT INTO
    user_roles (user_id, role_id)
VALUES
    (1, 1);

INSERT INTO
    item (indeks, name, hour_price)
VALUES
    ('354545', 'Laptop', '50'),
    ('456514', 'Rower', '100'),
    ('324388', 'Samochod', '300');

INSERT INTO
    client (first_name, last_name, pesel, email)
VALUES
    ('Alicja', 'Kołcz', '91030804599', 'alicja@gmail.com'),
    ('Damian', 'Kołcz', '91234566699', 'alicja@gmail.com'),
    ('Magda', 'Kołcz',  '92344804599', 'magda@gmail.com');

INSERT INTO
    rental (poczatek, koniec, client_id, items_id, status)
VALUES
    ('2022-12-20', '2022-12-23', 1, 1, 'IN_PROGRESS'),
    ('2022-12-23', '2022-12-24', 2, 2, 'COMPLETED');





