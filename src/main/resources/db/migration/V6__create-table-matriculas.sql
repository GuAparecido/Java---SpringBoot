create table matriculas (
    id int not null primary key auto_increment,
    aluno_id int,
    turma_id int,
    FOREIGN KEY (aluno_id) references alunos(id),
    FOREIGN KEY (turma_id) references turmas(id)
);

