package com.example.sqlitedatabase;

public class Barang {
    String idbarang, barang, stok, harga;

    public Barang(String barang, String harga, String idbarang, String stok) {
        this.barang = barang;
        this.harga = harga;
        this.idbarang = idbarang;
        this.stok = stok;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }
}
