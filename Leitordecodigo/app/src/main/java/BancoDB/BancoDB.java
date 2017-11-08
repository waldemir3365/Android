package BancoDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by WaldemirGomesDeAndra on 23/10/2017.
 */

public class BancoDB extends OrmLiteSqliteOpenHelper {



    public BancoDB(Context context) {
        super(context, "BancoDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        database.execSQL("CREATE TABLE TB_PROFESSOR(ID INTEGER " + "PRIMARY KEY AUTOINCREMENT," +
                         "NOME_PROF VARCHAR2(50)," +
                         "CPF_PROF VARCHAR2(50)," +
                         "LOGIN_PROF VARCHAR(50)," +
                         "SENHA_PROF VARCHAR(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {




    }
}
