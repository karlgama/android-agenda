package br.alura.dao;

import java.util.ArrayList;
import java.util.List;

import br.alura.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public  List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }
}
