---postgres

create table type(
    idType SERIAL PRIMARY KEY,
    nom varchar(100)
);
insert into type(nom)
values
    ('Liquide'),
    ('Solide');

create table categorie(
    idCategorie SERIAL PRIMARY KEY,
    nom varchar(100)
);
insert into categorie(nom)
values
    ('Luxe'),
    ('Moyenne'),
    ('Standard');

create table produit(
    idProduit SERIAL PRIMARY KEY,
    nom varchar(100),
    idType int references type(idType),
    idCategorie int references categorie(idCategorie),
    prix float
);
insert into produit (nom, idType, idCategorie, prix)
values
    ('Huile', 1, 3, 5000),
    ('Savon', 2, 3, 500),
    ('Montre', 2, 1, 150000);

create view v_produit as
select p.idProduit, p.nom, t.nom as type, c.nom as categorie from produit p
    join type t on t.idType = p.idType
    join categorie c on c.idCategorie = p.idCategorie;