package codigoqr.fiap.com.br.leitordecodigo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import entity.Fitness;
import entity.FitnessAdapter;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);


        ListView lista = (ListView) findViewById(R.id.lvAcademia);
        ArrayList<Fitness> academia = adicionarFilmes();
        ArrayAdapter adapter = new FitnessAdapter(this, academia);
        lista.setAdapter(adapter);

    }

    private ArrayList<Fitness> adicionarFilmes() {

        ArrayList<Fitness> academia = new ArrayList<Fitness>();

        Fitness e = new Fitness("Fitness Academia", "Rua Tutoia nº 120 - Paraiso", R.drawable.logo);
        academia.add(e);


        e = new Fitness("Fitness Academia", "Rua Augusta nº300 - Bela Vista", R.drawable.logo);
        academia.add(e);


        e = new Fitness("Fitness Academia", "Rua Martines Rodrigues nº1120  - Jundiaí", R.drawable.logo);
        academia.add(e);

        e = new Fitness("Fitness Academia", "Av. Catanduva nº250 - Brasilia", R.drawable.logo);
        academia.add(e);

        return academia;
    }


}
