package com.example.agregarcontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Metodo boton agregar contacto
    public void agregarContacto(View view){
        Intent intent = new Intent(this, AgregarContactos.class);
        startActivity(intent);

    }
    //Metodo llamar al 112 con ACTION_DIAL, abre la app de llamada con el numero marcado
    public void llamar_112(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + 112));
        startActivity(intent);
    }
}