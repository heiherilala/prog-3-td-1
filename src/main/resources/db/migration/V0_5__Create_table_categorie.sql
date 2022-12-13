create table categorie
(
    id     serial,
    name varchar,
    primary key (id)
);

create table book_categorie
(
    id     serial,
    categorie_id int REFERENCES categorie(id),
    book_id int REFERENCES book(id),
    primary key (id)
);