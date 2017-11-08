package codigoqr.fiap.com.br.leitordecodigo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final Activity activity = this;
     private ImageView imgTreino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imgTreino = (ImageView) findViewById(R.id.imgTreino);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        Intent i = null;

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            // Handle the camera a
            caixa();
        } else if (id == R.id.nav_gallery) {

            i = new Intent(Main2Activity.this,Main3Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

            i = new Intent(Main2Activity.this,Main5Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_manage) {

            i = new Intent(Main2Activity.this,Main6Activity.class);
            startActivity(i);


        } else if (id == R.id.nav_Logout) {

            i = new Intent(Main2Activity.this,MainActivity.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_codigoQr) {

            i = new Intent(Main2Activity.this,Main7Activity.class);
            startActivity(i);

            //cameraQR();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    // codigo para scanear um Codigo QR


    /*

        public void cameraQR(){

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
                alert("Scan cancelado");
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void alert(String msg){

        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        Uri uri  = Uri.parse(msg.toString());
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }

    */





    public void abrirTreino(View v){

        Intent i  = new Intent(Main2Activity.this, Main3Activity.class);
        startActivity(i);

    }

    public void abrirDieta(View v){

        Intent i  = new Intent(Main2Activity.this, Main5Activity.class);
        startActivity(i);

    }


    public void abrirUnidades(View v){

        Intent i  = new Intent(Main2Activity.this, Main6Activity.class);
        startActivity(i);

    }

    public void abrirMinhasInformacao(View v){


        caixa();


    }


    public void caixa(){

        AlertDialog.Builder b  = new AlertDialog.Builder(this);

        b.setTitle("Minhas Informações");
        b.setIcon(android.R.drawable.btn_star_big_on);
        b.setMessage("Plano Mensal : R$ 60,00 reais");



        AlertDialog a  = b.create();
        a.show();

    }

}
