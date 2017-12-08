package codigoqr.fiap.com.br.leitordecodigo;

import android.content.Intent;
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

public class Main7Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
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
        getMenuInflater().inflate(R.menu.main7, menu);
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
        int id = item.getItemId();

        Intent i = null;

        if (id == R.id.nav_camera) {

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            i = new Intent(Main7Activity.this, Main4Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

            i = new Intent(Main7Activity.this, Main5Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_manage) {

            i = new Intent(Main7Activity.this, Main6Activity.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {

            i = new Intent(Main7Activity.this, MainActivity.class);
            startActivity(i);
            finish();


        } else if (id == R.id.nav_send) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void abrirCadastro(View v) {

        Intent i = new Intent(Main7Activity.this, Main4Activity.class);
        startActivity(i);

    }

    public void abrirDieta(View v) {

        Intent i = new Intent(Main7Activity.this, Main5Activity.class);
        startActivity(i);

    }


    public void abrirUnidades(View v) {

        Intent i = new Intent(Main7Activity.this, Main6Activity.class);
        startActivity(i);

    }

    public void abrirMinhasInformacao(View v) {

        mensagem();

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


}
