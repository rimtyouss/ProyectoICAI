package domain;

import java.awt.*;


public abstract class Alumno
{


    public int x = 10;
    public int y = 368;

    protected Image avatar;


    public Alumno(int x, int y)
    {
        this.x=x;
        this.y=y;

    }

    public Image getImage()
    {
        return avatar;
    }

    public static class Chica extends Alumno
    {
        public Chica(int x,int y)
        {
            super(x,y);
            avatar = Toolkit.getDefaultToolkit().getImage("resources/chica.png");
        }
    }

    public static class Chico extends Alumno
    {
        public Chico(int x,int y)
        {
            super(x,y);
            avatar = Toolkit.getDefaultToolkit().getImage("resources/chico.png");
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x=x;
    }

    public void setY(int y)
    {
        this.y=y;
    }




}
