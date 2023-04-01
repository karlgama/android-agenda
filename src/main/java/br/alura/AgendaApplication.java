package br.alura;

import android.app.Application;

import br.alura.dao.AlunoDAO;
import br.alura.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunoDeTeste();
    }

    private void criaAlunoDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        for (int i = 0; i < 2; i++) {
            dao.salva(new Aluno("Teste" + i, "124313431", "teste@teste.com"));
        }
    }
}
