INSERT INTO tb_book (title,author,year) VALUES ('Uma Terra Prometida','teste',2020);
INSERT INTO tb_book (title,author,year) VALUES ('Rápido e Devagar','teste',2020);
INSERT INTO tb_book (title,author,year) VALUES ('A Arte de Fazer Acontecer','teste',2020);

INSERT INTO tb_user(name,login,password,email) VALUES ('Ana', 'ana','12345','ana@email.com')
INSERT INTO tb_user(name,login,password,email) VALUES ('Carlos', 'carlos','12345','carlos@email.com')
INSERT INTO tb_user(name,login,password,email) VALUES ('Laura', 'laura','12345','laura@email.com')

INSERT INTO tb_comment(date,description,book_id,user_id) VALUES (NOW(), 'Livro excelente',1,1)

INSERT INTO tb_user_book(description,level,status,title,user_id) VALUES ('livro muito bom',4,1,'recomendo',1)

INSERT INTO tb_target_book(quantity,quantity_read,year,user_id) VALUES (10,5,2020,1)