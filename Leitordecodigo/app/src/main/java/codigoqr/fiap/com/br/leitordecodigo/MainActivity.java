package codigoqr.fiap.com.br.leitordecodigo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import BancoDB.BancoDB;
import entity.AlunoBean;
import entity.ProfessorBean;

public class MainActivity extends AppCompatActivity {


    private AlunoDao ad;

    private Button btnLogin;
    private EditText edtUsuario;
    private EditText edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ad = new AlunoDao(this);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        //inserirTabelas();
    }

    public void carregar(View v) {

        String edtL = edtUsuario.getText().toString();
        String edtS = edtSenha.getText().toString();

        Intent i;

        SQLiteDatabase db = ad.getReadableDatabase();

        AlunoBean a = ad.getTudo(db, edtUsuario.getText().toString(), edtSenha.getText().toString());

        String nome = a.getNome();
        String login = a.getLogin();
        String senha = a.getSenha();
        String objetivo = a.getObjetivo();
        String pagamento = a.getPagamento();

        //String a = ad.getAluno(db, edtUsuario.getText().toString(), edtSenha.getText().toString());

        Toast.makeText(this, "Aluno BANCO: " + nome, Toast.LENGTH_SHORT).show();

        if(edtL.equals(login) && edtS.equals(senha)) {

                if (login.contains("rm")) {

                    i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("nome",nome);
                    i.putExtra("login",login);
                    i.putExtra("objetivo",objetivo);
                    i.putExtra("pagamento",pagamento);

                    startActivity(i);
                    Toast.makeText(this, "Aluno Bem vindo : " + " " + login, Toast.LENGTH_SHORT).show();

                } else {

                    i = new Intent(MainActivity.this, Main7Activity.class);
                    i.putExtra("nome",nome);
                    i.putExtra("login",login);
                    i.putExtra("objetivo",objetivo);
                    i.putExtra("pagamento",pagamento);

                    startActivity(i);

                    Toast.makeText(this, "Professor Bem vindo: " + " " + login, Toast.LENGTH_SHORT).show();
                }

            } else {

                mensagem();

            }

            //fim caregar
        }

    public void mensagem(){

        AlertDialog.Builder b = new AlertDialog.Builder(this);

        b.setTitle("Erro ao Acessar");
        b.setIcon(android.R.drawable.ic_dialog_alert);
        b.setMessage("Dados em branco /ou Incompativeis com o campo ! ");

        AlertDialog a = b.create();

        a.show();

    }

    public void inserirTabelas(){

        AlunoBean a = new AlunoBean();

        a.setNome("waldemir");
        a.setLogin("rmwalgan");
        a.setSenha("waldemir3365");
        a.setObjetivo("Perda de Peso");
        a.setPagamento("Aprovado");

        ad.addAluno(a);

        AlunoBean p = new AlunoBean();
        p.setNome("juninho");
        p.setLogin("rm");
        p.setSenha("1234");
        p.setObjetivo("Ganho de Massa");
        p.setPagamento("Reprovado");

        ad.addAluno(p);

        AlunoBean d = new AlunoBean();

        d.setNome("rodrigo");
        d.setLogin("pfrodrigo");
        d.setSenha("batata");
        d.setObjetivo("Treino de Resistencia");
        d.setPagamento("Aprovado");

        ad.addAluno(d);

        AlunoBean l = new AlunoBean();

        l.setNome("leonardo");
        l.setLogin("rmleo");
        l.setSenha("1234");
        l.setObjetivo("Perda de Peso");
        l.setPagamento("Aprovado");

        ad.addAluno(l);

        AlunoBean g = new AlunoBean();

        g.setNome("gabriel");
        g.setLogin("rmg");
        g.setSenha("1234");
        g.setObjetivo("Perda de Peso");
        g.setPagamento("Reprovado");

        ad.addAluno(g);

        Toast.makeText(this,"Alunos Inserido !",Toast.LENGTH_LONG).show();
    }
}
