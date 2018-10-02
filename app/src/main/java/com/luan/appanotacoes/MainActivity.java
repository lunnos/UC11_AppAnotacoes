package com.luan.appanotacoes;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.luan.appanotacoes.dao.AnotacaoDAO;
import com.luan.appanotacoes.model.Anotacao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etTitulo, etAnotacao;
    private ListView lvLista;
    private Button btnSalvar;

    private List<String> listaDeAnotacoes;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etAnotacao = (EditText) findViewById(R.id.etAnotacao);
        etTitulo = (EditText) findViewById(R.id.etTitulo);
        lvLista = (ListView) findViewById(R.id.lvLista);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAnotacao();
            }
        });

        listaDeAnotacoes = new ArrayList<>();
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listaDeAnotacoes);
        lvLista.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void salvarAnotacao(){
        String anotacao = etAnotacao.getText().toString();
        String titulo = etTitulo.getText().toString();

        if ( titulo.isEmpty() ) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);
            alerta.setTitle(getResources().getString(R.string.txtAtencao));
            alerta.setIcon(android.R.drawable.ic_dialog_alert);
            alerta.setMessage(R.string.txtCamposObrigatorios);
            alerta.setNeutralButton("OK", null);
            alerta.show();

        }else {
            Anotacao prod = new Anotacao();
            prod.setTitulo(titulo);
            prod.setAnotacao(anotacao);
            AnotacaoDAO.inserir(this, prod);
            finish();

        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
