package com.elkha.zik.sakuguru;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zik on 19/02/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<JadwalSekolah> jadwal;
    private Context con;

    public UserAdapter(List<JadwalSekolah> jadwal, Context con) {
        this.jadwal = jadwal;
        this.con = con;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_jadwal,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JadwalSekolah jad=(JadwalSekolah) jadwal.get(position);
        holder.isi.setText(jad.getSekolah()+"\n" +
                jad.getWaktu().toString()+"\n" +
                jad.getMataPelajaran()+"\n"+"no Hub : "+jad.getNoHub());

    }

    @Override
    public int getItemCount() {
        return jadwal.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView isi;
        public ViewHolder(View itemView) {
            super(itemView);
            isi=(TextView) itemView.findViewById(R.id.isian);

        }
}
}
