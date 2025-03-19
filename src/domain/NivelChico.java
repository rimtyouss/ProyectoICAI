package domain;

import ui.ProyectoICAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class NivelChico extends JPanel {

    public Color azul = new Color(81, 80, 133);


    public int fe = 2024;
    public int cr = 0;

    JLabel creditos = new JLabel(String.valueOf(cr));
    JLabel fecha = new JLabel(String.valueOf(fe));


    protected JButton btnAbrir1 = new JButton();
    protected JButton btnAbrir2 = new JButton();
    protected JButton btnAbrir3 = new JButton();

    protected Font font = new Font("calisto mt", 1, 20);
    protected Font font1 = new Font("calisto mt", 1, 50);
    protected Font font2 = new Font("calisto mt", 1, 35);

    protected Alumno.Chico chico;

    // protected src.domain.Alumno.Chico chico;

    int fy = 365;
    int fx = 45;



    Image fondo;

    protected ProyectoICAI proyectoICAI;


    public NivelChico(ProyectoICAI proyectoICAI) {
        this.proyectoICAI = proyectoICAI;

        this.setPreferredSize(new Dimension(700, 565));

        fondo = Toolkit.getDefaultToolkit().getImage("resources/fondo.png").getScaledInstance(700, 565, Image.SCALE_SMOOTH);


        setLayout(null);

        creditos.setFont(font2);
        creditos.setPreferredSize(new Dimension(100, 100));
        creditos.setBounds(645, 20, 50, 50);

        fecha.setFont(font);
        fecha.setPreferredSize(new Dimension(100, 100));
        fecha.setBounds(143, 43, 50, 50);



        this.add(fecha, BorderLayout.NORTH);
        this.add(creditos, BorderLayout.SOUTH);



        ImageIcon puerta = new ImageIcon("./Resources/puerta.png");
        btnAbrir1.setIcon(puerta);
        btnAbrir1.setOpaque(false);
        btnAbrir1.setBounds(72, 384, 20, 20);

        this.add(btnAbrir1);
        btnAbrir1.setEnabled(false);


        btnAbrir2.setIcon(puerta);
        btnAbrir2.setOpaque(false);
        btnAbrir2.setBounds(315, 386, 20, 20);

        this.add(btnAbrir2);
        btnAbrir2.setEnabled(false);

        btnAbrir3.setIcon(puerta);
        btnAbrir3.setOpaque(false);
        btnAbrir3.setBounds(565, 387, 20, 20);

        this.add(btnAbrir3);
        btnAbrir3.setEnabled(false);

        chico = new Alumno.Chico(10, 368);

        fx = chico.getX();
        fy = chico.getY();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (chico.getX() >= 0)
                    {
                        fx -= 10;
                        fy = 368;
                        //365
                        chico.setX(fx);
                        chico.setY(fy);

                        if(chico.getX() == 40)
                        {

                            chico.setY(fy-50);
                            btnAbrir1.setEnabled(true);

                        }
                        else{btnAbrir1.setEnabled(false);}


                        if(chico.getX() == 300)
                        {

                            chico.setY(fy-50);
                            btnAbrir2.setEnabled(true);

                        }
                        else{btnAbrir2.setEnabled(false);}

                        if(chico.getX() == 520)
                        {

                            chico.setY(fy-50);
                            btnAbrir3.setEnabled(true);
                        }
                        else{btnAbrir3.setEnabled(false);}
                        repaint();
                    }

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (chico.getX() <= 600)
                    {
                        fx += 10;
                        fy = 368;
                        chico.setX(fx);
                        chico.setY(fy);

                        if(chico.getX() == 40)
                        {

                            chico.setY(fy-50);
                            btnAbrir1.setEnabled(true);

                        }
                        else{btnAbrir1.setEnabled(false);}


                        if(chico.getX() == 300)
                        {

                            chico.setY(fy-50);
                            btnAbrir2.setEnabled(true);

                        }
                        else{btnAbrir2.setEnabled(false);}

                        if(chico.getX() == 520)
                        {

                            chico.setY(fy-50);
                            btnAbrir3.setEnabled(true);

                        }
                        else{btnAbrir3.setEnabled(false);}
                        repaint();
                    }
                }
            }


        });



        repaint();


        cr = Integer.parseInt(creditos.getText());
        fe = Integer.parseInt(fecha.getText());

    }


    public static class Nivel1 extends NivelChico {
        public Nivel1(ProyectoICAI proyectoICAI) {

            super(proyectoICAI);

            JLabel numNivel = new JLabel("1");
            numNivel.setFont(font1);
            numNivel.setPreferredSize(new Dimension(100, 100));
            numNivel.setBounds(361, 27, 50, 50);
            this.add(numNivel, BorderLayout.NORTH);


            JPanel panelAlgebra = new JPanel();
            panelAlgebra.setLayout(new BorderLayout());

            ImageIcon fotoAlgebra = new ImageIcon("./resources/algebra.png");
            JLabel lblAlgebra = new JLabel(fotoAlgebra);
            lblAlgebra.setBounds(20, 120, 200, 150);
            panelAlgebra.setBounds(20, 120, 200, 100);

            JPanel botonesAlgebra = new JPanel();
            botonesAlgebra.setLayout(new GridLayout(1, 3));

            JButton btnAAlgebra = new JButton("a");
            JButton btnBAlgebra = new JButton("b");
            JButton btnCAlgebra = new JButton("c");
            btnAAlgebra.setPreferredSize(new Dimension(50, 30));
            btnAAlgebra.setFocusable(false);
            btnAAlgebra.setBackground(Color.WHITE);
            btnBAlgebra.setPreferredSize(new Dimension(50, 30));
            btnBAlgebra.setFocusable(false);
            btnBAlgebra.setBackground(Color.WHITE);
            btnCAlgebra.setPreferredSize(new Dimension(50, 30));
            btnCAlgebra.setFocusable(false);
            btnCAlgebra.setBackground(Color.WHITE);


            panelAlgebra.add(lblAlgebra, BorderLayout.CENTER);


            botonesAlgebra.add(btnAAlgebra, BorderLayout.SOUTH);
            botonesAlgebra.add(btnBAlgebra, BorderLayout.SOUTH);
            botonesAlgebra.add(btnCAlgebra, BorderLayout.SOUTH);

            botonesAlgebra.setBounds(20, 220, 200, 30);


            this.add(botonesAlgebra);
            this.add(panelAlgebra);

            panelAlgebra.setVisible(false);
            botonesAlgebra.setVisible(false);

            btnAbrir1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelAlgebra.setVisible(true);
                    botonesAlgebra.setVisible(true);
                    proyectoICAI.musica("./resources/toctoc.wav",1);
                }
            });


            btnAAlgebra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    creditos.setText("" + ((Integer.parseInt(String.valueOf(cr))) + 6));
                    setCreditos(cr);

                    btnAAlgebra.setEnabled(false);
                    btnBAlgebra.setEnabled(false);
                    btnCAlgebra.setEnabled(false);

                    requestFocus();

                }
            });

            btnBAlgebra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.gameOver1();

                }
            });

            btnCAlgebra.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.gameOver1();

                }
            });


            //////////////////////////// FISICA


            JPanel panelFisica = new JPanel();
            panelFisica.setLayout(new BorderLayout());

            ImageIcon fotoFisica = new ImageIcon("./resources/fisica.png");
            JLabel lblFisica = new JLabel(fotoFisica);
            lblFisica.setBounds(240, 120, 200, 150);
            panelFisica.setBounds(240, 120, 200, 100);

            JPanel botonesFisica = new JPanel();
            botonesFisica.setLayout(new GridLayout(1, 3));

            JButton btnAFisica = new JButton("a");
            JButton btnBFisica = new JButton("b");
            JButton btnCFisica = new JButton("c");
            btnAFisica.setPreferredSize(new Dimension(50, 30));
            btnAFisica.setFocusable(false);
            btnAFisica.setBackground(Color.WHITE);
            btnBFisica.setPreferredSize(new Dimension(50, 30));
            btnBFisica.setFocusable(false);
            btnBFisica.setBackground(Color.WHITE);
            btnCFisica.setPreferredSize(new Dimension(50, 30));
            btnCFisica.setFocusable(false);
            btnCFisica.setBackground(Color.WHITE);


            panelFisica.add(lblFisica, BorderLayout.CENTER);


            botonesFisica.add(btnAFisica, BorderLayout.SOUTH);
            botonesFisica.add(btnBFisica, BorderLayout.SOUTH);
            botonesFisica.add(btnCFisica, BorderLayout.SOUTH);

            botonesFisica.setBounds(240, 220, 200, 30);


            this.add(botonesFisica);
            this.add(panelFisica);

            panelFisica.setVisible(false);
            botonesFisica.setVisible(false);



            btnAbrir2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (panelAlgebra.isVisible() & !btnAAlgebra.isEnabled()) {
                        panelFisica.setVisible(true);
                        botonesFisica.setVisible(true);
                        proyectoICAI.musica("./resources/toctoc.wav",1);
                    } else {
                        JOptionPane.showMessageDialog(Nivel1.this, " Error,haz el test anterior primero.");

                    }


                    requestFocus();
                }
            });


            btnAFisica.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    creditos.setText("" + ((Integer.parseInt(String.valueOf(cr))) + 6));
                    setCreditos(cr);



                    btnAFisica.setEnabled(false);
                    btnBFisica.setEnabled(false);

                    requestFocus();
                }
            });

            btnBFisica.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.gameOver1();

                }
            });

            btnCFisica.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.gameOver1();

                }
            });


            //////////////////////////// CALCULO

            JPanel panelCalculo = new JPanel();
            panelCalculo.setLayout(new BorderLayout());

            ImageIcon fotoCalculo = new ImageIcon("./resources/calculo.png");
            JLabel lblCalculo = new JLabel(fotoCalculo);
            lblCalculo.setBounds(470, 120, 200, 150);
            panelCalculo.setBounds(470, 120, 200, 100);

            JPanel botonesCalculo = new JPanel();
            botonesCalculo.setLayout(new GridLayout(1, 3));

            JButton btnACalculo = new JButton("a");
            JButton btnBCalculo = new JButton("b");
            JButton btnCCalculo = new JButton("c");
            btnACalculo.setPreferredSize(new Dimension(50, 30));
            btnACalculo.setFocusable(false);
            btnACalculo.setBackground(Color.WHITE);
            btnBCalculo.setPreferredSize(new Dimension(50, 30));
            btnBCalculo.setFocusable(false);
            btnBCalculo.setBackground(Color.WHITE);
            btnCCalculo.setPreferredSize(new Dimension(50, 30));
            btnCCalculo.setFocusable(false);
            btnCCalculo.setBackground(Color.WHITE);


            panelCalculo.add(lblCalculo, BorderLayout.CENTER);


            botonesCalculo.add(btnACalculo, BorderLayout.SOUTH);
            botonesCalculo.add(btnBCalculo, BorderLayout.SOUTH);
            botonesCalculo.add(btnCCalculo, BorderLayout.SOUTH);

            botonesCalculo.setBounds(470, 220, 200, 30);


            this.add(botonesCalculo);
            this.add(panelCalculo);

            panelCalculo.setVisible(false);
            botonesCalculo.setVisible(false);


            btnAbrir3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (panelFisica.isVisible() & !btnAFisica.isEnabled()) {
                        panelCalculo.setVisible(true);
                        botonesCalculo.setVisible(true);
                        proyectoICAI.musica("./resources/toctoc.wav",1);
                    } else {
                        JOptionPane.showMessageDialog(Nivel1.this, " Error,haz el test anterior primero.");

                    }
                    requestFocus();
                }
            });


            btnACalculo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.gameOver1();

                }
            });

            JButton pasar = new JButton(" Pasar al siguiente curso ");
            pasar.setBackground(Color.ORANGE);
            pasar.setFont(font);
            pasar.setBounds(400,400,250,50);

            pasar.setVisible(false);
            this.add(pasar);


            btnBCalculo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    creditos.setText("" + ((Integer.parseInt(String.valueOf(cr))) + 6));
                    setCreditos(cr);

                    btnACalculo.setEnabled(false);
                    btnBCalculo.setEnabled(false);
                    btnCCalculo.setEnabled(false);

                    JOptionPane.showMessageDialog(Nivel1.this, "Enhorabuena! Has superado el primer curso.");

                    if(!btnBCalculo.isEnabled())
                    {
                        pasar.setVisible(true);
                        pasar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                proyectoICAI.panelFallingCafeChico();
                            }
                        });
                    }

                    requestFocus();

                }
            });


            //proyectoICAI.panelNivel2Chica();
            btnCCalculo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    proyectoICAI.gameOver1();

                }
            });
        }
    }


    public static class Nivel2 extends NivelChico {
        public Nivel2(ProyectoICAI proyectoICAI) {

            super(proyectoICAI);



            JLabel numNivel = new JLabel("2");
            numNivel.setFont(font1);
            numNivel.setPreferredSize(new Dimension(100, 100));
            numNivel.setBounds(361, 27, 50, 50);
            this.add(numNivel, BorderLayout.NORTH);


            JPanel panelSistemas = new JPanel();
            panelSistemas.setLayout(new BorderLayout());

            ImageIcon fotoSistemas = new ImageIcon("./resources/Sistemas.png");
            JLabel lblSistemas = new JLabel(fotoSistemas);
            lblSistemas.setBounds(20, 120, 200, 150);
            panelSistemas.setBounds(20, 120, 200, 100);

            JPanel botonesSistemas = new JPanel();
            botonesSistemas.setLayout(new GridLayout(1, 3));

            JButton btnASistemas = new JButton("a");
            JButton btnBSistemas = new JButton("b");
            JButton btnCSistemas = new JButton("c");
            btnASistemas.setPreferredSize(new Dimension(50, 30));
            btnASistemas.setFocusable(false);
            btnASistemas.setBackground(Color.WHITE);
            btnBSistemas.setPreferredSize(new Dimension(50, 30));
            btnBSistemas.setFocusable(false);
            btnBSistemas.setBackground(Color.WHITE);
            btnCSistemas.setPreferredSize(new Dimension(50, 30));
            btnCSistemas.setFocusable(false);
            btnCSistemas.setBackground(Color.WHITE);


            panelSistemas.add(lblSistemas, BorderLayout.CENTER);


            botonesSistemas.add(btnASistemas, BorderLayout.SOUTH);
            botonesSistemas.add(btnBSistemas, BorderLayout.SOUTH);
            botonesSistemas.add(btnCSistemas, BorderLayout.SOUTH);

            botonesSistemas.setBounds(20, 220, 200, 30);


            this.add(botonesSistemas);
            this.add(panelSistemas);

            panelSistemas.setVisible(false);
            botonesSistemas.setVisible(false);

            btnAbrir1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelSistemas.setVisible(true);
                    botonesSistemas.setVisible(true);
                    proyectoICAI.musica("./resources/toctoc.wav",1);
                }
            });


            btnASistemas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    fecha.setText("" + ((Integer.parseInt(String.valueOf(fe))) + 1));
                    setFecha(fe);

                    JOptionPane.showMessageDialog(Nivel2.this, "Has suspendido. Repites!");

                    requestFocus();

                }
            });

            btnBSistemas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    fecha.setText("" + ((Integer.parseInt(String.valueOf(fe))) + 1));
                    setFecha(fe);

                    JOptionPane.showMessageDialog(Nivel2.this, "Has suspendido. Repites!");

                    requestFocus();

                }
            });

            btnCSistemas.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    creditos.setText("" + ((Integer.parseInt(String.valueOf(cr))) + 6));
                    setCreditos(cr);

                    btnASistemas.setEnabled(false);
                    btnBSistemas.setEnabled(false);
                    btnCSistemas.setEnabled(false);

                    requestFocus();
                }
            });


            //////////////////////////// ESTADISTICA


            JPanel panelEstadistica = new JPanel();
            panelEstadistica.setLayout(new BorderLayout());

            ImageIcon fotoEstadistica = new ImageIcon("./resources/Estadistica.png");
            JLabel lblEstadistica = new JLabel(fotoEstadistica);
            lblEstadistica.setBounds(240, 120, 200, 150);
            panelEstadistica.setBounds(240, 120, 200, 100);

            JPanel botonesEstadistica = new JPanel();
            botonesEstadistica.setLayout(new GridLayout(1, 3));

            JButton btnAEstadistica = new JButton("a");
            JButton btnBEstadistica = new JButton("b");
            JButton btnCEstadistica = new JButton("c");
            btnAEstadistica.setPreferredSize(new Dimension(50, 30));
            btnAEstadistica.setFocusable(false);
            btnAEstadistica.setBackground(Color.WHITE);
            btnBEstadistica.setPreferredSize(new Dimension(50, 30));
            btnBEstadistica.setFocusable(false);
            btnBEstadistica.setBackground(Color.WHITE);
            btnCEstadistica.setPreferredSize(new Dimension(50, 30));
            btnCEstadistica.setFocusable(false);
            btnCEstadistica.setBackground(Color.WHITE);


            panelEstadistica.add(lblEstadistica, BorderLayout.CENTER);


            botonesEstadistica.add(btnAEstadistica, BorderLayout.SOUTH);
            botonesEstadistica.add(btnBEstadistica, BorderLayout.SOUTH);
            botonesEstadistica.add(btnCEstadistica, BorderLayout.SOUTH);

            botonesEstadistica.setBounds(240, 220, 200, 30);


            this.add(botonesEstadistica);
            this.add(panelEstadistica);

            panelEstadistica.setVisible(false);
            botonesEstadistica.setVisible(false);



            btnAbrir2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (panelSistemas.isVisible() & !btnASistemas.isEnabled() ) {
                        panelEstadistica.setVisible(true);
                        botonesEstadistica.setVisible(true);
                        proyectoICAI.musica("./resources/toctoc.wav",1);
                    } else {
                        JOptionPane.showMessageDialog(Nivel2.this, " Error,haz el test anterior primero.");

                    }

                    requestFocus();

                }
            });


            btnAEstadistica.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    creditos.setText("" + ((Integer.parseInt(String.valueOf(cr))) + 6));
                    setCreditos(cr);

                    btnAEstadistica.setEnabled(false);
                    btnBEstadistica.setEnabled(false);
                    btnCEstadistica.setEnabled(false);

                    requestFocus();
                }
            });

            btnBEstadistica.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    fecha.setText("" + ((Integer.parseInt(String.valueOf(fe))) + 1));
                    setFecha(fe);

                    JOptionPane.showMessageDialog(Nivel2.this, "Has suspendido. Repites!");

                    requestFocus();

                }
            });

            btnCEstadistica.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    fecha.setText("" + ((Integer.parseInt(String.valueOf(fe))) + 1));
                    setFecha(fe);

                    JOptionPane.showMessageDialog(Nivel2.this, "Has suspendido. Repites!");

                    requestFocus();
                }
            });


            ////////////////////////////  POO

            JPanel panelPOO = new JPanel();
            panelPOO.setLayout(new BorderLayout());

            ImageIcon fotoPOO = new ImageIcon("./resources/poo.png");
            JLabel lblPOO = new JLabel(fotoPOO);
            lblPOO.setBounds(470, 120, 200, 150);
            panelPOO.setBounds(470, 120, 200, 100);

            JPanel botonesPOO = new JPanel();
            botonesPOO.setLayout(new GridLayout(1, 3));

            JButton btnAPOO = new JButton("a");
            JButton btnBPOO = new JButton("b");
            JButton btnCPOO = new JButton("c");
            btnAPOO.setPreferredSize(new Dimension(50, 30));
            btnAPOO.setFocusable(false);
            btnAPOO.setBackground(Color.WHITE);
            btnBPOO.setPreferredSize(new Dimension(50, 30));
            btnBPOO.setFocusable(false);
            btnBPOO.setBackground(Color.WHITE);
            btnCPOO.setPreferredSize(new Dimension(50, 30));
            btnCPOO.setFocusable(false);
            btnCPOO.setBackground(Color.WHITE);


            panelPOO.add(lblPOO, BorderLayout.CENTER);


            botonesPOO.add(btnAPOO, BorderLayout.SOUTH);
            botonesPOO.add(btnBPOO, BorderLayout.SOUTH);
            botonesPOO.add(btnCPOO, BorderLayout.SOUTH);

            botonesPOO.setBounds(470, 220, 200, 30);


            this.add(botonesPOO);
            this.add(panelPOO);

            panelPOO.setVisible(false);
            botonesPOO.setVisible(false);



            btnAbrir3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (panelEstadistica.isVisible() & !btnAEstadistica.isEnabled()) {
                        panelPOO.setVisible(true);
                        botonesPOO.setVisible(true);
                        proyectoICAI.musica("./resources/toctoc.wav",1);

                    } else {
                        JOptionPane.showMessageDialog(Nivel2.this, " Error,haz el test anterior primero.");
                    }

                    requestFocus();
                }
            });


            btnAPOO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    fecha.setText("" + ((Integer.parseInt(String.valueOf(fe))) + 1));
                    setFecha(fe);

                    JOptionPane.showMessageDialog(Nivel2.this, "Has suspendido. Repites!");

                    requestFocus();
                }
            });

            btnBPOO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    fecha.setText("" + ((Integer.parseInt(String.valueOf(fe))) + 1));
                    setFecha(fe);

                    JOptionPane.showMessageDialog(Nivel2.this, "Has suspendido. Repites!");

                    requestFocus();


                }
            });

            JButton fin = new JButton();
            ImageIcon imgGrad = new ImageIcon("./resources/graduacion.png");
            fin.setIcon(imgGrad);
            fin.setFocusable(false);
            fin.setBounds(400,400,277,82);
            fin.setVisible(false);
            fin.setOpaque(false);
            fin.setContentAreaFilled(false);
            fin.setBorderPainted(true);
            this.add(fin);

            btnCPOO.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    creditos.setText("" + ((Integer.parseInt(String.valueOf(cr))) + 6));
                    setCreditos(cr);

                    btnAPOO.setEnabled(false);
                    btnBPOO.setEnabled(false);
                    btnCPOO.setEnabled(false);

                    JOptionPane.showMessageDialog(Nivel2.this, "Enhorabuena! Puedes graduarte.");

                    proyectoICAI.musica("Resources/aplaus.wav",1);


                    fin.setVisible(true);

                    fin.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            proyectoICAI.panelDiploma();
                        }
                    });

                    requestFocus();

                }
            });
        }
    }

    @Override
    public void paintComponent(Graphics g) {


        g.drawImage(fondo, 0, 0, this);
        paintAvatars(g);

    }

    private void paintAvatars(Graphics g) {
        //g.drawImage(chico.getImage(),chico.getX(),chico.getY(),this);
        g.drawImage(chico.getImage(), chico.getX(), chico.getY(), this);

    }


    public int getFecha() {
        return fe;
    }


    /**
     *  Este metodo es para poder ir cambiado el JLabel de la fecha, para
     *  cuando el alumno repite, añadir un año.
     *
     * @param fe: la fecha
     */
    public void setFecha(int fe) {
        this.fe = Integer.parseInt(fecha.getText());
    }
    public int getCreditos() {
        return cr;
    }

    /**
     *  Este metodo es para poder ir cambiado el JLabel de los creditos, para
     *  cuando el alumno aprueba una asignatura, añadirle 6 creditos.
     *
     * @param cr: los creditos
     */
    public void setCreditos(int cr) {
        this.cr = Integer.parseInt(creditos.getText());
    }


    /**
     *  Este metodo es para poder tener el mismo numero de creditos
     * en el JLabel al cambiar de nivel
     * @param cr: los creditos iniciales del JLabel
     */
    public void cambiarCreditos(String cr)
    {
        creditos.setText(cr);
    }


}










