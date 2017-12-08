package codigoqr.fiap.com.br.leitordecodigo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
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
import android.widget.TextView;
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


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        Intent i = null;

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            // minhas informações
            // Handle the camera a
            mensagem2();

        } else if (id == R.id.nav_gallery) {

            i = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(i);
            //aqui tambem

        } else if (id == R.id.nav_slideshow) {

            i = new Intent(Main2Activity.this, Main5Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_manage) {

            i = new Intent(Main2Activity.this, Main6Activity.class);
            startActivity(i);


        } else if (id == R.id.nav_Logout) {

            i = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_codigoQr) {

            caixa();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void abrirTreino(View v) {

        Bundle b  = new Bundle();
        b = getIntent().getExtras();
        String o = b.get("nome").toString();

        Intent i = new Intent(getBaseContext(), Main3Activity.class);
        i.putExtra("letra",o);
        startActivity(i);
        Toast.makeText(this,"passado letra", Toast.LENGTH_SHORT).show();

    }

    public void abrirDieta(View v) {

        Intent i = new Intent(Main2Activity.this, Main5Activity.class);
        startActivity(i);

    }

    public void abrirUnidades(View v) {

        Intent i = new Intent(Main2Activity.this, Main6Activity.class);
        startActivity(i);

    }

    public void abrirMinhasInformacao(View v) {

            mensagem();

    }


    public void mensagem2(){

        AlertDialog.Builder c = new AlertDialog.Builder(this);
        c.setTitle("Minha Conta");
        c.setIcon(android.R.drawable.ic_dialog_info);
        c.setMessage("Seu Plano atualmente é de : R$ 120,00 reais ");

        AlertDialog a = c.create();
        a.show();

    }


    public void mensagem(){


        Bundle b  = new Bundle();
        b = getIntent().getExtras();

        String nome = b.get("nome").toString();
        String login =b.get("login").toString();
        String objetivo = b.get("objetivo").toString();


        AlertDialog.Builder c = new AlertDialog.Builder(this);

        c.setTitle("Informações");
        c.setIcon(android.R.drawable.ic_dialog_info);
        c.setMessage("Nome : " + " " + nome +  "\n" +
                        "Login : " + " " + login + "\n" +
                        "Objetivo : " + " " + objetivo + "\n");

        AlertDialog a = c.create();

        a.show();

    }


    public void caixa() {

            Bundle b  = new Bundle();
            b = getIntent().getExtras();

            String texto = b.get("pagamento").toString();
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();


            try {

                BitMatrix bitMatrix = multiFormatWriter.encode(texto, BarcodeFormat.QR_CODE, 200, 200);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                //imgQr.setImageBitmap(bitmap);


                AlertDialog.Builder alertadd = new AlertDialog.Builder(this);


                LayoutInflater factory = LayoutInflater.from(this);
                final View view = factory.inflate(R.layout.sample, null);

                ImageView img = (ImageView) view.findViewById(R.id.dialog_imageview);

                img.setImageBitmap(bitmap);

                alertadd.setView(view);

                alertadd.setNeutralButton("OK!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                });


                alertadd.show();


            } catch (WriterException e) {
                e.printStackTrace();
            }


        }

    }
