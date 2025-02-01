package api_teste.api.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api_teste.api.models.Alunos;
import api_teste.api.repository.AlunoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class MinhaApi {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/fullalunos")
    public ResponseEntity fullProduct() {
        var fullalunos = alunoRepository.findAll();

        return ResponseEntity.ok(fullalunos);
    }

    @PostMapping("/aluno")
    public ResponseEntity novoaluno(@Validated @RequestBody Alunos alunos ) {

        //TODO: process POST request

        alunoRepository.save(alunos);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity getAluno(@PathVariable Long id) {

        var aluno = alunoRepository.findById(id);


        return ResponseEntity.ok(aluno);
    }

    @PutMapping("aluno/{id}")
    public ResponseEntity putAluno(@PathVariable Long id, @Validated @RequestBody Alunos alunos) {

        var aluno = alunoRepository.findById(id).get();

        BeanUtils.copyProperties(alunos, aluno, "id");

        alunoRepository.save(aluno);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("aluno/{id}")
    public ResponseEntity deleteAluno(@PathVariable  Long id) {

        alunoRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
