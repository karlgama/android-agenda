package br.alura.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.alura.model.Aluno;

@Dao
public interface RoomAlunoDao {
    @Insert
    void salva(Aluno aluno);

    @Query("SELECT * FROM aluno")
    List<Aluno> getAlunos();
    @Delete
    void remove(Aluno aluno);
}
