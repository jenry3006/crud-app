package com.example.bdnomeidade;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BuscarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance){
        View v = inflater.inflate(R.layout.conteudo_buscar, container,false);

        //Aqui vai cdg do bd
        DataManager dm = new DataManager(getActivity());

        EditText nome = v.findViewById(R.id.idBuscar);
        Button btn = v.findViewById(R.id.buttonBusca);
        TextView resultados = v.findViewById(R.id.todosRegistros);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = dm.consulta(nome.getText().toString());
                //verificarcao para ver tem resultado
                if(c.getCount() > 0){
                    c.moveToNext();
                    String texto = "Resultado = " + c.getString(1) + " - " + c.getString(2);
                    resultados.setText(texto);
                }
            }
        });

        return v;
    }
}
