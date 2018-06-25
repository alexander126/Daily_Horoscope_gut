package com.example.alex.daily_horoscope;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        final EditText signupemail = (EditText) findViewById(R.id.emailsignup);
        final EditText signuppass = (EditText) findViewById(R.id.passwordsignup);
        final EditText passconf = (EditText) findViewById(R.id.passwordconfirm);
        Button register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = signupemail.getText().toString();
                final String passw = signuppass.getText().toString();
                final String confpassw = passconf.getText().toString();
                Log.d("LENGHT", "value" + signuppass.length());
                if(signuppass.length() < 5)
                {
                    Toast.makeText(RegisterActivity.this,"This password is too short", Toast.LENGTH_LONG).show();
                }else{
                    if(passw.equals(confpassw))
                    {
                        mAuth.createUserWithEmailAndPassword(email, passw)
                                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d("Create user", "createUserWithEmail:success");
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            updateUI(user);
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Log.w("Error", "createUserWithEmail:failure", task.getException());
                                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
                                            updateUI(null);
                                        }

                                        // ...
                                    }
                                });
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Passwords does not match", Toast.LENGTH_LONG).show();
                    }
                }
            }
            private void updateUI(FirebaseUser user){
                if (user != null)
                {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Sorry",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
