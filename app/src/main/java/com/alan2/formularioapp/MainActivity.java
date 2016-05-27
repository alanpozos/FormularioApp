package com.alan2.formularioapp;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private final static int PARAMETROS = 0;

    private int año;
    private int mes;
    private int dia;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener listenerSelectorFecha;

    EditText campoFecha;
    TextInputEditText campoNombre;
    TextInputEditText campoTelefono;
    TextInputEditText campoEmail;
    TextInputEditText campoDescripcion;

    Button botonFecha;
    Button botonSiguiente;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonFecha = (Button) findViewById(R.id.btnSeleccionar);
        botonSiguiente = (Button) findViewById(R.id.btnSiguiente);

        campoFecha = (EditText) findViewById(R.id.edtFechaNac);

        campoNombre = (TextInputEditText) findViewById(R.id.edtTxtNombre);
        campoTelefono = (TextInputEditText) findViewById(R.id.edtTelefono);
        campoEmail = (TextInputEditText) findViewById(R.id.edtEmail);
        campoDescripcion = (TextInputEditText) findViewById(R.id.edtDescripcion);

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatosActivity.class);
                intent.putExtra("Nombre", campoNombre.getText().toString() );
                intent.putExtra("Fecha", campoFecha.getText().toString());
                intent.putExtra("Telefono", campoTelefono.getText().toString() );
                intent.putExtra("Email", campoEmail.getText().toString() );
                intent.putExtra("Descripcion", campoDescripcion.getText().toString() );

                //startActivity(intent);
                startActivityForResult(intent, PARAMETROS);

            }
        });

        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH) ;
        dia = calendario.get(Calendar.DATE);

        botonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIPO_DIALOGO);
            }
        });

        listenerSelectorFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                año = year;
                mes = monthOfYear + 1;
                dia = dayOfMonth;
                mostrarFecha();
            }
        };


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this, listenerSelectorFecha, año, mes, dia);
        }
        return null;
    }

    private void mostrarDialogPicker(View control){
        showDialog(TIPO_DIALOGO);
    }

    private void mostrarFecha(){
        campoFecha.setText(dia + "/" + mes + "/" + año);
    }


}
