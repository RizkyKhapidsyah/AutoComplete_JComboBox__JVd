package com.rk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class Listenerr extends KeyAdapter {

    JComboBox comboBox;
    Vector list;

    public Listenerr(JComboBox comboBox, Vector list) {
        this.comboBox = comboBox;
        this.list = list;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                String text = ((JTextField) e.getSource()).getText();

                comboBox.setModel(new DefaultComboBoxModel(dapatkanDaftarFilter(text)));
                comboBox.setSelectedIndex(-1);
                ((JTextField) comboBox.getEditor().getEditorComponent()).setText(text);
                comboBox.showPopup();
            }
        });
    }

    public Vector dapatkanDaftarFilter(String text) {
        Vector listResult = new Vector();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().startsWith(text)) {
                listResult.add(list.get(i).toString());
            }
        }

        return listResult;
    }
}
