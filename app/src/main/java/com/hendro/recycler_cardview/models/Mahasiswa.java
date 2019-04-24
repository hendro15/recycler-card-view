package com.hendro.recycler_cardview.models;

import java.util.List;

public class Mahasiswa {
    private String nama;
    private String instansi;
    private List<Study> riwayatStudy;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public List<Study> getRiwayatStudy() {
        return riwayatStudy;
    }

    public void setRiwayatStudy(List<Study> riwayatStudy) {
        this.riwayatStudy = riwayatStudy;
    }
}
