package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Switch s;
    EditText eTname, eTphone, eTcode, eTnc, eTnd;
    Spinner spinner;
    boolean man;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eTphone = findViewById(R.id.eTphone);
        eTcode = findViewById(R.id.eTcode);
        eTname = findViewById(R.id.eTname);
        eTnc = findViewById(R.id.numbercar);
        eTnd = findViewById(R.id.nd);
        s = findViewById(R.id.switch1);
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void ahmad (View v){
        if (s.isChecked()) {
            man = true;
            Toast.makeText(register.this, "Successful ", Toast.LENGTH_LONG).show();

        }
        if (man) {
            spinner.setVisibility(View.VISIBLE);
            eTnd.setVisibility(View.INVISIBLE);

        }
    }
}