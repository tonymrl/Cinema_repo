/* DDL */

create table persona(
id integer primary key, 
username varchar2(20) not null unique,
password varchar2(16) not null,
nome varchar2(15) not null,
cognome varchar2(20) not null,
anno_nascita date not null,
email varchar2(30) not null,
ruolo varchar2(10) not null,

constraint check_ruolo check(ruolo in('admin', 'utente'))
);

create table sala(
id integer primary key,
nome_sala varchar2(10) not null,
numero_posti integer not null
);

create table film(
id integer primary key,
titolo varchar2(20) not null,
genere varchar2(10) not null,
trama varchar2(100) not null, -- non sappiamo se mettere un clob LOLs
durata varchar2(5) not null,
regista varchar2(20) not null,

constraint enum_genere check(genere in('commedia', 'thriller', 'horror', 'romantico', 'drammatico', 'azione'))
);

create table proiezione(
id integer primary key,
data_proiezione date not null, -- data e ora sono contenute entrambe nel tipo date
posti_disponibili integer not null,
id_sala integer not null, 
id_film integer not null,

constraint fk_proiezione_sala foreign key (id_sala) references sala(id),
constraint fk_proiezione_film foreign key (id_film) references film(id),
constraint uc_data_sala unique (data_proiezione, id_sala)
);

create table biglietto(
id integer primary key,
fila varchar2(1) not null,
numero integer not null,
id_proiezione integer not null,
id_persona integer not null,

constraint fk_proiezione foreign key (id_proiezione) references proiezione(id),
constraint fk_biglietto_persona foreign key (id_persona) references persona(id),
constraint uc_ticket unique (fila, numero, id_proiezione)

);


create table posto(
id integer primary key,
numero integer not null,
fila varchar2(1) not null,
id_sala integer not null,

constraint fk_posto_sala foreign key (id_sala) references sala(id)
);

/*

select numero, fila from biglietto b, proiezione pr, sala s, posto po
where b.id_proiezione = pr.id and pr.id_sala = s.id and po.id_sala = s.id;

*/



/* DML */

-- inserimento in persona
insert into persona values (1, 'admin', 'admin', 'Mario', 'Rossi', '18-GEN-1985', 'mario.rossi@cinema.it', 'admin');
insert into persona values (2, 'dariobardo', '123', 'Dario', 'Minopoli', '28-GEN-1995', 'dariominopoli@yahoo.it', 'utente');
insert into persona values (3, 'tonymrl', '123', 'Antonio', 'Mauriello', '15-Mar-1997', 'antoniomaur@gmail.com', 'utente');
-- prova di inserimento di un account che non é utente
-- insert into persona values (4, 'tonymrl2', '123', 'Antonio', 'Mauriello', '15-Mar-1997', 'antoniomaur@gmail.com', 'nonsononessuno');

-- inserimento in sala
insert all 
    into sala values (1, 'Sala 1', 6)
    into sala values (2, 'Sala 2', 4)
    into sala values (3, 'Sala 3', 4)
select * from dual;

-- inserimento dei posti nella sala

insert all
    into posto values (1, 1, 'a', 1)
    into posto values (2, 2, 'a', 1)
    into posto values (3, 3, 'a', 1)
    into posto values (4, 1, 'b', 1)
    into posto values (5, 2, 'b', 1)
    into posto values (6, 3, 'b', 1)
    into posto values (7, 1, 'a', 2)
    into posto values (8, 2, 'a',2)
    into posto values (9, 1, 'b',2)
    into posto values (10, 2, 'b',2)
    into posto values (11, 1, 'a',3)
    into posto values (12, 2, 'a',3)
    into posto values (13, 1, 'b',3)
    into posto values (14, 2, 'b',3)
select * from dual;

-- inserimento di qualche film

insert into film values (1, 'Titanic', 'romantico', 'jack sto volando!', 180, 'Cameron');
insert into film values (2, 'Missione Impossibile', 'azione', 'sono bello', 120, 'Crudelia Daemon');
insert into film values (3, 'Io sono Leggenda', 'thriller', 'ho il cane per non prendere la multa', 160, 'De Luca');
-- inserisco un film che non ha un genere esistente
insert into film values (4, 'Titanic2', 'asdf', 'jack sto volando!', 180, 'Cameron');

-- inserimento di una proiezione
insert into proiezione values (101, '18-mar-2020', 6, 1, 1); -- da aggiornare con update ogni qualvolta venga acquistato un biglietto

-- inserimento di un biglietto
insert into biglietto values (1, 'b', 2, 101, 2);
-- insert into biglietto values (2, 'b', 2, 101, 2);
-- insert into biglietto values (3, 'b', 2, 101, 3);







/*
drop table biglietto ;
drop table persona;
drop table posto;
drop table proiezione;
drop table sala;
drop table film;
*/


