package com.education.TDE.controller;

import com.education.TDE.dto.MatriculaRequestDTO;
import com.education.TDE.dto.NotaRequestDTO;
import com.education.TDE.model.Matricula;
import com.education.TDE.model.Nota;
import com.education.TDE.repository.MatriculaRepository;
import com.education.TDE.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping()
    public ResponseEntity<List<Matricula>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> findById(@PathVariable Integer id) {
        Matricula matricula = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada"));
        return ResponseEntity.ok(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matrícula não encontrada"));

        this.repository.delete(matricula);
        return ResponseEntity.noContent().build();

    }
}
