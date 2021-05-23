package com.example.kidcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mAuth ;
    Button register;
    TextView kidscare, login;
    EditText name,age,dob,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        dob = findViewById(R.id.dob);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        kidscare = findViewById(R.id.kidcare);
        Typeface tf = ResourcesCompat.getFont(
                this,
                R.font.gothambold);
        kidscare.setTypeface(tf);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        register.getBackground().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                registerUser();

            }
        });
    }



    private void registerUser(){
        String nam = name.getText().toString().trim();
        String ageval = age.getText().toString().trim();
        String dateob = dob.getText().toString().toUpperCase().trim();
        String emil = email.getText().toString();
        String pswd = password.getText().toString();

        if(nam.isEmpty()){
            name.setError("Please Enter A name");
            name.requestFocus();
            return;
        }
        if(ageval.isEmpty()){
            age.setError("Please Enter A Class");
            age.requestFocus();
            return;
        }
        if(dateob.isEmpty()){
            dob.setError("Please Enter your Admission Number");
            dob.requestFocus();
            return;
        }
        if(emil.isEmpty()){
            email.setError("Please Enter Email Address");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emil).matches()){
            email.setError("Please Enter Valid Email Address");
            email.requestFocus();
            return;
        }
        if(pswd.isEmpty()){
            password.setError("Please Enter A valid Password");
            password.requestFocus();
            return;
        }
        if(pswd.length()<8){
            password.setError("Weak Password");
            password.requestFocus();
            return;
        }

            mAuth.createUserWithEmailAndPassword(emil,pswd)
                    .addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            User user = new User(nam,ageval,dateob,emil);
                            FirebaseDatabase.getInstance().getReference("Student")
                                    .child(mAuth.getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(task1 -> {
                                        if(task1.isSuccessful()){
                                            Intent intent = new Intent(RegisterActivity.this,Intermediate.class);
                                            startActivity(intent);
                                        }else {
                                            startActivity(new Intent(RegisterActivity.this,StartActivity.class));
                                        }
                                    });
                        }
                        else {
                            startActivity(new Intent(RegisterActivity.this,StartActivity.class));
                        }
                    });


    }


}