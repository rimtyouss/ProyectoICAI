package domain;

import ui.ProyectoICAI;

import javax.swing.*;
import java.awt.*;

public class GameOverPasillo extends JPanel {

    ProyectoICAI proyectoICAI;
    Image fondo;

    public GameOverPasillo(ProyectoICAI proyectoICAI) {
        this.proyectoICAI = proyectoICAI;
        this.setPreferredSize(new Dimension(700, 565));

        fondo = Toolkit.getDefaultToolkit().getImage("./Resources/gameOverPasillo.png");
        this.setLayout(null);
        this.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {


        g.drawImage(fondo, 0, 0, this);

    }

}