package domain;

import ui.ProyectoICAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroPanel extends JPanel
{

    public Color azul = new Color(81,80,133);

    Image introfondo;

    private final ProyectoICAI proyectoICAI;


    public IntroPanel(ProyectoICAI proyectoICAI)
    {
        this.proyectoICAI = proyectoICAI;
        this.setPreferredSize(new Dimension(700, 565));

       introfondo = Toolkit.getDefaultToolkit().getImage("./Resources/introfondo.png");

       this.setLayout(null);
        this.setVisible(true);


        JButton btnOk = new JButton();
        btnOk.setIcon(new ImageIcon("./resources/ok.png"));

        btnOk.setFocusable(false);
        btnOk.setBounds(400,400,60,50);
        btnOk.setBackground(Color.WHITE);
        this.add(btnOk);


        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proyectoICAI.panelElegir();
            }
        });


        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {


        g.drawImage(introfondo, 0, 0, this);

    }



}
