package com.elkha.zik.sakuguru;

/**
 * Created by Zik on 02/03/2018.
 */

public class dataJadwal {
    int id;
    String jadwal_date,jadwal_tempat,jadwal_ruangan,jadwal_Pelajaran,jadwal_waktu,jadwal_noHub,jadwal_alasan;
    boolean izin_existed,jadwal_pengulangan,jadwal_kehadiran;

    public dataJadwal() {
    }

    public dataJadwal(int id, String jadwal_date, String jadwal_tempat,String jadwal_ruangan, String jadwal_Pelajaran,
                      String jadwal_waktu, String jadwal_noHub, boolean izin_existed, boolean jadwal_pengulangan) {
        this.id = id;
        this.jadwal_date = jadwal_date;
        this.jadwal_tempat = jadwal_tempat;
        this.jadwal_ruangan=jadwal_ruangan;
        this.jadwal_Pelajaran = jadwal_Pelajaran;
        this.jadwal_waktu = jadwal_waktu;
        this.jadwal_noHub = jadwal_noHub;
        this.izin_existed = izin_existed;
        this.jadwal_pengulangan = jadwal_pengulangan;
    }
    public dataJadwal(int id, String jadwal_date, String jadwal_tempat,String jadwal_ruangan, String jadwal_Pelajaran, String jadwal_waktu, boolean jadwal_pengulangan) {
        this.id = id;
        this.jadwal_date = jadwal_date;
        this.jadwal_tempat = jadwal_tempat;
        this.jadwal_ruangan=jadwal_ruangan;
        this.jadwal_Pelajaran = jadwal_Pelajaran;
        this.jadwal_waktu = jadwal_waktu;
        this.jadwal_pengulangan = jadwal_pengulangan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJadwal_date(String jadwal_date) {
        this.jadwal_date = jadwal_date;
    }

    public void setJadwal_tempat(String jadwal_tempat) {
        this.jadwal_tempat = jadwal_tempat;
    }

    public void setJadwal_Pelajaran(String jadwal_Pelajaran) {
        this.jadwal_Pelajaran = jadwal_Pelajaran;
    }

    public void setJadwal_waktu(String jadwal_waktu) {
        this.jadwal_waktu = jadwal_waktu;
    }

    public void setJadwal_noHub(String jadwal_noHub) {
        this.jadwal_noHub = jadwal_noHub;
    }

    public void setJadwal_alasan(String jadwal_alasan) {
        this.jadwal_alasan = jadwal_alasan;
    }

    public void setIzin_existed(boolean izin_existed) {
        this.izin_existed = izin_existed;
    }

    public void setJadwal_pengulangan(boolean jadwal_pengulangan) {
        this.jadwal_pengulangan = jadwal_pengulangan;
    }

    public void setJadwal_kehadiran(boolean jadwal_kehadiran) {
        this.jadwal_kehadiran = jadwal_kehadiran;
    }

    public String getJadwal_ruangan() {
        return jadwal_ruangan;
    }

    public void setJadwal_ruangan(String jadwal_ruangan) {
        this.jadwal_ruangan = jadwal_ruangan;
    }

    public int getId() {
        return id;
    }

    public String getJadwal_date() {
        return jadwal_date;
    }

    public String getJadwal_tempat() {
        return jadwal_tempat;
    }

    public String getJadwal_Pelajaran() {
        return jadwal_Pelajaran;
    }

    public String getJadwal_waktu() {
        return jadwal_waktu;
    }

    public String getJadwal_noHub() {
        return jadwal_noHub;
    }

    public String getJadwal_alasan() {
        return jadwal_alasan;
    }

    public boolean isIzin_existed() {
        return izin_existed;
    }

    public boolean isJadwal_pengulangan() {
        return jadwal_pengulangan;
    }

    public boolean isJadwal_kehadiran() {
        return jadwal_kehadiran;
    }
}
