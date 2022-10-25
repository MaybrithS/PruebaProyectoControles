package com.cdp.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    TextView txtView;
    Button btnFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        txtView=findViewById(R.id.txtView);
        btnFinal=findViewById(R.id.btnFinal);

        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Actividad2.this, MainActivity.class);
                startActivity(intent);
            }});

        String datos= "\nNombre: " +(getIntent().getStringExtra("txtName"))+"\nEmail: "+(getIntent().getStringExtra("email"))+ "\nNúmero celular: "+(getIntent().getStringExtra("txtNumero"))+ "\nContraseña: " +(getIntent().getStringExtra("txtContraseña"))+ "\nGénero: "+(getIntent().getStringExtra("Genero"))+"\nNivel de estudio: "+(getIntent().getStringExtra("btnSelec")) +"\nHora: "+(getIntent().getStringExtra("Horario"));
        txtView.setText(datos);
    }
}