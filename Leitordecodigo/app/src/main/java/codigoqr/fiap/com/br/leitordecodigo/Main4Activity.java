package codigoqr.fiap.com.br.leitordecodigo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import entity.AlunoBean;
import entity.ProfessorBean;
import entity.TreinoBean;

public class Main4Activity extends AppCompatActivity {

    private TreinoDao bd;
    private AlunoDao ad;

    private EditText edtNomeExercicio;
    private EditText edtSerie;
    private EditText edtRepeticao;
    private EditText edtIntervalo;
    private EditText edtObservacao;
    private Button btnCadastrar;

    private Spinner spNomeAluno;

    //teste

    private ArrayList<String> nomes = new ArrayList<String>();
    private String nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ad = new AlunoDao(this);
        bd = new TreinoDao(this);


        spNomeAluno = (Spinner) findViewById(R.id.spNomeAluno);
        edtNomeExercicio = (EditText) findViewById(R.id.edtNomeExercicio);
        edtSerie = (EditText) findViewById(R.id.edtSerie);
        edtRepeticao = (EditText) findViewById(R.id.edtRepeticao);
        edtIntervalo = (EditText) findViewById(R.id.edtIntervalo);
        edtObservacao = (EditText) findViewById(R.id.edtObservacao);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        recupera();

        SQLiteDatabase db = ad.getReadableDatabase();
        //teste
        ArrayList<String> nomes = ad.getAll(db);

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nomes);

        spNomeAluno.setAdapter(adp);

    }


    //teste


    public  String recupera(){

        spNomeAluno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                nome = parent.getItemAtPosition(position).toString();

                Toast.makeText(getBaseContext(), nome, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return nome;

    }


    public void cadastrar(View v) {


        Toast.makeText(this,"Passou",Toast.LENGTH_LONG).show();

        String n = recupera();

        String tipo = edtNomeExercicio.getText().toString();
        String  serie = edtSerie.getText().toString();
        String  repeticao = edtRepeticao.getText().toString();
        String intervalo = edtIntervalo.getText().toString();
        String observacao = edtObservacao.getText().toString();

        TreinoBean t = new TreinoBean();

        t.setTipo(tipo);
        t.setQtdseries(serie);
        t.setQtdrepeticoes(repeticao);
        t.setIntervalo(intervalo);
        t.setObservacoes(observacao);
        t.setNome(n);

        bd.addTreino(t);

        Toast.makeText(this,"Treino inserido",Toast.LENGTH_LONG).show();

        edtNomeExercicio.setText("");
        edtSerie.setText("");
        edtRepeticao.setText("");
        edtIntervalo.setText("");
        edtObservacao.setText("");

        Toast.makeText(this,nome,Toast.LENGTH_LONG).show();

    }

}
