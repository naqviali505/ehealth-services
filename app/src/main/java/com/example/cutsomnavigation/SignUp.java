package com.example.cutsomnavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.text.TextUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    EditText fname;
    EditText lname;
    EditText email;
    EditText pass;
    int id=1000;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Spinner spinner = findViewById(R.id.spinner_days);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Spinner spinner1 = findViewById(R.id.statussp);
        ArrayAdapter<CharSequence> Sadapter = ArrayAdapter.createFromResource(this, R.array.Status, android.R.layout.simple_spinner_item);
        Sadapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(Sadapter);

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(SignUp.this,Login_Sign_up.class));
        }
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        Button signup = findViewById(R.id.button1);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f_name = fname.getText().toString().trim();
                String l_name = lname.getText().toString().trim();
                String e_mail = email.getText().toString().trim();
                String p_ass = pass.getText().toString().trim();
                String g_ender = spinner.getSelectedItem().toString();
                String s_tatus = spinner1.getSelectedItem().toString();
                if (TextUtils.isEmpty(f_name)) {
                    Toast.makeText(SignUp.this, "Empty fname", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(l_name)) {
                    Toast.makeText(SignUp.this, "Empty lname", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(e_mail)) {
                    Toast.makeText(SignUp.this, "Empty email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(p_ass)) {
                    Toast.makeText(SignUp.this, "Empty pass", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(g_ender)) {
                    Toast.makeText(SignUp.this, "Empty gender", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(s_tatus)) {
                    Toast.makeText(SignUp.this, "Empty status", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(SignUp.this,"F",Toast.LENGTH_SHORT).show();
                    signupUser(f_name, l_name, e_mail, p_ass, g_ender, s_tatus);
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    private void signupUser(String f_name, String l_name, String e_mail, String p_ass, String g_ender, String s_tatus)
    {
        mAuth.createUserWithEmailAndPassword(e_mail,p_ass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                FirebaseDatabase db=FirebaseDatabase.getInstance();
                DatabaseReference ref=db.getReference("User");
                User user = new User(f_name, l_name, e_mail, p_ass, g_ender, s_tatus);
                //Toast.makeText(SignUp.this, g_ender, Toast.LENGTH_SHORT).show();
                //Toast.makeText(SignUp.this, s_tatus, Toast.LENGTH_SHORT).show();


                //Toast.makeText(SignUp.this, "In success successfully", Toast.LENGTH_SHORT).show();
                ref.child(Integer.toString(id)).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused)
                    {
                        Toast.makeText(SignUp.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignUp.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {
                email.getText().clear();
                fname.getText().clear();
                lname.getText().clear();
                pass.getText().clear();
                Toast.makeText(SignUp.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String gender=adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}
