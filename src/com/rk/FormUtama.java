package com.rk;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class FormUtama extends JFrame {

    String binatang[] = {
            "Burung",
            "Babi",
            "Buaya",
            "Banteng",
            "Kucing",
            "Kecoa",
            "Komodo",
            "Sapi"
    };

    Vector listBinatang = new Vector();
    JComboBox comboBox;

    public FormUtama() {
        super("Auto Complete Filter List");
        Inisialisasi_Komponen();
    }

    private void Inisialisasi_Komponen() {
        aturVektor();

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(listBinatang));
        comboBox.setSelectedIndex(-1);
        comboBox.setEditable(true);

        JTextField textField = (JTextField) comboBox.getEditor().getEditorComponent();
        textField.setFocusable(true);
        textField.setText("");
        textField.addKeyListener(new Listenerr(comboBox, listBinatang));

        getContentPane().add(comboBox, BorderLayout.NORTH);
        setPreferredSize(new Dimension(300, 200));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void aturVektor() {
        for (int i = 0; i < binatang.length; i++) {
            listBinatang.add(binatang[i]);
        }
    }
}
