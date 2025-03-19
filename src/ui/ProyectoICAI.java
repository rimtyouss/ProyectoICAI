package ui;

import IODiploma.Diploma;
import domain.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ProyectoICAI extends JFrame {

    private final IntroPanel introPanel = new IntroPanel(this);
    private final GameOver1 go1 = new GameOver1(this);
    private final GameOver2 go2 = new GameOver2(this);
    private final NivelChica.Nivel1 nivel1Chica = new NivelChica.Nivel1(this);
    private final NivelChica.Nivel1.Nivel2 nivel2Chica = new NivelChica.Nivel1.Nivel2(this);

    private final NivelChico.Nivel1 nivel1Chico = new NivelChico.Nivel1(this);
    private final NivelChico.Nivel1.Nivel2 nivel2Chico = new NivelChico.Nivel1.Nivel2(this);

    private final PanelElegir elegir = new PanelElegir(this);

    private final Pasillo.PasilloChica pasilloChica = new Pasillo.PasilloChica(this);
    private final Pasillo.PasilloChico pasilloChico = new Pasillo.PasilloChico(this);


    private final FallingCafe.FallingCafeChica fallingCafeChica = new FallingCafe.FallingCafeChica(this);
    private final FallingCafe.FallingCafeChico fallingCafeChico = new FallingCafe.FallingCafeChico(this);

    private final GameOverPasillo gameOverPasillo = new GameOverPasillo(this);

    private final Diploma diploma = new Diploma(this);

    public JButton btnStart = new JButton();
    public Color azul = new Color(81, 80, 133);


    JPanel panelPrincipal = new JPanel();


    public static void main(String[] args) {
        ProyectoICAI ventana = new ProyectoICAI();
        ventana.setVisible(true);
    }

    public ProyectoICAI() {
        super("Project ICAI");
        this.setTitle(" Project ICAI ");
        this.setSize(700, 565);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setBackground(azul);


        inicializarComponentes();
        musica("Resources/musica.wav",20);


    }

    public void inicializarComponentes() {

        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(81, 80, 133));
        setLocationRelativeTo(null);
        this.setBackground(new Color(81, 80, 133));

        // NORTE
        ImageIcon imgPaginaPrincipal = new ImageIcon("./Resources/princip.png");
        JLabel labelPrincipal = new JLabel(imgPaginaPrincipal);
        panelPrincipal.add(labelPrincipal, BorderLayout.CENTER);

        // BOTON

        JPanel panelStart = new JPanel();
        panelStart.setBackground(azul);
        panelStart.setLayout(new GridLayout(2, 3));
        panelStart.setBounds(355, 472, 50, 70);

        btnStart.setIcon(new ImageIcon("resources/st.png"));
        btnStart.setFocusable(false);
        btnStart.setOpaque(false);
        btnStart.setPreferredSize(new Dimension(282, 56));
        btnStart.setFocusPainted(false);
        btnStart.setBackground(new Color(251, 199, 98));
        btnStart.setBorder(null);


        panelStart.add(btnStart);
        panelPrincipal.add(panelStart, BorderLayout.SOUTH);
        this.add(panelPrincipal);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.setVisible(false);
                introPanel.setVisible(true);


            }
        });


        this.add(introPanel);
        this.add(elegir);

        this.add(nivel1Chica);
        this.add(nivel2Chica);
        this.add(fallingCafeChica);
        this.add(pasilloChica);


        this.add(nivel1Chico);
        this.add(nivel2Chico);
        this.add(pasilloChico);
        this.add(fallingCafeChico);


        this.add(go1);
        this.add(go2);

        this.add(gameOverPasillo);

        this.add(diploma);


    }


    public void panelElegir() {
        introPanel.setVisible(false);
        elegir.setVisible(true);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        diploma.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.elegir.requestFocus();

    }


    public void panelNivel1Chica() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(true);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        go1.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        diploma.setVisible(false);
        go2.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.nivel1Chica.requestFocus();


    }

    public void panelNivel2Chica() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(true);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        go1.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        go2.setVisible(false);
        setSize(700, 565);
        diploma.setVisible(false);
        this.setLocationRelativeTo(null);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        this.nivel2Chica.requestFocus();
        nivel2Chica.cambiarCreditos("18");

    }

    public void panelNivel1Chico() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(true);
        nivel2Chico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        go1.setVisible(false);
        diploma.setVisible(false);
        go2.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.nivel1Chico.requestFocus();


    }

    public void panelNivel2Chico() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(true);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        go1.setVisible(false);
        diploma.setVisible(false);
        go2.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.nivel2Chico.requestFocus();
        nivel2Chico.cambiarCreditos("18");

    }


    public void gameOver1() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        diploma.setVisible(false);
        go1.setVisible(true);
        go2.setVisible(false);
        setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.go1.requestFocus();
        this.pack();
    }

    public void gameOver2() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        diploma.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(true);
        setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.go2.requestFocus();
        this.pack();

    }

    public void panelFallingCafeChica() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        fallingCafeChica.setVisible(true);
        fallingCafeChico.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(false);
        diploma.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.fallingCafeChico.requestFocus();

    }

    public void panelFallingCafeChico() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(true);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(false);
        diploma.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.fallingCafeChica.requestFocus();

    }

    public void panelPasilloChica() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        pasilloChica.setVisible(true);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(false);
        diploma.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.pasilloChica.requestFocus();

    }

    public void panelPasilloChico() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(true);
        gameOverPasillo.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(false);
        diploma.setVisible(false);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.pasilloChica.requestFocus();

    }

    public void panelGameOverPasillo() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(false);
        diploma.setVisible(false);
        gameOverPasillo.setVisible(true);
        this.setLocationRelativeTo(null);
        this.gameOverPasillo.requestFocus();

    }

    public void panelDiploma() {
        introPanel.setVisible(false);
        elegir.setVisible(false);
        nivel1Chica.setVisible(false);
        nivel2Chica.setVisible(false);
        nivel1Chico.setVisible(false);
        nivel2Chico.setVisible(false);
        fallingCafeChica.setVisible(false);
        fallingCafeChico.setVisible(false);
        pasilloChica.setVisible(false);
        pasilloChico.setVisible(false);
        gameOverPasillo.setVisible(false);
        go1.setVisible(false);
        go2.setVisible(false);
        diploma.setVisible(true);
        setSize(700, 565);
        this.setLocationRelativeTo(null);
        this.diploma.requestFocus();
    }


    public void musica(String m,int loop) {

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(m).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(loop);
        } catch
        (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error musica.");
        }
    }
}










