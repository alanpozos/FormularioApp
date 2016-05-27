package com.alan2.formularioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatosActivity extends AppCompatActivity {

    TextView tvNombreCompleto;
    TextView tvConfirmarFecha;
    TextView tvConfrimarTel;
    TextView tvConfirmarMail;
    TextView tvConfirmarDesc;

    Button botonEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvNombreCompleto = (TextView) findViewById(R.id.tvConfirmarNombre);
        tvConfirmarFecha = (TextView) findViewById(R.id.tvConfirmarFechaNac);
        tvConfrimarTel = (TextView) findViewById(R.id.tvConfirmarTelefono);
        tvConfirmarMail = (TextView) findViewById(R.id.tvConfirmarEmail);
        tvConfirmarDesc = (TextView) findViewById(R.id.tvConfirmarDescripcion);

        botonEditar = (Button) findViewById(R.id.btnEditar);

        Bundle parametros = getIntent().getExtras();
        String nombreCompleto = parametros.getString("Nombre");
        String fechaNac = parametros.getString("Fecha");
        String tel = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");

        tvNombreCompleto.setText(nombreCompleto);
        tvConfirmarFecha.setText(fechaNac);
        tvConfrimarTel.setText(tel);
        tvConfirmarMail.setText(email);
        tvConfirmarDesc.setText(descripcion);

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
