package com.elkha.zik.sakuguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AbsensiPelajaran extends AppCompatActivity {
ListView ls;
Button had,iz,al,sakit;
int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi_pelajaran);
        ls=(ListView) findViewById(R.id.listAbsen);
        ArrayList<String> absen=new ArrayList<>();
        had=(Button) findViewById(R.id.hadirButton);
        iz=(Button) findViewById(R.id.izinButton);
        al=(Button) findViewById(R.id.alfaButton);
        sakit=(Button) findViewById(R.id.sakitButton);
        al.setTag("position");
        i=0;
        for (int i = 0; i < 60; i++) {
            absen.add("Zikrullah Aliwainda");
            absen.add("Luthfi Hafiyyan");
            absen.add("Hidayatulhidayah");
        }
        ArrayAdapter ar=new ArrayAdapter(this,R.layout.text_absen,absen);
        ls.setAdapter(ar);

    }

    public void alfaAct(View view) {
        i=ls.getFirstVisiblePosition()+1;
        View c = ls.getChildAt(0);
        int scrolly = ls.getFirstVisiblePosition() ;
        //int position = (Integer) view.findViewById(R.id.alfaButton).getTag();
       ls.smoothScrollToPositionFromTop(i+1,90);
    }
}
