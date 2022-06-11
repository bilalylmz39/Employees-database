package com.yby;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CalisanIslemleri {
    private Connection con = null;

    private Statement statement = null;
    private PreparedStatement preparedStatement = null;


    public ArrayList<Calisan> calisanlariGetir() {

        ArrayList<Calisan> cikti = new ArrayList<>();

        try {
            statement = con.createStatement();
            String sorgu = "Select * From calisanlar";

            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String dept = rs.getString("departman");
                String maas = rs.getString("maas");

                cikti.add(new Calisan(id,ad,soyad,dept,maas));
            }
            return cikti;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }

    public boolean girisYap(String kullanici_adi,String parola) {

         String sorgu = "Select * From adminler where username = ? and password = ?";
        try {
            preparedStatement = con.prepareStatement(sorgu);

            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2,parola);

            ResultSet rs = preparedStatement.executeQuery();
           return rs.next();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }


    }
    public CalisanIslemleri() {

       String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi + "?useUnicode=true&character";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(url,Database.kullanici_adi,Database.parola);

            System.out.println("Bağlantı başarılı...");
        } catch (SQLException throwables) {
            System.out.println("Bağlantı başarısız...");
        }
    }
public static void main(String[] args) {

        CalisanIslemleri islemleri = new CalisanIslemleri();



    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {

            GirisEkrani girisEkrani = new GirisEkrani();
            girisEkrani.setVisible(true);
        }
    });


}

}
