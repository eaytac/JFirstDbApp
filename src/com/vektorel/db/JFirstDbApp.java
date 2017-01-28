package com.vektorel.db;

import com.vektorel.db.entitiy.Ogrenci;
import com.vektorel.db.jdbc.VeritabaniIslemleri;
import java.util.List;

public class JFirstDbApp {

    public static void main(String[] args) {
        System.out.println("Uygulama başlatılıyor.");
        
        VeritabaniIslemleri veritabaniIslemleri = new VeritabaniIslemleri();
        String query = "insert into ogrenci (ad, soyad, yas, okul_no, bolum_adi, id)\n values ('Emre', 'Aytaç', 36, 'E1030410000', 'İnşaat Mühendisliği', 7);";
        boolean islemSonuc = veritabaniIslemleri.kayitEkle(query);
        if (islemSonuc)
            System.out.println("Kayıt Eklendi");
        else
            System.out.println("Bir hata oluştu!");
        
        boolean guncellemeSonuc = veritabaniIslemleri.kayitGuncelle("update ogrenci set ad='Kutlu' where id=5");
        if (guncellemeSonuc)
            System.out.println("Kayıt Güncellendi");
        else
            System.out.println("Bir hata oluştu!");
        
        List<Ogrenci> ogrenciListesi = veritabaniIslemleri.kayitGetir("select * from ogrenci");
        
        for (Ogrenci ogrenci : ogrenciListesi) {
            System.out.println(ogrenci.toString());
            
        }
    
        System.out.println("Uygulama sonlandı.");
    }
    
}
