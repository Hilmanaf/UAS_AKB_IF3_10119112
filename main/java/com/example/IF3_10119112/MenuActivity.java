package com.example.IF3_10119112;
//nim   : 10119112
//nama  : Hilman Ahmad Fathoni
//kelas : IF-3
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class MenuActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnNote             = findViewById(R.id.btnNote);
        Button btnAbout             = findViewById(R.id.btnAbout);
        Button btnInfo             = findViewById(R.id.btnInfo);
        Button btnLogout             = findViewById(R.id.btnLogout);
        btnNote.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNote:
                Intent pindahIntent1 = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(pindahIntent1);
                break;
            case R.id.btnAbout:
                Intent pindahIntent2 = new Intent(MenuActivity.this, AboutActivity.class);
                startActivity(pindahIntent2);
                break;
            case R.id.btnInfo:
                Intent pindahIntent3 = new Intent(MenuActivity.this, InfoActivity2.class);
                startActivity(pindahIntent3);
                break;
            case R.id.btnLogout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}