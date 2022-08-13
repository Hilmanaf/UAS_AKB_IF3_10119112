package com.example.IF3_10119112;

// nim   : 10119112
// nama  : Hilman Ahmad Fathoni
// kelas : IF-3

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ViewPageActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        Button btnAct = findViewById(R.id.btnAct);
        btnAct.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAct:
                Intent pindahIntent1 = new Intent(ViewPageActivity.this, MenuActivity.class);
                startActivity(pindahIntent1);
                break;
        }
    }

}