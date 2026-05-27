package br.unitins.ms_tarefa.repository;

import br.unitins.ms_tarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByDisciplinaId(Long disciplinaId);
}