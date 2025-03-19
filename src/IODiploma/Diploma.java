package IODiploma;

import ui.ProyectoICAI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Diploma extends JPanel
{

    public Color azul = new Color(81,80,133);

    Image fondo;

    private final ProyectoICAI proyectoICAI;


    public Diploma(ProyectoICAI proyectoICAI)
    {
        this.proyectoICAI = proyectoICAI;
        this.setPreferredSize(new Dimension(700, 565));

        fondo = Toolkit.getDefaultToolkit().getImage("./Resources/diploma.png");

        this.setLayout(null);
        this.setVisible(true);

        JTextField aQuien = new JTextField("Nombre Apellido. Pulsa Enter");
        aQuien.setBounds(350,430,200,30);

        this.add(aQuien);


        repaint();

        JLabel lblNombre = new JLabel(aQuien.getText());
        lblNombre.setForeground(Color.BLACK);
        lblNombre.setFont(new Font("calisto mt",1,20));
        lblNombre.setBounds(350,430,200,30);

        this.add(lblNombre);
        lblNombre.setVisible(false);
        
        JButton btnDescargar = new JButton("Descargar");
        btnDescargar.setBackground(Color.WHITE);
        btnDescargar.setOpaque(false);
        btnDescargar.setFocusable(false);
        btnDescargar.setFont(new Font("calisto mt",1,20));
        btnDescargar.setBounds(400,460,150,27);
        
        this.add(btnDescargar);
        btnDescargar.setVisible(false);

        JLabel lblInfo = new JLabel("Encontraras Mi Diploma en la carpeta del juego.");
        lblInfo.setForeground(Color.RED);
        lblInfo.setFont(new Font("calisto mt",1,11));
        lblInfo.setBounds(350,490,300,20);
        this.add(lblInfo);
        lblInfo.setVisible(false);

        
        
        
        aQuien.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {

                    lblNombre.setText(aQuien.getText());
                    aQuien.setVisible(false);

                    lblNombre.setVisible(true);

                    btnDescargar.setVisible(true);

                    btnDescargar.addActionListener(e1 ->
                    {
                        btnDescargar.setVisible(false);
                        saveImage("Mi Diploma","png");
                        lblInfo.setVisible(true);

                    });

                }
            }
        });
    }

    /**
     *  Este metodo es para descargar la imagen del Diploma y guardarla
     *  en la carpeta del Juego. La imagen antigua se borra y sobreescribe si vuelves a descargar
     *  otra.
     *
     * @param name: Nombre del fichero.
     * @param type: Tipo del fichero. 
     */

    public void saveImage(String name,String type) {
        BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        paint(g2);
        try{
            ImageIO.write(image, type, new File(name+"."+type));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void paintComponent(Graphics g) {


        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this);

    }



}
