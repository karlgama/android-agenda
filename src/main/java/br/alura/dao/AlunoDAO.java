package br.alura.dao;

import java.util.ArrayList;
import java.util.List;

import br.alura.model.Aluno;

public class AlunoDAO {
    private static int contadorDeIds = 1;
    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        contadorDeIds++;
    }

    public void edita(Aluno aluno) {
        Aluno encontrado = null;

        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId())
                encontrado = a;
        }
        if (encontrado != null) {
            int posicao = alunos.indexOf(encontrado);
            alunos.set(posicao, aluno);
        }
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }
}
