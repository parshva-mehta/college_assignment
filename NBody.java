import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class NBody extends Canvas implements ActionListener
{
    public int n;

    //initial pos
    public ArrayList<Integer> xCoord = new ArrayList<>();
    public ArrayList<Integer> yCoord = new ArrayList<>();
    public ArrayList<Integer> Mass = new ArrayList<>();
    public ArrayList<Color> setColor = new ArrayList<>();

    //change in postion dP = v * dt
    public ArrayList<Integer> xVel = new ArrayList<>();
    public ArrayList<Integer> yVel = new ArrayList<>();

    //change in velocity dV = a * dt
    public ArrayList<Integer> xAcc = new ArrayList<>();
    public ArrayList<Integer> yAcc = new ArrayList<>();


    
    public int size;
    public double dt;
    public double maxVel;
    public double maxMass;

    public void init(int n)
    {
        // Your initialization code here:
        this.n = n;
        for(int i = 0; i < n; i++){
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 800);
            int mass = (int) (Math.random() * 10);
            int R = (int) (Math.random() * 255);
            int G = (int) (Math.random() * 255);
            int B = (int) (Math.random() * 255);
            int initVelX = (int) (Math.random() * 20 - 10); 
            int initVelY = (int) (Math.random() * 20 - 10); 
            

            Color color = new Color(R, G, B);

            xCoord.add(x);
            yCoord.add(y);
            setColor.add(color);
            Mass.add(mass);
            xVel.add(initVelX);
            yVel.add(initVelY);
        }
    }

    
    // Draw a circle centered at (x, y) with radius r
    public void drawCircle(Graphics g, int x, int y, int r)
    {
        int d = 2*r;
        g.fillOval(x - r, y - r, d, d);
    }

    public void paint(Graphics g)
    {
        // Clear the screen
        super.paint(g);

        // Your drawing code here:

        for(int i = 0; i < n; i++){
            g.setColor(setColor.get(i));
            drawCircle(g, xCoord.get(i), yCoord.get(i), Mass.get(i));            
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        // Your update code here:
        for(int i = 0; i < n; i++){
            xCoord.set(i,xCoord.get(i) + xVel.get(i));
            yCoord.set(i,yCoord.get(i) + yVel.get(i));
        }

        // Repaint the screen
        repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int n = Integer.parseInt(args[0]);

        NBody nbody = new NBody();
        nbody.setBackground(Color.BLACK);
        nbody.size = 800;
        nbody.maxVel = 10;
        nbody.maxMass = 10;
        nbody.dt = 0.1;
        nbody.setPreferredSize(new Dimension(nbody.size, nbody.size));
        nbody.init(n);

        frame.add(nbody);
        frame.pack();

        Timer timer = new Timer(16, nbody);
        timer.start();

        frame.setVisible(true);
    }
}
