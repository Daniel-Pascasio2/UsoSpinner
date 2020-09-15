package com.example.usospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner spEdificios, spEdificiosXML;
    private TextView etDesc, etDescXML;
    String[] edifi = {"Benito Juarez","Simon Bolivar","Tomas Jefferson","Francisco Morazan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDesc = findViewById(R.id.etDescripcion);
        etDescXML = findViewById(R.id.etDescripcionXML);

        spEdificios = findViewById(R.id.spEdificios);
        spEdificiosXML = findViewById(R.id.spEdificiosXML);

        spEdificios.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, edifi));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.edificios_utec,android.R.layout.simple_spinner_dropdown_item);

        spEdificiosXML.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item));
        spEdificiosXML.setAdapter(adapter);

        spEdificios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),
                        String.valueOf(parent.getAdapter().getItem(i)),Toast.LENGTH_SHORT).show();
                etDesc.setText(spEdificios.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                etDescXML.setText("SELECCIONE");
            }

        });
        spEdificiosXML.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),
                        String.valueOf(adapterView.getAdapter().getItem(i)),Toast.LENGTH_SHORT).show();
                etDescXML.setText(spEdificiosXML.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                etDescXML.setText("SELECCIONE");
            }
        });
    }
}