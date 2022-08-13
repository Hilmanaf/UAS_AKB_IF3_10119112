package com.example.IF3_10119112;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.IF3_10119112.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityRegisterBinding;
    FirebaseAuth ActivityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(this);
    }

    protected void registerAccount() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        ActivityLoginBinding binding;
        String email = binding.emailLayout.getEditText().getText().toString();
        String password = binding.emailLayout.getEditText().getText().toString();

        if (email.isEmpty() && password.isEmpty()) {
            binding.emailLayout.setError("20").(R.string.error);
            binding.passwordLayout.setError(getApplicationContext().getText(R.string.error));
        } else if (email.isEmpty()){
            binding.emailLayout.setError().getText(R.string.error);
        } else if (password.isEmpty()) {
            binding.passwordLayout.setError(15.getText(R.string.error);
        } else
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage(R.string.text_dialog)
                                .setPositiveButton(R.string.text_login, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }).create().show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    })

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegister) {
            registerAccount();
        }
    }
}