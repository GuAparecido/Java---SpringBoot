package com.education.TDE.controller;

import com.education.TDE.dto.CursoRequestDTO;
import com.education.TDE.dto.NotaRequestDTO;
import com.education.TDE.model.Curso;
import com.education.TDE.model.Nota;
import com.education.TDE.repository.CursoRepository;
import com.education.TDE.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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
        nota.setNota(dto.nota());
        nota.setData_lancamento(dto.data_lancamento());

        return this.repository.save(nota);
    }

    @PutMapping("/{id}")
    public Nota update(@PathVariable Integer id, @RequestBody NotaRequestDTO dto) {
        Nota nota = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrado"));
        nota.setNota(dto.nota());
        nota.setData_lancamento(dto.data_lancamento());

        return this.repository.save(nota);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Nota nota = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota não encontrado"));
        this.repository.delete(nota);
        return ResponseEntity.noContent().build();
    }

}