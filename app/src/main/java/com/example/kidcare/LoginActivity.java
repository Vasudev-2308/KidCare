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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    Button login;
    TextView kidscare, fgpwd, register;
    EditText email,password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        kidscare = findViewById(R.id.kidcare);
        Typeface tf = ResourcesCompat.getFont(
                this,
                R.font.gothambold);
        kidscare.setTypeface(tf);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        fgpwd = findViewById(R.id.forgotpassword);
        register = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();
        fgpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emil = email.getText().toString();
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
                mAuth.sendPasswordResetEmail(emil).addOnSuccessListener((OnSuccessListener<Void>) avoid -> {
                    Toast.makeText(LoginActivity.this,"Password Reset Link sent to "+emil, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this,StartActivity.class));
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(LoginActivity.this,"Please Try Again Later", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this,StartActivity.class));
                    }
                });


            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        login.getBackground().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login(){
        String emil = email.getText().toString();
        String pswd = password.getText().toString();

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
            password.setError("Minimum 8 characters required ");
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(emil,pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User Logged in Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"An error Occurred Please Try Again",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,StartActivity.class);
                        startActivity(intent);
                    }
            }

        });

    }

}