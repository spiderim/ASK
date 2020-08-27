package com.example.ask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText setname,setemail,setpassword,setnumber;
    Button sbtsignup;
    ProgressBar spbprogress;
    FirebaseAuth fAuth;
    TextView stvsignup,stvname,stvemail,stvpassword,stvnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setemail=findViewById(R.id.setemail);
        setname=findViewById(R.id.setname);
        setpassword=findViewById(R.id.setpassword);
        setnumber=findViewById(R.id.setphone);
        sbtsignup=findViewById(R.id.sbtsignup);
        spbprogress=findViewById(R.id.spbprogress);
        stvsignup=findViewById(R.id.stvsignup);
        stvname=findViewById(R.id.stvname);
        stvemail=findViewById(R.id.stvemail);
        stvpassword=findViewById(R.id.stvpassword);
        stvnumber=findViewById(R.id.stvphone);
        fAuth=FirebaseAuth.getInstance();
       /* if(fAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }*/

    }

    public void sbtclick(View view) {

        String email=setemail.getText().toString().trim();
        String password=setpassword.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            setemail.setError("email is required");
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            setpassword.setError("password is required");
            return;
        }
        if(password.length()<6)
        {
            setpassword.setError("password must be greater than 6 character");
            return;
        }
        sbtsignup.setVisibility(View.INVISIBLE);
        spbprogress.setVisibility(View.VISIBLE);
        fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Signup.this,"signup sucessfully",Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),news.class));
                }
                else
                {
                    Toast.makeText(Signup.this, "Error !", Toast.LENGTH_LONG).show();
                    sbtsignup.setVisibility(View.VISIBLE);
                    spbprogress.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
