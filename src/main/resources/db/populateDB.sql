DELETE FROM menu_meal;
DELETE FROM user_role;
DELETE FROM meal;
DELETE FROM menu;
DELETE FROM vote;
DELETE FROM restaurant;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

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
VALUES ('2020-01-29',100003),
       ('2020-01-29',100004),
       ('2020-01-29',100005),
       ('2020-01-29',100006),
       ('2020-01-30',100003),
       ('2020-01-30',100004),
       ('2020-01-30',100005),
       ('2020-01-30',100006);

INSERT INTO menu_meal (menu_id, meal_id)
VALUES (100024,100007),
       (100024,100009),
       (100028,100010),
       (100028,100011),
       (100029,100022),
       (100030,100023),
       (100030,100020);
INSERT INTO vote (date_time, restaurant_id,user_id)
VALUES ('2020-01-29',100005,100000),
       ('2020-01-29',100004,100002),
       ('2020-01-28',100006,100002),
       ('2020-01-28',100005,100000),
       ('2020-01-27',100003,100000),
       ('2020-01-27',100003,100002);