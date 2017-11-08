package entity;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import codigoqr.fiap.com.br.leitordecodigo.R;

/**
 * Created by WaldemirGomesDeAndra on 06/11/2017.
 */

public class FitnessAdapter extends ArrayAdapter<Fitness> {

    private Context context;
    private ArrayList<Fitness> elementos;

    public FitnessAdapter(Context context, ArrayList<Fitness>elementos) {
        super(context, R.layout.linha,elementos);
        this.context = context;
        this.elementos = elementos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView nomeEscola = (TextView) rowView.findViewById(R.id.nome);
        TextView endereco = (TextView) rowView.findViewById(R.id.endereco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);



        nomeEscola.setText(elementos.get(position).getNome());
        endereco.setText(elementos.get(position).getDescricao());

        imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }






}
