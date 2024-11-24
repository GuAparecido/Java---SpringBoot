create table disciplinas (
    id int not null primary key auto_increment,
    nome varchar(100),
    codigo varchar(20),
    curso_id int,
    professor_id int,
    FOREIGN KEY (curso_id) references cursos(id),
    FOREIGN KEY (professor_id) references professores(id)
);
