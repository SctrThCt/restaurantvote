INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('USER', 2),
       ('ADMIN', 2);

INSERT INTO restaurant(name)
VALUES ('Шаурма у Акопа'),
       ('Лё Хрючевальня'),
       ('Бар Голубая устрица'),
       ('Таверна Мо');

INSERT INTO meal (name, price)
VALUES ('Фри', 150),
       ('Фри', 200),
       ('Рулька', 300),
       ('Курица', 250),
       ('Гуляш по коридору', 350),
       ('Гуляш', 400),
       ('Руккола с ногголой', 150),
       ('Пицца', 700),
       ('Чай', 70),
       ('Пиво с мухой', 200),
       ('Пиво без мухи', 180),
       ('Кофе', 150),
       ('Грибной суп', 150),
       ('Солянка', 150),
       ('Почти свежая шаурма', 150),
       ('Свежая шаурма', 250),
       ('Борщ', 150);
INSERT INTO menu (date,restaurant_id)
VALUES ('2020-01-29',1),
       ('2020-01-29',2),
       ('2020-01-29',3),
       ('2020-01-29',4),
       ('2020-01-30',1),
       ('2020-01-30',2),
       ('2020-01-30',3),
       ('2020-01-30',4);

INSERT INTO menu_meal (menu_id, meal_id)
VALUES (8,7),
       (8,9),
       (7,10),
       (7,11),
       (6,12),
       (5,17),
       (5,2);
INSERT INTO vote (date_time, restaurant_id,user_id)
VALUES ('2020-01-29',1,1),
       ('2020-01-29',2,2),
       ('2020-01-28',3,2),
       ('2020-01-28',1,1),
       ('2020-01-27',4,1),
       ('2020-01-27',3,2);