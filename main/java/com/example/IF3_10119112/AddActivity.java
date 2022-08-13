package com.example.IF3_10119112;
//nim   : 10119112
//nama  : Hilman Ahmad Fathoni
//kelas : IF-3
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input, date_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_input);
        date_input = findViewById(R.id.date_input);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(view -> {
            MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
            myDB.addBook(title_input.getText().toString().trim(),
                    author_input.getText().toString().trim(),
                    pages_input.getText().toString().trim()
            );
            Intent pindahIntent = new Intent(AddActivity.this, MainActivity.class);
            startActivity(pindahIntent);
        });
    }
}