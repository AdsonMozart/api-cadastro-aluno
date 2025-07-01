package br.com.cadastroalunos.service;

import br.com.cadastroalunos.model.Aluno;
import br.com.cadastroalunos.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno criar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> listarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    public Optional<Aluno> atualizar(Long id, Aluno atualizarAluno) {
        Optional<Aluno> optAluno = alunoRepository.findById(id);
        if (optAluno.isPresent()) {
            Aluno aluno = optAluno.get();
            aluno.setNome(atualizarAluno.getNome());
            aluno.setIdade(atualizarAluno.getIdade());
            aluno.setNomeResponsavel(atualizarAluno.getNomeResponsavel());
            aluno.setTurma(atualizarAluno.getTurma());

            alunoRepository.save(aluno);
            return Optional.of(aluno);
        }
        return Optional.empty();
    }
}
