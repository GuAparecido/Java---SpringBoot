package com.education.TDE.controller;

import com.education.TDE.dto.NotaRequestDTO;
import com.education.TDE.dto.TurmaRequestDTO;
import com.education.TDE.model.Nota;
import com.education.TDE.model.Turma;
import com.education.TDE.repository.NotaRepository;
import com.education.TDE.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notas")
public class NotaController {
    @Autowired
    private NotaRepository repository;


    @GetMapping()
    public ResponseEntity<List<Nota>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Nota> findById(@PathVariable Integer id) {
        Nota nota = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Nota não encontrada"));
        return ResponseEntity.ok(nota);
    }

    @PostMapping
    public Nota save(@RequestBody NotaRequestDTO dto) {
        Nota nota = new Nota();
        nota.setMatricula(dto.matricula_id());
        nota.setDisciplina(dto.disciplina_id());
        nota.setNota(dto.nota());
        nota.setData_lancamento(dto.data_lancamento());


        return this.repository.save(nota);
    }

    @PutMapping("/{id}")
    public Turma update(@PathVariable Integer id, @RequestBody TurmaRequestDTO dto) {
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());

        return this.repository.save(turma);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));

        this.repository.delete(turma);
        return ResponseEntity.noContent().build();
    }
}
