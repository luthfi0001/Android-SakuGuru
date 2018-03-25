package com.elkha.zik.sakuguru;

import java.util.Date;

/**
 * Created by Zik on 19/02/2018.
 */

public class JadwalSekolah   {
    String sekolah,mataPelajaran,noHub;
    Date waktu;

    public JadwalSekolah(String sekolah, String mataPelajaran, String noHub, Date waktu) {
        this.sekolah = sekolah;
        this.mataPelajaran = mataPelajaran;
        this.noHub = noHub;
        this.waktu = waktu;
    }

    public String getSekolah() {
        return sekolah;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public String getNoHub() {
        return noHub;
    }

    public void setNoHub(String noHub) {
        this.noHub = noHub;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }
}
