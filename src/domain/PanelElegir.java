package domain;

import ui.ProyectoICAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelElegir extends JPanel
{


    private final Image fondoElegir;

    protected ProyectoICAI proyectoICAI;




    public PanelElegir(ProyectoICAI proyectoICAI)
    {
        super();

        this.setPreferredSize(new Dimension(700, 565));

        fondoElegir = Toolkit.getDefaultToolkit().getImage("resources/fondoElegir.png").getScaledInstance(700, 565, Image.SCALE_SMOOTH);
        this.setLayout(null);


       JButton btnChica = new JButton();
       btnChica.setIcon(new ImageIcon("./resources/chica.png"));
       btnChica.setFocusable(false);
       btnChica.setOpaque(false);
        btnChica.setBackground(Color.WHITE);
        btnChica.setBounds(200,300,100,210);
        btnChica.setBorder(null);

        JButton btnChico = new JButton();
        btnChico.setIcon(new ImageIcon("./resources/chico.png"));
        btnChico.setFocusable(false);
        btnChico.setOpaque(false);
        btnChico.setBackground(Color.WHITE);
        btnChico.setBorder(null);
        btnChico.setBounds(400,300,100,210);

       this.add(btnChica);
       this.add(btnChico);


        btnChica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proyectoICAI.panelNivel1Chica();
            }
        });


        btnChico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proyectoICAI.panelNivel1Chico();
            }
        });


        repaint();




    }

    @Override
    public void paintComponent(Graphics g) {


        g.drawImage(fondoElegir, 0, 0, this);

    }


}
