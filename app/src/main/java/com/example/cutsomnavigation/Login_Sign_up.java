package com.example.cutsomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login_Sign_up extends AppCompatActivity
{
    FirebaseAuth mAuth;
    EditText email;
    EditText password;
    DatabaseReference ref;
    Button signup;
    Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up);
        //Toast.makeText(this,"Values saved",Toast.LENGTH_LONG).show();
        mAuth = FirebaseAuth.getInstance();
        loginbutton = findViewById(R.id.button2);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = findViewById(R.id.email);
                password = findViewById(R.id.pass);
                String e1 = email.getText().toString().trim();
                String p1 = password.getText().toString().trim();
                //Toast.makeText(Login_Sign_up.this,e1,Toast.LENGTH_SHORT).show();
                //Toast.makeText(Login_Sign_up.this,p1,Toast.LENGTH_SHORT).show();

                if (TextUtils.isEmpty(e1) || TextUtils.isEmpty(p1)) {
                    Toast.makeText(Login_Sign_up.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                } else if (p1.length() < 6)
                {
                    Toast.makeText(Login_Sign_up.this, "Password Too Short", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(this,p1,Toast.LENGTH_SHORT).show()
                    loginUser(e1, p1);
                    String status = retrievingfromfirebase();
                    Toast.makeText(Login_Sign_up.this,status,Toast.LENGTH_SHORT).show();
                    if (status.equals("Doctor")) {
                        Intent intent = new Intent(Login_Sign_up.this, Activity_main_Doctor.class);
                        startActivity(intent);
                    } else if (status.equals("Admin")) {
                        Intent intent = new Intent(Login_Sign_up.this, Activity_main_Admin.class);
                        startActivity(intent);
                    } else if (status.equals("Patient")) {
                        Intent intent = new Intent(Login_Sign_up.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //Toast.makeText(Login_Sign_up.this,"fuck",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login_Sign_up.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private String retrievingfromfirebase ()
    {
        final String[] status = new String[1];
        ref = FirebaseDatabase.getInstance().getReference().child("User");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                status[0] = snapshot.child("status").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Login_Sign_up.this, (CharSequence) error,Toast.LENGTH_SHORT).show();
            }
        });
        return status[0];
    }
    private void loginUser (String e1, String p1) {
        mAuth.signInWithEmailAndPassword(e1, p1)
                .addOnCompleteListener(Login_Sign_up.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login_Sign_up.this, "Sign-in Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            email.getText().clear();
                            password.getText().clear();
                            //Toast.makeText(Login_Sign_up.this, "Error ! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(Login_Sign_up.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}