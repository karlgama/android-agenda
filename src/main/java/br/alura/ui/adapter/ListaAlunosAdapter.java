package br.alura.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.alura.R;
import br.alura.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int i) {
        return alunos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return alunos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewCriada= LayoutInflater
                .from(context)
                .inflate(R.layout.item_aluno, viewGroup,false);

        TextView nomeAluno = viewCriada.findViewById(R.id.item_aluno_nome);
        nomeAluno.setText(alunos.get(i).getNome());
        TextView telefoneAluno = viewCriada.findViewById(R.id.item_aluno_telefone);
        telefoneAluno.setText(alunos.get(i).getTelefone());
        return viewCriada;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> alunos) {
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        this.alunos.remove(aluno);
    }
}
