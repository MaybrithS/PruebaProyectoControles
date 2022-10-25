package com.cdp.controles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtName,email, txtNumero, txtContaseña;
    Spinner btnSelec;
    RadioButton hora1, hora2,btnGeneroF, btnGeneroM,btnGeneroO ;
    Button btnGuardar;
    RadioGroup rGroupGenero,rGroupHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName=findViewById(R.id.txtName);
        email=findViewById(R.id.email);
        txtNumero=findViewById(R.id.txtNumero);
        txtContaseña=findViewById(R.id.txtContraseña);
        btnGeneroF=findViewById(R.id.btnGeneroF);
        btnGeneroM=findViewById(R.id.btnGeneroM);
        btnGeneroO=findViewById(R.id.btnGeneroO);
        btnSelec=findViewById(R.id.btnSelec);
        hora1=findViewById(R.id.hora1);
        hora2=findViewById(R.id.hora2);
        btnGuardar=findViewById(R.id.btnGuardar);
        rGroupGenero=findViewById(R.id.rGroupGenero);
        rGroupHorario=findViewById(R.id. rGroupHorario);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent(MainActivity.this,Actividad2.class);

                if (txtName.getText().toString().equals(" ") || txtNumero.getText().toString(). equals(""))
                {
                    Toast.makeText(MainActivity.this, "agregue nombre, correo electrónico y número de celular", Toast.LENGTH_LONG).show();
                }
                else if (!email.getText().toString().contains("@") || !email.getText().toString().contains("."))
                {
                    email.setError("correo invalido por falta de @ y/o .");
                }
                else {
                    intent.putExtra("txtName",txtName.getText().toString());
                    intent.putExtra("email",email.getText().toString());
                    intent.putExtra("txtNumero",txtNumero.getText().toString());
                    intent.putExtra("btnSelec",btnSelec.getSelectedItem().toString());
                    intent.putExtra("txtContraseña", txtContaseña.getText().toString());
                    String Hora="";
                    if (hora1.isChecked()){
                        Hora="tiempo completo";
                    } else if (hora2.isChecked()) {
                        Hora="Medio tiempo";
                    } else {
                        Hora="No seleccionó";
                    }
                    String selecGenero="";
                    if (btnGeneroF.isChecked()){
                        selecGenero="Femenino";
                    } else if (btnGeneroM.isChecked()){
                        selecGenero="Masculino";
                    }if (btnGeneroO.isChecked()){
                        selecGenero="otro";
                    } else{
                        selecGenero="Ninguno";
                    }
                    intent.putExtra("Horario",Hora);
                    intent.putExtra("Genero",selecGenero);
                    startActivity(intent);
              }
            }
        });
    }
      public void btnLimpiar(View view){
          txtName.setText("");
          email.setText("");
          txtNumero.setText("");
          txtContaseña.setText("");
          rGroupGenero.clearCheck();
          btnSelec.setSelection(0);
          rGroupHorario.clearCheck();
        }
}