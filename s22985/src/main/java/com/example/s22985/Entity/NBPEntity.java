package com.example.s22985.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NBPEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String waluta;
    private String dataPoczatkowa;
    private String dataKoncowa;
    private float kursZlota;
    private String kiedyWykonano;

    public NBPEntity(String waluta, String dataPoczatkowa, String dataKoncowa, float kursZlota, String kiedyWykonano) {
        this.waluta = waluta;
        this.dataPoczatkowa = dataPoczatkowa;
        this.dataKoncowa = dataKoncowa;
        this.kursZlota = kursZlota;
        this.kiedyWykonano = kiedyWykonano;
    }

    public NBPEntity() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getWaluta() {
        return waluta;
    }

    public String getDataPoczatkowa() {
        return dataPoczatkowa;
    }

    public String getDataKoncowa() {
        return dataKoncowa;
    }

    public float getKursZlota() {
        return kursZlota;
    }

    public String getkiedyWykonano() {
        return kiedyWykonano;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public void setDataPoczatkowa(String dataPoczatkowa) {
        this.dataPoczatkowa = dataPoczatkowa;
    }

    public void setDataKoncowa(String dataKoncowa) {
        this.dataKoncowa = dataKoncowa;
    }

    public void setKursZlota(float kursZlota) {
        this.kursZlota = kursZlota;
    }

    public void setkiedyWykonano(String kiedyWykonano) {
        this.kiedyWykonano = kiedyWykonano;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", waluta='" + waluta + '\'' +
                ", dataPoczatkowa='" + dataPoczatkowa + '\'' +
                ", dataKoncowa='" + dataKoncowa + '\'' +
                ", kursZlota=" + kursZlota +
                ", kiedyWykonano='" + kiedyWykonano + '\'' +
                '}';
    }
}


