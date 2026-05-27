package br.unitins.ms_tarefa.service;

import br.unitins.ms_tarefa.model.Tarefa;
import br.unitins.ms_tarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class TarefaService {
    @Autowired
    TarefaRepository repo;

    private final RestTemplate restTemplate = new RestTemplate();

    // Injeção de URL pronta para a Aula 11 (Docker Compose)
    @Value("${URL_DISC:http://localhost:8081/disciplinas/}")
    private String urlDisciplina;

    public List<Tarefa> listar() {
        return repo.findAll();
    }

    public Tarefa salvar(Tarefa t) {
        try {
            restTemplate.getForObject(urlDisciplina + t.getDisciplinaId(), Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Disciplina " + t.getDisciplinaId() + " não encontrada!");
        }
        return repo.save(t);
    }

    public void excluir(Long id) {
        repo.deleteById(id);
    }

    public List<Tarefa> porDisciplina(Long id) {
        return repo.findByDisciplinaId(id);
    }
}