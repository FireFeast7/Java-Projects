create table "authors" (
    "id" bigint primary key,
    "name" text,
    "age" integer
);

create table "books"(
    "isbn" text not null ,
    "title" text,
    "author_id" bigint,
    foreign key (author_id) references authors(id)
);