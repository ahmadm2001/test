package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import static com.example.test.FBref.refAuth;
import static com.example.test.FBref.refcustomer;
import static com.example.test.FBref.refmanager;

public class register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Switch s;
    EditText eTname, eTphone, eTcode, eTnc, eTnd;
    String name, phone, numbercar, uid, numberDrivinig, TypeCar, text;
    Spinner spinner;
    boolean man;
    FirebaseAuth mAuth;
    Customer customer;
    Manager manager;
    PhoneAuthCredential c;
    private String mVerificationId;
    Boolean mVerificationInProgress = false;

    private static final String TAG = "Phone";
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TypeCar = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void ahmad(View v) {
        if (s.isChecked()) {
            man = true;
            Toast.makeText(register.this, "hello customer ", Toast.LENGTH_LONG).show();
        }
        if (man) {
            spinner.setVisibility(View.VISIBLE);
            eTnd.setVisibility(View.INVISIBLE);

        }
    }

    public void logorreg(View view) {
        if(man) {
            name = eTname.getText().toString();
            numbercar = eTnc.getText().toString();
            phone = eTphone.getText().toString();
            final ProgressDialog pd = ProgressDialog.show(this, "Register", "Registering...", true);
            uplod();
            if (name.isEmpty()) eTname.setError("you must enter a name");
            if (phone.isEmpty()) eTphone.setError("you must enter a phone number");
            if (numbercar.isEmpty())eTnc.setError("you must enter a numbercar");

        }
        else {
            name = eTname.getText().toString();
            numbercar = eTnc.getText().toString();
            phone = eTphone.getText().toString();
            numberDrivinig = eTnd.getText().toString();
            if (name.isEmpty()) eTname.setError("you must enter a name");
            if (phone.isEmpty()) eTphone.setError("you must enter a phone number");
            if (numbercar.isEmpty())eTnc.setError("you must enter a numbercar");
            if(numberDrivinig.isEmpty())eTnd.setError("you must enter a numberDrivinig");

            final ProgressDialog pd = ProgressDialog.show(this, "Register", "Registering...", true);
            uplod();
        }



    }
    public  void  uplod(){
          if (man) {
              customer=new Customer(name, phone, TypeCar, numbercar, uid);
              refcustomer.child("customer users").child(phone).setValue(customer);
              ProgressDialog pd = ProgressDialog.show(this, "Register", "Registering...", true);
              Toast.makeText(register.this, "Successful registration", Toast.LENGTH_LONG).show();
              Intent si = new Intent(register.this, MainActivity.class);
              startActivity(si);
          }
          else {

              manager=new Manager(name, phone, numberDrivinig,numbercar,uid);
              refmanager.child("manager users").child(phone).setValue(manager);
              ProgressDialog pd = ProgressDialog.show(this, "Register", "Registering...", true);
              Toast.makeText(register.this, "Successful registration", Toast.LENGTH_LONG).show();
              Intent si = new Intent(register.this, MainActivity.class);
              startActivity(si);
          }
    }
    }

