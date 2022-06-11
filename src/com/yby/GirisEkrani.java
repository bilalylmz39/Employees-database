package com.yby;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GirisEkrani extends JFrame{

    CalisanIslemleri calisanIslemleri = new CalisanIslemleri();



    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton girişYapButton;
    private JLabel mesajAlani;

    public GirisEkrani() {

        add(panel1);
        setSize(500,500);
        setTitle("Veri Tabanı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        girişYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mesajAlani.setText("");
                String kullanici_adi = textField1.getText();

                String parola = new String(passwordField1.getPassword());

                boolean girisbasarili = calisanIslemleri.girisYap(kullanici_adi,parola);

                if (girisbasarili) {
                    CalisanEkrani calisanEkrani = new CalisanEkrani(this,true);
                    setVisible(false);

                    calisanEkrani.setVisible(true);
                    System.exit(0);

                }else {
                    mesajAlani.setText("Giriş başarısız lütfen tekrar deneyin...");
                }


                calisanIslemleri.girisYap(kullanici_adi,parola);

            }
        });
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }





    }


}
