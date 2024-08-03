package com.example.recycleviemcardview;

public class Siswa {
    private String nama;
    private String alamat;

    public Siswa(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getnama() {
        return nama;
    }

    public void setnama(String nama) {
        this.alamat = nama;

    } public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
