package com.education.TDE.controller;

import com.education.TDE.dto.DisciplinaRequestDTO;
import com.education.TDE.model.Disciplina;
import com.education.TDE.model.Nota;
import com.education.TDE.repository.DisciplinaRepository;
import com.education.TDE.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository repository;

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping()
    public ResponseEntity<List<Disciplina>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
        Disciplina disciplina = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping
    public Disciplina save(@RequestBody DisciplinaRequestDTO dto) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.nome());
        disciplina.setCodigo(dto.codigo());


        return this.repository.save(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina update(@PathVariable Integer id, @RequestBody DisciplinaRequestDTO dto) {
            Disciplina disciplina = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

            disciplina.setNome(dto.nome());
            disciplina.setCodigo(dto.codigo());

        return this.repository.save(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        Disciplina disciplina = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada"));

        this.repository.delete(disciplina);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/add-nota")
    public ResponseEntity<Disciplina> addNota(@PathVariable Integer id,
                                               @RequestBody Nota nota) {
        Disciplina disciplina = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrado"));

        nota.setDisciplina(disciplina);
        this.notaRepository.save(nota);

        return ResponseEntity.ok(disciplina);
    }

}
