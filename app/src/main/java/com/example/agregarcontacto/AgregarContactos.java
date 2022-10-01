package com.example.agregarcontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarContactos extends AppCompatActivity {

    //Declaracion de las vistas
    private EditText nombre;
    private EditText correo;
    private EditText numero;
    private Button agregarContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos);


        nombre = (EditText) findViewById(R.id.editText_nombre);
        correo = (EditText) findViewById(R.id.editText_number);
        numero = (EditText) findViewById(R.id.editText_correo);
        agregarContacto = (Button) findViewById(R.id.boton_agregarContacto);
    }


    //Metodo para añadir un contacto
    public void anadirContacto(View view){
        //Verificamos si el usuario a compleatdo todos los campos, sino mandara un mensaje.
        //Si el usuario ha rellenado todos los campos usaremos la accion ACTION_INSERT para agregarlo
        if(!nombre.getText().toString().isEmpty() && !correo.getText().toString().isEmpty() && !numero.getText().toString().isEmpty()){
            Intent intent = new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.NAME, nombre.getText().toString());
            intent.putExtra(ContactsContract.Intents.Insert.PHONE, numero.getText().toString());
            intent.putExtra(ContactsContract.Intents.Insert.EMAIL, correo.getText().toString());

            //Verificamos seguidamente si hay alguna aplicacion de contactos instalada
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }else{
                Toast.makeText(AgregarContactos.this, "No hay ninguna aplicacion de contactos", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(AgregarContactos.this, "Rellene los datos", Toast.LENGTH_SHORT).show();
        }

    }
}