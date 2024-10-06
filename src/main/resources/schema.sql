DROP TABLE IF EXISTS AUTHOR;
CREATE TABLE AUTHOR
(
    author_id SERIAL,
    name VARCHAR(255),
    book_id INT
);
INSERT INTO AUTHOR (name, book_id)
VALUES
    ('Adam', 1),
    ('Brad', 1),
    ('Chris', 2),
    ('Duke', 2),
    ('Ellie', 2),
    ('Fred', 3);


DROP TABLE IF EXISTS GENRE;
CREATE TABLE GENRE
(
    genre_id INT,
    name VARCHAR(255)
);

INSERT INTO GENRE (genre_id, name)
VALUES
    (1, 'CS'),
    (2, 'EE'),
    (3, 'CSE'),
    (4, 'MATH');



DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK
(
    id SERIAL,
    title VARCHAR(255),
    authors VARCHAR(255),
    genre_id INT,
    pagecount INT
);

INSERT INTO BOOK (title, genre_id, pagecount)
VALUES
    ('To Kill a Mockingbird', 3, 281),
    ('1984', 2, 328),
    ('Pride and Prejudice', 1, 432);