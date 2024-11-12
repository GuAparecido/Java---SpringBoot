create table professores (
    id int not null primary key auto_increment,
    nome varchar(100),
    email varchar(100) unique,
    telefone varchar(15),
    especialidade varchar(10)
);