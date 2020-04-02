package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import static com.example.test.FBref.refcustomer;
import static com.example.test.FBref.refmanager;

public class MainActivity extends AppCompatActivity {
    Intent t;
    CheckBox cbStayConnect;
    Boolean stayConnect, registered;
    String phone, code, mVerificationId, uid = "";
    EditText eTphone, eTcode;
    FirebaseUser user;
    ValueEventListener usersListener;

    Boolean mVerificationInProgress = false;
    public static FirebaseAuth refAuth = FirebaseAuth.getInstance();
    private static final String TAG = "Phone";
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTphone = (EditText) findViewById(R.id.eTcode);
        eTcode = (EditText) findViewById(R.id.eTcode);
        stayConnect = false;
        registered = false;
    }


    public void register(View view) {
        t = new Intent(MainActivity.this, register.class);
        startActivity(t);
    }
}



