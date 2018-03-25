package com.elkha.zik.sakuguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    EditText nama,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_login_screen);
        nama=(EditText) findViewById(R.id.userLogin);
        pass=(EditText) findViewById(R.id.passLogin);
    }

    public void login(View view) {
        if (nama.getText().toString().equalsIgnoreCase("admin")&&
                pass.getText().toString().equalsIgnoreCase("admin")){
            Toast.makeText(this,"Selamat Datang",Toast.LENGTH_SHORT).show();
            Intent in=new Intent(this,JadwalUtama.class);
            startActivity(in);
        }else if(nama.getText().toString().equalsIgnoreCase("")||
                pass.getText().toString().equalsIgnoreCase("")){
            Toast.makeText(this,"jangan kosong atuh",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Username atau Password salah",Toast.LENGTH_SHORT).show();
        }
    }

    public void signUp(View view) {
        Intent in=new Intent(this,SignUp.class);
        this.finish();
        startActivity(in);
    }

}
