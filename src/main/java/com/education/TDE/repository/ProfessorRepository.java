package com.education.TDE.repository;

import com.education.TDE.model.Curso;
import com.education.TDE.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
