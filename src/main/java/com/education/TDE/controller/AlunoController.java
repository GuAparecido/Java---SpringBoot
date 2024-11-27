package com.education.TDE.controller;

import com.education.TDE.dto.AlunoRequestDTO;
import com.education.TDE.model.Aluno;
import com.education.TDE.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;


    @GetMapping()
    public ResponseEntity<List<Aluno>> findAll() {
    //  return this.repository.findAll(); Tratando o erro
        return ResponseEntity.ok(this.repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
    //    return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Aluno aluno = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public Aluno save(@RequestBody AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setMatricula(dto.matricula());
        aluno.setData_nascimento(dto.data_nascimento());

        return this.repository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Integer id, @RequestBody AlunoRequestDTO dto) {
        Aluno aluno = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());
        aluno.setMatricula(dto.matricula());
        aluno.setData_nascimento(dto.data_nascimento());

        return this.repository.save(aluno);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        Aluno aluno = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        this.repository.delete(aluno);
        return ResponseEntity.noContent().build();
    }



}
