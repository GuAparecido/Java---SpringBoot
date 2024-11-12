create table alunos (
    id int not null primary key auto_increment,
    nome varchar(100),
    email varchar(100) unique,
    matricula varchar(20) unique,
    data_nascimento date
);