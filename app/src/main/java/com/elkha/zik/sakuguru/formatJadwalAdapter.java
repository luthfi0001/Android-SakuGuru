package com.elkha.zik.sakuguru;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zik on 11/03/2018.
 */

public class formatJadwalAdapter extends ArrayAdapter<dataJadwal> {
    List<dataJadwal> list;
    Context con;
    public formatJadwalAdapter(@NonNull Context context, List<dataJadwal> ls) {
        super(context, 0,ls);
        list=ls;
        con=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= convertView;
        dataJadwal data=(dataJadwal) list.get(position);
        if (v==null)
            v=LayoutInflater.from(getContext()).inflate(R.layout.formatjadwal,parent,false);
        //find & inilize the component
        TextView t1=(TextView) v.findViewById(R.id.dateJadwal);
        TextView t2=(TextView) v.findViewById(R.id.tempatJadwal);
        TextView t3=(TextView) v.findViewById(R.id.ruanganJadwal);
        TextView t4=(TextView) v.findViewById(R.id.pelajaranJadwal);
        TextView t5=(TextView) v.findViewById(R.id.waktuJadwal);
        ImageView im=(ImageView) v.findViewById(R.id.imageJadwal);
        ImageView im2=(ImageView) v.findViewById(R.id.NoHadirJadwal);
        //set the view
        t1.setText(data.getJadwal_date());
        t2.setText(data.getJadwal_tempat());
        t3.setText(data.getJadwal_ruangan());
        t4.setText(data.getJadwal_Pelajaran());
        t5.setText(data.getJadwal_waktu());
        im.setImageResource(R.mipmap.ic_hadir);
        im2.setImageResource(R.mipmap.ic_nohadir);

        return v;
    }
}
