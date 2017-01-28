
package com.vektorel.db.entitiy;

public class Ogrenci {
    
    String ad;
    String soyad;
    int yas;
    String okul_no;
    String bolum_adi;
    Long id;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getOkul_no() {
        return okul_no;
    }

    public void setOkul_no(String okul_no) {
        this.okul_no = okul_no;
    }

    public String getBolum_adi() {
        return bolum_adi;
    }

    public void setBolum_adi(String bolum_adi) {
        this.bolum_adi = bolum_adi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ogrenci{" + "ad=" + ad + ", soyad=" + soyad + ", yas=" + yas + ", okul_no=" + okul_no + ", bolum_adi=" + bolum_adi + ", id=" + id + '}';
    }
}
