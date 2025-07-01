package br.com.cadastroalunos.controller;

import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.criar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        List<Aluno> alunos = alunoService.listarTodos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> listarPorId(@PathVariable Long id) {
        return alunoService.listarPorId(id)
                .map(aluno -> ResponseEntity.ok(aluno))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
         Aluno aluno = alunoService.listarPorId(id).orElse(null);
         if (aluno != null) {
             alunoService.deletar(id);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
         }
         return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        return alunoService.atualizar(id, alunoAtualizado)
                .map(aluno -> ResponseEntity.ok(aluno))
                .orElse(ResponseEntity.notFound().build());
    }



}
