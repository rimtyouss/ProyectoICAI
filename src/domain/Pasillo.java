package domain;

import ui.ProyectoICAI;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class Pasillo extends JPanel {


    Image cafe = new ImageIcon("./resources/cafe.png").getImage();

    int x_avatar, y_avatar;
    int x_cafe, y_cafe;
    Random rand = new Random();

    JLabel time;
    JLabel points;

    int pointsCount = 0;
    int timeleft = 59;
    int counter = 0;

    boolean gameOver = false;

    protected ProyectoICAI proyectoICAI;

    ImageIcon imgScore = new ImageIcon("./resources/score.png");



    Image fondoPasillo;

    public Pasillo(ProyectoICAI proyectoICAI) {
        this.proyectoICAI = proyectoICAI;

        inicializar();
    }

    public void inicializar() {


        this.setPreferredSize(new Dimension(700, 565));
        fondoPasillo = Toolkit.getDefaultToolkit().getImage("./Resources/fondoPasillo.png");
        this.setLayout(null);


        x_avatar = 10;
        y_avatar = 368;

        x_cafe = rand.nextInt(1000);
        y_cafe = 0;

        time = new JLabel("Tiempo : 59");
        time.setBounds(20, 10, 70, 20); //setting the time label on screen

        points = new JLabel("Puntos : 0");
        points.setBounds(100, 10, 100, 20);

        add(time);
        add(points);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyCode() == KeyEvent.VK_LEFT & x_avatar > 10) {
                    x_avatar -= 15;
                    repaint();
                }
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT & x_avatar < 1000) {
                    x_avatar += 15;
                    repaint();
                }
            }//end keypressed
        });

    }

    /**
     *  Este metodo es para, cuando se haya caido un cafe,
     * poner la coordenada del siguiente cafe a 0, y randomizar las caidas.
     *
     */

    void fallCafe() {
        if (y_cafe >= 500) { //cuando un cafe haya caido
            y_cafe = 0;   //poner la coordenada del siguiente cafe a 0
            x_cafe = rand.nextInt(1000); // random cafes cayendo
        } else
            y_cafe++; //sino seguir para abajo
    }

    void updateTime() {
        counter++;
        if (counter == 110) //contar hasta 60 y hacerlo + lento
        {
            timeleft--;
            counter = 0;
        }
        time.setText("Tiempo :" + timeleft);
    }

    /**
     *  Este metodo es para cuando nuestro avatar colisiona con un cafe,
     * que desaparezca el cafe y ademas añadir 5 pountos al score.
     *
     */

    void detectCollision() {
        Rectangle avatarRect = new Rectangle(x_avatar, y_avatar, 100, 65); //making a rectangle on the basket
        Rectangle cafeRect = new Rectangle(x_cafe, y_cafe, 45, 67); //making a rectangle on egg

        if (cafeRect.intersects(avatarRect)) {
            pointsCount += 5;
            points.setText("Puntos:" + pointsCount);
            y_cafe = 0;
            x_cafe = rand.nextInt(1000);
            musica("Resources/beber.wav");
        }
    }


    public static class PasilloChico extends Pasillo
    {
        Image avatar =  new ImageIcon("./resources/chico.png").getImage();

        public PasilloChico(ProyectoICAI proyectoICAI)
        {
            super(proyectoICAI);
        }

        void checkGameOver() {
            if (timeleft <= 0) {

                JLabel yourScore = new JLabel("" + pointsCount);
                JLabel lblScore = new JLabel(imgScore);

                lblScore.setBounds(200,200,230,80);
                lblScore.setOpaque(false);

                yourScore.setBounds(300, 300, 200, 100);
                gameOver = true;
                yourScore.setFont(new Font("calisto mt", 1, 100));
                yourScore.setForeground(Color.BLACK);


                this.add(lblScore);
                this.add(yourScore);

                if (pointsCount >= 30) {

                    JButton pasar = new JButton(" Pasar al siguiente curso ");
                    pasar.setBackground(Color.ORANGE);
                    pasar.setFont(new Font("calisto mt", 1, 20));
                    pasar.setBounds(400, 400, 250, 50);

                    pasar.setVisible(true);
                    this.add(pasar);

                    pasar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            proyectoICAI.panelNivel2Chico();
                        }
                    });
                } else {
                    proyectoICAI.panelGameOverPasillo();


                }
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(fondoPasillo, 0, 0, null); //game background

            checkGameOver();

            if (gameOver == false) {
                setFocusable(true);
                grabFocus();
                updateTime();

                fallCafe();
                detectCollision();

                g2d.drawImage(cafe, x_cafe, y_cafe, null); //drawing egg at new position
                g2d.drawImage(avatar, x_avatar, y_avatar, null); //drawing basket

            }
            repaint();
        }


    }

    public static class PasilloChica extends Pasillo
    {
        Image avatar =  new ImageIcon("./resources/chica.png").getImage();

        public PasilloChica(ProyectoICAI proyectoICAI)
        {
            super(proyectoICAI);

        }

        void checkGameOver() {
            if (timeleft <= 0) {

                JLabel yourScore = new JLabel("" + pointsCount);
                JLabel lblScore = new JLabel(imgScore);

                lblScore.setBounds(200,200,230,80);
                lblScore.setOpaque(false);

                yourScore.setBounds(300, 300, 200, 100);
                gameOver = true;
                yourScore.setFont(new Font("calisto mt", 1, 100));
                yourScore.setForeground(Color.BLACK);


                this.add(lblScore);
                this.add(yourScore);

                if (pointsCount >= 30) {

                    JButton pasar = new JButton(" Pasar al siguiente curso ");
                    pasar.setBackground(Color.ORANGE);
                    pasar.setFont(new Font("calisto mt", 1, 20));
                    pasar.setBounds(400, 400, 250, 50);

                    pasar.setVisible(true);
                    this.add(pasar);

                    pasar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            proyectoICAI.panelNivel2Chica();
                        }
                    });
                } else {
                    proyectoICAI.panelGameOverPasillo();


                }
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(fondoPasillo, 0, 0, null); //game background

            checkGameOver();

            if (gameOver == false) {
                setFocusable(true);
                grabFocus();
                updateTime();

                fallCafe();
                detectCollision();

                g2d.drawImage(cafe, x_cafe, y_cafe, null); //drawing egg at new position
                g2d.drawImage(avatar, x_avatar, y_avatar, null); //drawing basket

            }
            repaint();
        }


    }

    /**
     *  Este metodo es para poner musica de fondo.
     *
     * @param m : que seria el path del fichero mucisca
     *
     */
    public void musica(String m)
    {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(m).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(1);
        }
        catch
        (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error musica.");
        }
    }


}
