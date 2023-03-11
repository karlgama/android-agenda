package br.alura;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> alunos = List.of("Alex", "Fran", "Jose");
        ListView listaAlunos = findViewById(R.id.activity_main_lista_alunos);
        listaAlunos.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alunos)
        );
    }
}