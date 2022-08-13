package com.example.IF3_10119112;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLoginBinding binding;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(this);
        binding.btnLogin.setOnClickListener(this);
    }

    protected void userSignIn() {
        auth = FirebaseAuth.getInstance();

        String email = Objects.requireNonNull(binding.emailLayout.getEditText()).getText().toString();
        String password = Objects.requireNonNull(binding.passwordLayout.getEditText()).getText().toString();

        if (email.isEmpty() && password.isEmpty()) {
            binding.emailLayout.setError(getApplicationContext().getText(R.string.error));
            binding.passwordLayout.setError(getApplicationContext().getText(R.string.error));
        } else if (email.isEmpty()){
            binding.emailLayout.setError(getApplicationContext().getText(R.string.error));
        } else if (password.isEmpty()) {
            binding.passwordLayout.setError(getApplicationContext().getText(R.string.error));
        }
        else {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(getApplicationContext(), ViewPageActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), ViewPageActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRegister) {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.btnLogin) {
            userSignIn();
        }
    }
}