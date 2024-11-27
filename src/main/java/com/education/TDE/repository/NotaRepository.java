package com.education.TDE.repository;

import com.education.TDE.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
    @Query("SELECT new map(c.nome as curso, d.nome as disciplina, n.nota as nota, n.data_lancamento as dataLancamento) " +
            "FROM Nota n " +
            "JOIN n.matricula m " +
            "JOIN m.turma t " +
            "JOIN t.curso c " +
            "JOIN n.disciplina d " +
            "WHERE m.aluno.id = :alunoId")
    List<Map<String, Object>> findBoletimByAlunoId(@Param("alunoId") Integer alunoId);

    @Query("SELECT new map(a.nome as aluno, d.nome as disciplina, n.nota as nota, n.data_lancamento as dataLancamento) " +
            "FROM Nota n " +
            "JOIN n.matricula m " +
            "JOIN m.aluno a " +
            "JOIN n.disciplina d " +
            "WHERE m.turma.id = :turmaId")
    List<Map<String, Object>> findNotasByTurmaId(@Param("turmaId") Integer turmaId);

    @Query("SELECT new map(a.nome as aluno, n.nota as nota, n.data_lancamento as dataLancamento) " +
            "FROM Nota n " +
            "JOIN n.matricula m " +
            "JOIN m.aluno a " +
            "WHERE n.disciplina.id = :disciplinaId")
    List<Map<String, Object>> findNotasByDisciplinaId(@Param("disciplinaId") Integer disciplinaId);

    @Query("SELECT new map(c.nome as curso, AVG(n.nota) as media) " +
            "FROM Nota n " +
            "JOIN n.matricula m " +
            "JOIN m.turma t " +
            "JOIN t.curso c " +
            "GROUP BY c.nome")
    List<Map<String, Object>> findMediaNotasByCurso();

    @Query("SELECT new map(a.nome as aluno, AVG(n.nota) as media) " +
            "FROM Nota n " +
            "JOIN n.matricula m " +
            "JOIN m.aluno a " +
            "JOIN n.disciplina d " +
            "GROUP BY a.nome")
    List<Map<String, Object>> findMediaNotasByAluno();

}
