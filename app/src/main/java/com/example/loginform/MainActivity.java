package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText emailEt, passEt;
    Button logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEt = findViewById(R.id.email);
        passEt = findViewById(R.id.password);
        logBtn = findViewById(R.id.logBtn);



        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               function();
            }
        });


    }

    void function(){
        boolean isvalid=false;
        View vi = null;
        String email=emailEt.getText().toString();
        String password=passEt.getText().toString();
        if(TextUtils.isEmpty(email)){
            isvalid=true;
            vi=emailEt;
            emailEt.setError("Field Can Not Be Empty!");
        }else if(TextUtils.isEmpty(password)){
            isvalid=true;
            vi=passEt;
            passEt.setError("Passwrod Can Not Be Empty!");
        }else if(!email.contains("@")){
            isvalid=true;
            vi=emailEt;
            emailEt.setError("Email Is Not Valid!");
        }else if(password.length()<8){
            isvalid=false;
            vi=passEt;
            passEt.setError("Password Length Must Be Greater Than 8!");
        }
        if(isvalid){
            vi.requestFocus();
            isvalid=false;
        }else {
            Toast.makeText(this,"Logged In Successful!",Toast.LENGTH_SHORT).show();
        }

    }

}
