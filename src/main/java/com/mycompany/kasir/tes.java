package com.mycompany.kasir;
//@uthor Rafli RD

import javax.swing.JFrame;

public class tes {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Menu Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 900);

        MENU menuPanel = new MENU();
        frame.add(menuPanel);

        frame.setVisible(true);
    }
}
