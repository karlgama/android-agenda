package br.alura;

import android.app.Application;

import androidx.room.Room;

import br.alura.dao.AlunoDAO;
import br.alura.dao.RoomAlunoDao;
import br.alura.database.AgendaDatabase;
import br.alura.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunoDeTeste();
    }

    private void criaAlunoDeTeste() {
        AgendaDatabase database = Room.databaseBuilder(this, AgendaDatabase.class, "agenda.db")
                .build();
        RoomAlunoDao dao = database.getRoomAlunoDao();
        for (int i = 0; i < 2; i++) {
            dao.salva(new Aluno("Teste" + i, "124313431", "teste@teste.com"));
        }
    }
}
