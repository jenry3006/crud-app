package com.example.bdnomeidade;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class InsertFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance){
        View v = inflater.inflate(R.layout.conteudo_insert, container,false);

        //Aqui vai cdg do bd
        DataManager dm = new DataManager(getActivity());

        Button btn = v.findViewById(R.id.botaoInserir);
        EditText nome = v.findViewById(R.id.editNome);
        EditText idade = v.findViewById(R.id.editIdade);

        //Pega o evento de clique no button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.inserir(nome.getText().toString(),idade.getText().toString());
            }
        });

        return v;
    }
}
