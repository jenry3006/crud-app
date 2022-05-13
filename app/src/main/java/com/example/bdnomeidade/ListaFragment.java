package com.example.bdnomeidade;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ListaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance){
        View v = inflater.inflate(R.layout.conteudo_lista, container,false);

        //Aqui vai cdg do bd
        //Cria um objeto DataManager
        DataManager dm = new DataManager(getActivity());
        //Busca a textview e atribui para a variavel id listarTodos
        TextView textResultados = v.findViewById(R.id.listarTodos);
        //vai no DataManager metodo listar para listar todos os registros
        Cursor c = dm.listar();

        String resultados = "";

        while (c.moveToNext()){
            //Adiciona o resultado para a string
            resultados += (c.getString(1) + " - " + c.getString(2) + "\n");
        }
        //Exibe os resultados na textView
        textResultados.setText(resultados);
        return v;
    }
}
