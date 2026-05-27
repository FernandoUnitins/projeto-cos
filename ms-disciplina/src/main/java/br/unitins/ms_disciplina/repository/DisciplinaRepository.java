package br.unitins.ms_disciplina.repository;

import br.unitins.ms_disciplina.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}