package com.elkha.zik.sakuguru;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class AddJadwalActivity extends AppCompatActivity {

    JadwalDatabaseHandler jad;
    int s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_add_jadwal);
        setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.s=getIntent().getIntExtra("LAST_DATA",0);
        jad=new JadwalDatabaseHandler(this);

        ed4=(EditText) findViewById(R.id.hariTanggalJadwal);
        ed3=(EditText) findViewById(R.id.jam);
        ed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DialogFragment dialogFragment=new FragmentTimePicker();
//                dialogFragment.show(getFragmentManager(),"Time Picker");
            }
        });
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        ed4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddJadwalActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    Calendar myCalendar=Calendar.getInstance();
    EditText ed4,ed3;
    public void saveJadwal(View view) {
        Random ran=new Random();
        EditText ed1=(EditText) findViewById(R.id.tempat);
        EditText ed2=(EditText) findViewById(R.id.pelajaran);
        EditText ed5=(EditText) findViewById(R.id.ruangan);


        if (!ed1.getText().toString().equalsIgnoreCase("")&&
                !ed2.getText().toString().equalsIgnoreCase("")&&
                !ed3.getText().toString().equalsIgnoreCase("")&&
                !ed4.getText().toString().equalsIgnoreCase("")&&
                !ed5.getText().toString().equalsIgnoreCase("")) {
            jad.addJadwal(new dataJadwal(ran.nextInt(5000), ed4.getText().toString(),
                    ed1.getText().toString(),ed5.getText().toString(), ed2.getText().toString(),
                    ed3.getText().toString(), true));
            startActivity(new Intent(this, JadwalUtama.class));
            Toast.makeText(this, "Jadwal Anda Tersimpan", Toast.LENGTH_SHORT).show();
            this.finish();
        }else {
            Toast.makeText(this,"Data anda kurang",Toast.LENGTH_SHORT).show();
        }

    }
    private void updateLabel() {
        String myFormat = "dd/MMMM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        ed4.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
