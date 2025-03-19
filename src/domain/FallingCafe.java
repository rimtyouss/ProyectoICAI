package domain;

import ui.ProyectoICAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class FallingCafe extends JPanel {

    ProyectoICAI proyectoICAI;
    Image fondo;
    JButton btnJugar = new JButton("Jugar");

    public FallingCafe(ProyectoICAI proyectoICAI) {
        this.proyectoICAI = proyectoICAI;
        this.setPreferredSize(new Dimension(700, 565));

        fondo = Toolkit.getDefaultToolkit().getImage("./Resources/fallingcafe.png");
        this.setLayout(null);
        this.setVisible(true);



        btnJugar.setBackground(Color.ORANGE);
        btnJugar.setFont(new Font("calisto mt", 1, 20));
        btnJugar.setBounds(326, 466, 100, 50);
        btnJugar.setFocusable(false);
        btnJugar.setOpaque(false);

        btnJugar.setVisible(true);
        this.add(btnJugar);



    }

    @Override
    public void paintComponent(Graphics g) {


        g.drawImage(fondo, 0, 0, this);

    }

    public static class FallingCafeChica extends FallingCafe
    {
        public FallingCafeChica(ProyectoICAI proyectoICAI)
        {
            super(proyectoICAI);

            btnJugar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.panelPasilloChica();
                }
            });
        }
    }

    public static class FallingCafeChico extends FallingCafe
    {
        public FallingCafeChico(ProyectoICAI proyectoICAI)
        {
            super(proyectoICAI);

            btnJugar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.panelPasilloChico();
                }
            });
        }
    }

}