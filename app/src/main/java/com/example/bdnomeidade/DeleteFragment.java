package com.example.bdnomeidade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class DeleteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstance){
        View v = inflater.inflate(R.layout.conteudo_delete, container,false);

        //Aqui vai cdg do bd
        DataManager dm = new DataManager(getActivity());
        Button btn = v.findViewById(R.id.buttonDelete);
        EditText nome = v.findViewById(R.id.idDelete);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.deletar(nome.getText().toString());
            }
        });

        return v;
    }
}
