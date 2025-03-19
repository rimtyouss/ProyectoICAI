package domain;

import ui.ProyectoICAI;

import javax.swing.*;
import java.awt.*;

public class GameOver2 extends JPanel
{


    public GameOver2(ProyectoICAI proyectoICAI)
    {

        JPanel panelGO = new JPanel();
        panelGO.setLayout(new BorderLayout());


        ImageIcon correo = new ImageIcon("./resources/correo.png");
        JLabel lblCorreo = new JLabel(correo);

        panelGO.add(lblCorreo,BorderLayout.SOUTH);


        panelGO.setBackground(Color.GRAY);
        this.add(panelGO);

    }



}
