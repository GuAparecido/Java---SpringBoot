create table notas (
    id int not null primary key auto_increment,
    matricula_id int,
    disciplina_id int,
    nota decimal(5,2),
    data_lancamento date,
    FOREIGN KEY (matricula_id) references matriculas(id),
    FOREIGN KEY (disciplina_id) references disciplinas(id)
);