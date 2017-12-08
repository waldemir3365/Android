package codigoqr.fiap.com.br.leitordecodigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import entity.AlunoBean;
import entity.TreinoBean;

/**
 * Created by WaldemirGomesDeAndra on 24/11/2017.
 */

public class TreinoDao extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 15;
    private static final String DATABASE_NAME = "AcademiaDB";
    private static final String TABELA_TREINO = "Treino";
    private static final String ID = "id";
    private static final String TIPO = "tipo";
    private static final String QTD_SERIES = "qtdseries";
    private static final String QTD_REPETICOES = "qtdrepeticoes";
    private static final String INTERVALO = "intervalo";
    private static final String OBSERVACOES = "observacoes";
    private static final String NOME_ALUNO = "nome";

    private static final String[] COLUNAS = {ID,TIPO,QTD_SERIES,QTD_REPETICOES,INTERVALO,OBSERVACOES,NOME_ALUNO};


    public TreinoDao(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE Treino(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tipo TEXT NOT NULL," +
                "qtdseries TEXT NOT NULL," +
                "qtdrepeticoes TEXT NOT NULL," +
                "intervalo TEXT NOT NULL," +
                "observacoes TEXT NOT NULL," +
                "nome TEXT NOT NULL)";

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Treino");
        this.onCreate(db);
    }

    public void addTreino(TreinoBean t) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TIPO, t.getTipo());
        values.put(QTD_SERIES, t.getQtdseries());
        values.put(QTD_REPETICOES, t.getQtdrepeticoes());
        values.put(INTERVALO, t.getIntervalo());
        values.put(OBSERVACOES, t.getObservacoes());
        values.put(NOME_ALUNO, t.getNome());

        db.insert(TABELA_TREINO, null, values);
        db.close();
    }

    public TreinoBean getTudoTreino(SQLiteDatabase db, String nome) {

        Cursor c = db.query(TABELA_TREINO, null, "nome = ?", new String[]{nome}, null, null, null);
        if (c.moveToNext()) {

            TreinoBean ret = new TreinoBean();
            ret.setId(c.getInt(0));
            ret.setTipo(c.getString(1));
            ret.setQtdseries(c.getString(2));
            ret.setQtdrepeticoes(c.getString(3));
            ret.setIntervalo(c.getString(4));
            ret.setObservacoes(c.getString(5));
            return ret;

        } else return null;
    }
}
