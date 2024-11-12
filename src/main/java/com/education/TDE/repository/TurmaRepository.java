package com.education.TDE.repository;

import com.education.TDE.model.Curso;
import com.education.TDE.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
