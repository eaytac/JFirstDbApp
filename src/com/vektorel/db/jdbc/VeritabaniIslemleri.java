package com.vektorel.db.jdbc;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.vektorel.db.entitiy.Ogrenci;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;

public class VeritabaniIslemleri implements IVeritabaniIslemleri {

    private static final String sunucuAdresi = "localhost";
    private static final String port = "5432";
    private static final String kullaniciAdi = "postgres";
    private static final String kullaniciSifre = "postgres";
    private static final String veritabani = "vektorel";
    /**
     * 1. Veritabanına bağlan 
     * 2. Sorguyu gönder
     * 3. Cevabı al
     * 4. Bğlantıyı sonlandır
     */
    
    @Override
    public boolean kayitEkle(String query) {
        
        try {
            Connection connection = baglantiVer();
            if (connection != null){
                PreparedStatement statement = connection.prepareStatement(query);
                int dbSonuc = statement.executeUpdate();
                connection.close();
            
                if (dbSonuc>0)
                    return true;
                else
                    return false;
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean kayitSil(String query) {
      
        try {
            Connection connection = baglantiVer();
            if (connection != null){
                PreparedStatement statement = connection.prepareStatement(query);
                int dbSonuc = statement.executeUpdate();
                connection.close();
            
                if (dbSonuc>0)
                    return true;
                else
                    return false;
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean kayitGuncelle(String query) {
    
        try {
            Connection connection = baglantiVer();
            if (connection != null){
                PreparedStatement statement = connection.prepareStatement(query);
                int dbSonuc = statement.executeUpdate();
                connection.close();
            
                if (dbSonuc>0)
                    return true;
                else
                    return false;
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Ogrenci> kayitGetir(String query) {
        
        try {
            Connection connection = baglantiVer();
            if (connection != null){
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                List<Ogrenci> list = new ArrayList<>();
                
                while(resultSet.next()){
                    Ogrenci o = new Ogrenci();
                    o.setId(resultSet.getLong("id"));
                    o.setAd(resultSet.getString("ad"));
                    o.setSoyad(resultSet.getString("soyad"));
                    o.setBolum_adi(resultSet.getString("bolum_adi"));
                    o.setOkul_no(resultSet.getString("okul_no"));
                    o.setYas(resultSet.getInt("yas"));
                    list.add(o);
                }
                    
                connection.close();
                
                return list;
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private Connection baglantiVer(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + sunucuAdresi + ":" + port + "/" + veritabani;
            Connection connection = DriverManager.getConnection(url, kullaniciAdi, kullaniciSifre);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
