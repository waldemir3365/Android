package codigoqr.fiap.com.br.leitordecodigo;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import entity.TreinoBean;

public class Main3Activity extends AppCompatActivity {


    final Activity activity = this;
    private TreinoDao td;
    private Button btnVideo;
    private TextView txtTipo;
    private TextView txtSerie;
    private TextView txtRepeticao;
    private TextView txtIntervalo;
    private TextView txtObservacoes;

    private TextView txtT;
    private TextView txtS;
    private TextView txtR;
    private TextView txtI;
    private TextView txtO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        td = new TreinoDao(this);
        btnVideo = (Button)findViewById(R.id.btnVideo);
        txtTipo = (TextView)findViewById(R.id.txtTipo);
        txtSerie = (TextView)findViewById(R.id.txtSerie);
        txtRepeticao = (TextView)findViewById(R.id.txtRepeticao);
        txtIntervalo = (TextView)findViewById(R.id.txtIntervalo);
        txtObservacoes = (TextView)findViewById(R.id.txtObservacao);

        txtT = (TextView)findViewById(R.id.txtT);
        txtS = (TextView)findViewById(R.id.txtS);
        txtR = (TextView)findViewById(R.id.txtR);
        txtI = (TextView)findViewById(R.id.txtI);
        txtO = (TextView)findViewById(R.id.txtO);
        carregar();
    }

    public void video(View v){

        // codigo para scanear um Codigo QR

            IntentIntegrator integrator = new IntentIntegrator(activity);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
            integrator.setPrompt("Camera Scan");
            integrator.setCameraId(0);
            integrator.initiateScan();

    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if (result.getContents() !=  null){
                alert(result.getContents());

            }else{
                Toast.makeText(this,"Scan cancelado", Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void alert(String msg){

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            Uri uri = Uri.parse(msg.toString());
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);

    }

    public void carregar(){

        Bundle b  = new Bundle();
        b = getIntent().getExtras();

        String nome = b.get("letra").toString();

//obs toast para teste como o nome que esta vindo

        SQLiteDatabase db = td.getReadableDatabase();

        TreinoBean t = td.getTudoTreino(db,nome);

        String tipo = t.getTipo();

        Toast.makeText(this,tipo,Toast.LENGTH_SHORT).show();

        String serie = t.getQtdseries();
        String rep = t.getQtdrepeticoes();
        String in = t.getIntervalo();
        String ob = t.getObservacoes();

        txtT.setText(tipo);
        txtS.setText(serie);
        txtR.setText(rep);
        txtI.setText(in);
        txtO.setText(ob);
    }
    //fim codigo
}
