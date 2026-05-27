package br.unitins.ms_tarefa.controller;

import br.unitins.ms_tarefa.model.Tarefa;
import br.unitins.ms_tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {
    @Autowired
    TarefaService service;

    @GetMapping
    public List<Tarefa> listar() {
        return service.listar();
    }

    @GetMapping("/disciplina/{id}")
    public List<Tarefa> porDisciplina(@PathVariable Long id) {
        return service.porDisciplina(id);
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa t) {
        return ResponseEntity.status(201).body(service.salvar(t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}