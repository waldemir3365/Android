package codigoqr.fiap.com.br.leitordecodigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import entity.ProfessorBean;

/**
 * Created by WaldemirGomesDeAndra on 24/11/2017.
 */

public class ProfessorDao extends SQLiteOpenHelper {



    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AcademiaDB";
    private static final String TABELA_PROFESSOR = "Professor";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final String EMAIL = "email";

    private static final String[] COLUNAS = {ID,NOME,LOGIN,SENHA,EMAIL};

    public ProfessorDao(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE Professor("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome TEXT,"+
                "login TEXT,"+
                "senha TEXT," +
                "email TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Professor");
        this.onCreate(db);
    }


    public void addProfessor(ProfessorBean p){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NOME,p.getNome());
        values.put(LOGIN,p.getLogin());
        values.put(SENHA,p.getSenha());
        values.put(EMAIL,p.getEmail());

        db.insert(TABELA_PROFESSOR,null,values);
        db.close();

    }

    public ProfessorBean getProfessor(SQLiteDatabase db, String login, String senha) {

        Cursor c = db.query(TABELA_PROFESSOR, null, "login = ? and senha = ?", new String[]{login, senha}, null, null, null);
        if (c.moveToFirst()) {

            ProfessorBean ret = new ProfessorBean();
            ret.setId(c.getInt(0));
            ret.setNome(c.getString(1));
            return ret;

        } else return null;



    }






}
