package br.alura.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.alura.dao.AlunoDAO;
import br.alura.dao.RoomAlunoDao;
import br.alura.database.AgendaDatabase;
import br.alura.model.Aluno;
import br.alura.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView {
    private final RoomAlunoDao dao;
    private final ListaAlunosAdapter adapter;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        adapter = new ListaAlunosAdapter(context);
        dao = Room.databaseBuilder(context, AgendaDatabase.class,"agenda.db").build()
                .getRoomAlunoDao();
    }

    public void confirmaRemocao(@NonNull final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que quer remover o aluno?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno aluno = adapter.getItem(menuInfo.position);
                    remove(aluno);
                })
                .setNegativeButton("Não",null)
                .show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.getAlunos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        listaDeAlunos.setAdapter(adapter);
    }
}
