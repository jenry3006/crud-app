package com.example.bdnomeidade;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bdnomeidade.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
            }
        });

        //Faz referencia ao layout que estamos criando
        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        //Cria um objeto que controla as drawers(gavetas)
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                0, 0);

        //Chama os listeners (gerenciadores de eventos)
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    //Editand oque acontece quando clicar em voltar
    //Se o drawer estiver aberto, fechar o drawer
    //Senão executar o comportamento normal

    @Override
    public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }

    }

    //Manipular os dados da barra de ação
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Manipular os eventos do menu de navegação(View navigation)
    @Override
    public boolean onNavigationItemSelected(MenuItem item){

        //Cria uma transaction , ou seja, um conjubto de operações com frahmentos diferentes
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();
        if(id == R.id.nav_insert){
            //Criar um novo fragmento do tipo apropriado
            InsertFragment fragment = new InsertFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        }
        else if(id == R.id.nav_delete){
            DeleteFragment fragment = new DeleteFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        }
        else if(id == R.id.nav_buscar){
            BuscarFragment fragment = new BuscarFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        }
        else if(id == R.id.nav_listar){
            ListaFragment fragment = new ListaFragment();
            transaction.replace(R.id.fragmentHolder, fragment);
        }

        //Armazena a seleção do usuário, sequencia que o usuario faz
        transaction.addToBackStack(null);
        transaction.commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}