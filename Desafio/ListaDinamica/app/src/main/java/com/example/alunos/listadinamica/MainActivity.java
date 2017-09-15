package com.example.alunos.listadinamica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.alunos.listadinamica.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showList(View v){
        Intent it = new Intent(this, mostraListaDinamica.class);
        it.putParcelableArrayListExtra("lista", pessoa);
        startActivity(it);

    }


    public ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();

    public void salvar (View v){
        EditText nome1 = (EditText)findViewById(R.id.insNome);
        String nome = nome1.getText().toString();

        EditText tel1 = (EditText)findViewById(R.id.insTel);
        String telefone = tel1.getText().toString();

        EditText ida1 = (EditText)findViewById(R.id.insIda);
        int idade = Integer.parseInt(ida1.getText().toString());


        pessoa.add(new Pessoa(nome, telefone, idade));



    }
}
