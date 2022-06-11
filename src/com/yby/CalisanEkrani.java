package com.yby;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class CalisanEkrani extends JDialog {

    DefaultTableModel model;
    CalisanIslemleri islemler = new CalisanIslemleri();



    private JPanel contentPane;
    private JTable table1;
    private JButton buttonOK;

    private JTable calisantablosu;



    public CalisanEkrani(ActionListener actionListener, boolean b) {
        add(contentPane);
JTableHeader jt = new JTableHeader();
String[] header = {"id","ad"};
jt.getHeaderRect(5);

        setSize(400,400);
        setVisible(true);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        model = (DefaultTableModel) calisantablosu.getModel();
        CalisanGoruntule();

    }

    public void CalisanGoruntule() {


        model.setRowCount(0);

        ArrayList<Calisan> calisanlar = new ArrayList<>();

         calisanlar = islemler.calisanlariGetir();

         if (calisanlar != null) {
             for (Calisan calisan: calisanlar) {
                 Object[] eklenecek = {calisan.getId(), calisan.getAd(), calisan.getSoyad(), calisan.getDepartman(), calisan.getMaas()};
                 model.addRow(eklenecek);

             }


             }
         }



    public void main(String[] args) {
        CalisanEkrani dialog = new CalisanEkrani((ActionListener) this, true);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    
    
}
