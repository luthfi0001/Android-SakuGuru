package com.elkha.zik.sakuguru;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zik on 02/03/2018.
 */

public class JadwalDatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "sakuguru";

    // Contacts table name
    private static final String TABLE_NAME_1 = "jadwal";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_TEMPAT = "tempat",KEY_RUANGAN="ruangan",KEY_PELAJARAN = "pelajaran",KEY_WAKTU="waktu",KEY_NOHUB="nohub",KEY_ALASAN="alasan",
            KEY_IZIN_EXISTED="izinExisted",KEY_PENGULANGAN="pengulangan",KEY_KEHADIRAN="kehadiran";

    public JadwalDatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_JADWAL="CREATE TABLE "+TABLE_NAME_1+" ("+KEY_ID+" INTEGER PRIMARY KEY ,"+KEY_DATE+" TEXT,"+KEY_TEMPAT+" TEXT,"+
                KEY_RUANGAN+" TEXT,"+KEY_PELAJARAN+" TEXT,"+KEY_WAKTU+" TEXT,"+KEY_NOHUB+" TEXT,"+KEY_ALASAN+" TEXT,"+KEY_IZIN_EXISTED+" TEXT,"+KEY_PENGULANGAN+" TEXT,"
                +KEY_KEHADIRAN+" TEXT)";
                sqLiteDatabase.execSQL(CREATE_TABLE_JADWAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_1);
    }
    //add new data jadwal
    public void addJadwal(dataJadwal d){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(KEY_ID,d.getId());
        value.put(KEY_DATE,""+d.getJadwal_date()+"");
        value.put(KEY_TEMPAT,""+d.getJadwal_tempat()+"");
        value.put(KEY_RUANGAN,""+d.getJadwal_ruangan()+"");
        value.put(KEY_PELAJARAN,""+d.getJadwal_Pelajaran()+"");
        value.put(KEY_WAKTU,""+d.getJadwal_waktu()+"");
        value.put(KEY_NOHUB,""+d.getJadwal_noHub()+"");
        value.put(KEY_ALASAN,""+d.getJadwal_alasan()+"");
        value.put(KEY_IZIN_EXISTED,""+d.isIzin_existed()+"");
        value.put(KEY_PENGULANGAN,""+d.isJadwal_pengulangan()+"");
        value.put(KEY_KEHADIRAN,""+d.isJadwal_kehadiran()+"");
        db.insert(TABLE_NAME_1,null,value);
        db.close();
    }
    //get one data jadwal
    public dataJadwal getDataJadwal(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME_1,new String[] {KEY_ID,KEY_DATE,KEY_TEMPAT,KEY_RUANGAN ,KEY_PELAJARAN ,KEY_WAKTU,KEY_NOHUB,KEY_ALASAN,
                KEY_IZIN_EXISTED,KEY_PENGULANGAN,KEY_KEHADIRAN},KEY_ID +"=?",new String[]{String.valueOf(id)},null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        dataJadwal hasil=new dataJadwal(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5),true);

        return hasil;
    }
    public int last_data(){
        int last;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME_1,new String[] {KEY_ID,KEY_DATE,KEY_TEMPAT ,KEY_PELAJARAN ,KEY_WAKTU,KEY_NOHUB,KEY_ALASAN,
                KEY_IZIN_EXISTED,KEY_PENGULANGAN,KEY_KEHADIRAN},null,null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        dataJadwal hasil=new dataJadwal(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5),true);
        last=hasil.getId();

        return last;
    }
    public List<dataJadwal> getAllContacts() {
        List<dataJadwal> contactList = new ArrayList<dataJadwal>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME_1;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                dataJadwal dat=new dataJadwal();
                dat.setId(Integer.parseInt(cursor.getString(0)));
                dat.setJadwal_Pelajaran(cursor.getString(3));
                dat.setJadwal_date(cursor.getString(1));
                dat.setJadwal_waktu(cursor.getString(4));
                dat.setJadwal_tempat(cursor.getString(2));
                dat.setJadwal_ruangan(cursor.getString(5));
                // Adding contact to list
                contactList.add(dat);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
}
