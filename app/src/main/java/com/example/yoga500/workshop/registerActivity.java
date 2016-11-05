package com.example.yoga500.workshop;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class registerActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPass;
    private EditText etConPass;
    private EditText etdis;
    private Button btnRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etdis = (EditText) findViewById(R.id.etdist);
        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        etConPass = (EditText) findViewById(R.id.etConPass);
        btnRegist = (Button) findViewById(R.id.btnRegist);

        setEvent();

    }

    private void setEvent() {
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    new Register(etUser.getText().toString(),
                            etPass.getText().toString(),
                            etConPass.getText().toString(),
                            etdis.getText().toString()).execute();


                } else {
                    Toast.makeText(registerActivity.this, "ใส่ข้อมูลให้ครบ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate() {

        String username = etUser.getText().toString();
        String password = etPass.getText().toString();
        String passwordconfirm = etConPass.getText().toString();
        String displayname = etdis.getText().toString();

        if (username.isEmpty()) return false;

        if (password.isEmpty()) return false;

        if (passwordconfirm.isEmpty()) return false;

        if (!password.equals(passwordconfirm)) return false;

        if (displayname.isEmpty()) return false;

        return true;
    }

    private class Register extends AsyncTask<Void, Void ,String>{

        private  String username;
        private  String password;
        private  String passwordcon;
        private  String displayname;

        public Register(String username, String password, String passwordcon, String displayname) {
            this.username = username;
            this.password = password;
            this.passwordcon = passwordcon;
            this.displayname = displayname;
        }

        @Override
        protected String doInBackground(Void... params) {
            OkHttpClient client = new OkHttpClient();
            Request request;
            Response response;

            RequestBody requestBody = new FormBody.Builder()
                    .add("username" , username)
                    .add("password" , password)
                    .add("password_con" , passwordcon)
                    .add("display_name" , displayname)
                    .build();
            request = new Request.Builder()
                    .url("http://kimhun55.com/pollservices/signup.php")
                    .post(requestBody)
                    .build();

            try{
                response = client.newCall(request).execute();

                if (response.isSuccessful()){
                    return response.body().string();
                }

            }catch (IOException ex){
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject rootobj = new JSONObject(s);
                if (rootobj.has("result")){
                    JSONObject resultobj = rootobj.getJSONObject("result");
                    if (resultobj.getInt("result")==1){
                        Toast.makeText(registerActivity.this, resultobj.getString("result_desc"),Toast.LENGTH_SHORT).show();
                        finish();;
                    } else {
                        Toast.makeText(registerActivity.this, resultobj.getString("result_desc"),Toast.LENGTH_SHORT).show();
                    }
                }
            }catch (JSONException ex){

            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
    }
}

