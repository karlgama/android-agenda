package br.alura.ui.activity;

import static br.alura.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.alura.R;
import br.alura.dao.AlunoDAO;
import br.alura.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";


    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoALuno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoALuno.setOnClickListener(view -> abreFormularioModoInsereAluno());
    }

    public void abreFormularioModoInsereAluno() {
        startActivity(new Intent(
                this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        final List<Aluno> alunos = dao.getAlunos();
        listaDeAlunos.setAdapter(configuraAdapter(alunos));
        configuraListenerDeCliquePorItem(listaDeAlunos);
    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((adapterView, view, indice, id) -> {
            Aluno aluno = (Aluno) adapterView.getItemAtPosition(indice);
            Intent vaiParaFormulario = abreFormularioModoEditaAluno();
            vaiParaFormulario.putExtra(CHAVE_ALUNO, aluno);
            startActivity(vaiParaFormulario);
        });
    }

    @NonNull
    private Intent abreFormularioModoEditaAluno() {
        return new Intent(this,
                FormularioAlunoActivity.class);
    }

    @NonNull
    private ArrayAdapter<Aluno> configuraAdapter(List<Aluno> alunos) {
        return new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos);
    }
}
