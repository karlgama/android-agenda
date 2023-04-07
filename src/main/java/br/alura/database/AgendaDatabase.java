package br.alura.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.alura.dao.RoomAlunoDao;
import br.alura.model.Aluno;

@Database(entities={Aluno.class},version = 1,exportSchema = false)
public abstract class AgendaDatabase extends RoomDatabase {
    public abstract RoomAlunoDao getRoomAlunoDao();
}
