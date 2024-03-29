package br.alura.ui.activity;

import static br.alura.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.alura.R;
import br.alura.model.Aluno;
import br.alura.ui.ListaAlunosView;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private ListaAlunosView listaAlunosView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle(TITULO_APPBAR);
        listaAlunosView= new ListaAlunosView(this);
        configuraLista();
        configuraFabNovoAluno();
    }

    private void configuraFabNovoAluno() {
        FloatingActionButton botaoNovoALuno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoALuno.setOnClickListener(view -> abreFormularioModoInsereAluno());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.activity_lista_alunos_menu_remover)
            listaAlunosView.confirmaRemocao(item);

        return super.onContextItemSelected(item);
    }



    public void abreFormularioModoInsereAluno() {
        startActivity(new Intent(
                this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }


    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
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
}
