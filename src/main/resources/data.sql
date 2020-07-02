CREATE TABLE IF NOT EXISTS news(
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT,
    title VARCHAR(200) NOT NULL,
    body VARCHAR(1000000) NOT NULL
);

CREATE TABLE IF NOT EXISTS categories(

    id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR(200) NOT NULL

);

CREATE TABLE IF NOT EXISTS subscription(

    id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT,
    user_email VARCHAR(100) NOT NULL

);

CREATE TABLE IF NOT EXISTS image(

    id INT AUTO_INCREMENT PRIMARY KEY,
    news_id INT,
    source VARCHAR(200) NOT NULL

);

INSERT INTO categories (id,names) VALUES (1,'Category Test 1');
INSERT INTO categories (id,names) VALUES (2,'Category Test 2');
INSERT INTO categories (id,names) VALUES (3,'Category Test 3');

insert into news (id, category_id, title, body) values (1, 1, 'Teste 1', 'Corpo 1');
insert into news (id, category_id, title, body) values (2, 3, 'Teste 2', 'Corpo 2');
insert into news (id, category_id, title, body) values (3, 2, 'Teste 3', 'Corpo 3');
insert into news (id, category_id, title, body) values (4, 2, 'Teste 4', 'Corpo 4');

insert into image (id, news_id, source) values (1, 1, 'source0.jpg');
insert into image (id, news_id, source) values (2, 1, 'source1.jpg');
insert into image (id, news_id, source) values (3, 2, 'source2.jpg');
insert into image (id, news_id, source) values (4, 3, 'source3.jpg');
insert into image (id, news_id, source) values (5, 4, 'source4.jpg');
insert into image (id, news_id, source) values (6, 3, 'source5.jpg');
insert into image (id, news_id, source) values (7, 4, 'source6.jpg');
insert into image (id, news_id, source) values (8, 1, 'source7.jpg');

insert into subscription (id, category_id, user_email) values (1, 1, 'teste1@teste.com');
insert into subscription (id, category_id, user_email) values (2, 2, 'teste2@teste.com');
insert into subscription (id, category_id, user_email) values (3, 3, 'teste3@teste.com');