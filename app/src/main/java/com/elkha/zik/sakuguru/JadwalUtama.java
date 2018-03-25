package com.elkha.zik.sakuguru;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JadwalUtama extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener
,Tab3.OnFragmentInteractionListener{

    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jadwal_utama);
        tablay();
//        dataJadwal hasilGetJadwal=jad.getDataJadwal(1);
//        TextView txt=(TextView) rootView.findViewById(R.id.coba);
//        Toast.makeText(this,"ini dia  "+hasilGetJadwal.getId(),Toast.LENGTH_SHORT);
//        txt.setText(hasilGetJadwal.getJadwal_tempat()+"");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction() {

    }

    public void addJadwal(View view) {

        Intent i=new Intent(this,AddJadwalActivity.class);
        i.putExtra("LAST_DATA",3);
        startActivity(i);
        this.finish();
    }
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase("/data/data/com.elkha.zik.sakuguru/databases/sakuguru.db3", null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            // database doesn't exist yet.
        }
        return checkDB != null;
    }
    private void tablay(){
        TabLayout tab=(TabLayout) findViewById(R.id.tablayout);
        tab.addTab(tab.newTab().setText("Jadwal Anda"));
        tab.addTab(tab.newTab().setText("RPP"));
        tab.addTab(tab.newTab().setText("Soal & Materi"));
        tab.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager v=(ViewPager) findViewById(R.id.pager);
        final PageAdapter adapt=new PageAdapter(getSupportFragmentManager(),tab.getTabCount());
        v.setAdapter(adapt);
        v.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));


        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                v.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    public void aduh(View view) {


//        relativeLayout.addView(s);
    }

    @Override
    public void onFragmentInteraction(String string) {

    }
}
