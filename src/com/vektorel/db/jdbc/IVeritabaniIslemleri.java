package com.vektorel.db.jdbc;

import com.vektorel.db.entitiy.Ogrenci;
import java.util.List;

public interface IVeritabaniIslemleri {
   
    boolean kayitEkle(String query);
    
    boolean kayitSil(String query);
    
    boolean kayitGuncelle(String query);
    
    List<Ogrenci> kayitGetir(String query);
    
}
