package com.example.kidcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckRegisterStatus extends AppCompatActivity {
    Button student,parent, admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_register_status);
        student = findViewById(R.id.student);
        student.getBackground().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
        parent = findViewById(R.id.parent);
        parent.getBackground().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
        admin = findViewById(R.id.admin);
        admin.getBackground().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckRegisterStatus.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckRegisterStatus.this,ParentRegisterActivity.class));
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckRegisterStatus.this,AdminRegister.class));
            }
        });
    }
}