create table turmas (
    id int not null primary key auto_increment,
    ano int,
    semestre int,
    curso_id int,
    FOREIGN KEY (curso_id) references cursos(id)
);