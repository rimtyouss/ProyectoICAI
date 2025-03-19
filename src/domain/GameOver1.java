package domain;

import ui.ProyectoICAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver1 extends JPanel
{


    public GameOver1(ProyectoICAI proyectoICAI)
    {

        JPanel panelGO = new JPanel();
        panelGO.setLayout(new BorderLayout());


        ImageIcon email = new ImageIcon("./resources/e-mail.png");
        JLabel lblEmail = new JLabel(email);

        panelGO.add(lblEmail,BorderLayout.CENTER);


        JButton btnAbrir = new JButton( " Abrir ");
        btnAbrir.setFocusable(false);
        btnAbrir.setBackground(new Color(251, 199, 98));
        btnAbrir.setOpaque(false);


        panelGO.add(btnAbrir,BorderLayout.SOUTH);

        panelGO.setBackground(Color.GRAY);
        this.add(panelGO);


        btnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                proyectoICAI.gameOver2();
            }
        });


    }



}
