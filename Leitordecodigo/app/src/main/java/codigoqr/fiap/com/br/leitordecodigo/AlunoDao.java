package codigoqr.fiap.com.br.leitordecodigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import entity.AlunoBean;

/**
 * Created by WaldemirGomesDeAndra on 24/11/2017.
 */

public class AlunoDao extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 15;
    private static final String DATABASE_NAME = "AcademiaDB";
    private static final String TABELA_ALUNOS = "Aluno";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final String OBJETIVO = "objetivo";
    private static final String PAGAMENTO = "pagamento";

    private static final String[] COLUNAS = {ID, NOME, LOGIN, SENHA, OBJETIVO, PAGAMENTO};


    public AlunoDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE Aluno(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "login TEXT NOT NULL," +
                "senha TEXT NOT NULL," +
                "objetivo TEXT NOT NULL," +
                "pagamento TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Aluno");
        this.onCreate(db);

    }

    public void addAluno(AlunoBean a) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NOME, a.getNome());
        values.put(LOGIN, a.getLogin());
        values.put(SENHA, a.getSenha());
        values.put(OBJETIVO, a.getObjetivo());
        values.put(PAGAMENTO, a.getPagamento());

        db.insert(TABELA_ALUNOS, null, values);
        db.close();

    }



    public String getAluno(SQLiteDatabase db, String login, String senha) {

        Cursor c = db.query(TABELA_ALUNOS, null, "login = ? and senha = ?", new String[]{login, senha}, null, null, null);
        if (c.moveToFirst()) {

            AlunoBean ret = new AlunoBean();
            ret.setId(c.getInt(0));
            ret.setNome(c.getString(1));
            ret.setLogin(c.getString(2));
            return ret.getLogin();

        } else return null;

    }


    public AlunoBean getTudo(SQLiteDatabase db, String login, String senha) {

        Cursor c = db.query(TABELA_ALUNOS, null, "login = ? and senha = ?", new String[]{login,senha}, null, null, null);
        if (c.moveToNext()) {

            AlunoBean ret = new AlunoBean();
            ret.setId(c.getInt(0));
            ret.setNome(c.getString(1));
            ret.setLogin(c.getString(2));
            ret.setSenha(c.getString(3));
            ret.setObjetivo(c.getString(4));
            ret.setPagamento(c.getString(5));
            return ret;

        } else return null;

    }

    public ArrayList<String> getAll(SQLiteDatabase db) {

        ArrayList<String> ret = new ArrayList<String>();
        Cursor c = db.query(TABELA_ALUNOS, null, null, null, null, null, null); // SELECT * FROM ALUNO

        while (c.moveToNext()) {

            AlunoBean a = new AlunoBean();
            a.setId(c.getInt(0));
            a.setNome(c.getString(1));

            ret.add(a.getNome());

        }

        return ret;


    }


}
