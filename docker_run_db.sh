create database apidb
create user 'usuariocli'@'%' identified by 'senhacli';
grant all on *.* to 'usuariocli'@'%';

create table if not exists trabalhador ( \
        login varchar(4) not null primary key, \
        cargo  varchar(15) not null, \
        empresa  varchar(10) not null, \
        nomecompleto varchar(20) not null, \
        matricula varchar(10) not null, \
        email varchar(15), \
	    funcao varchar(10) not null, \
	    lotacao varchar(50) not null);

insert into trabalhador values ('LHNV', 'arquiteto sw', 'Transpetro', \
    'Luis Villaca', '4213', 'luis@email.com', 'senior arq', 'TIC/ARQ');

insert into trabalhador values ('PHV', 'piano player', 'NYU', \
    'Paulo Villaca', '5433', 'ph@email.com', 'jr player', 'SERV/KEY');