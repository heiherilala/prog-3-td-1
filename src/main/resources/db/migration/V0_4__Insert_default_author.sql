insert into author (name)
select distinct author from book where author != '';

update author set particularity = 'test' where id = 2;

alter table book rename author to author_name;
alter table book ADD author int ;



update book set (author) =
(select distinct id from author
where author.name = book.author_name);

update book set author = 1 where id < 3;

alter table book drop column author_name;

alter table book add FOREIGN KEY (author) REFERENCES author(id);

