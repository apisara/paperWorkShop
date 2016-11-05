package com.example.yoga500.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registerActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPass;
    private EditText etConPass;
    private Button btnRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUser    = (EditText) findViewById(R.id.etUser);
        etPass    = (EditText) findViewById(R.id.etPass);
        etConPass = (EditText) findViewById(R.id.etConPass);
        btnRegist = (Button) findViewById(R.id.btnRegist);

        setEvent();
    }

    private void setEvent() {
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(registerActivity.this,loginActivity.class);
                startActivity(i);
            }
        });
    }

}
