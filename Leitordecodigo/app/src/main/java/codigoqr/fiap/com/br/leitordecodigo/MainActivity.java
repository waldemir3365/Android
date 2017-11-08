package codigoqr.fiap.com.br.leitordecodigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import BancoDB.BancoDB;
import entity.ProfessorBean;

public class MainActivity extends AppCompatActivity {


    private BancoDB db;

    private Button btnLogin;
    private EditText edtUsuario;
    private EditText edtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);


        db = OpenHelperManager.getHelper(this, BancoDB.class);
    }

    public void alert(String s){

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    public void carregar(View v) {


        Intent i;


        String login  = edtUsuario.getText().toString();

        if(login.contains("rm")){


            Toast.makeText(this,"Bem vindo Aluno" + " " +  login,Toast.LENGTH_SHORT).show();

            i = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(i);
            finish();

        }else{

            Toast.makeText(this,"Bem vindo Professor" + " " + login,Toast.LENGTH_SHORT).show();

        }

    }

}
