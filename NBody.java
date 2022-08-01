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
    public ArrayList<Double> xVel = new ArrayList<>();
    public ArrayList<Double> yVel = new ArrayList<>();

    //change in velocity dV = a * dt


    public ArrayList<Double> xAcc = new ArrayList<>();
    public ArrayList<Double> yAcc = new ArrayList<>();


    
    public int size;
    public double dt;
    public double maxVel;
    public double maxMass;
    public double g;

    public void init(int n)
    {
        // Your initialization code here:
        this.n = n;
        for(int i = 0; i < n; i++){
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 800);
            int mass = (int) (Math.random() * 10 + 1);
            int R = (int) (Math.random() * 255);
            int G = (int) (Math.random() * 255);
            int B = (int) (Math.random() * 255);
            double initVelX =(Math.random() * 20 - 10); 
            double initVelY =(Math.random() * 20 - 10); 


            Color color = new Color(R, G, B);

            xCoord.add(x);
            yCoord.add(y);
            setColor.add(color);
            Mass.add(mass);
            xVel.add(initVelX);
            yVel.add(initVelY);

        }
    }


    public double calcDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2-y1, 2)));
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

        for(int j = 0; j < n; j++){
            for(int k = 1; k < n-1; k++){
                double r = calcDistance(xCoord.get(j), yCoord.get(j), xCoord.get(k), yCoord.get(k));
                if(r < 5){
                    r = 5;
                }
                r = calcDistance(xCoord.get(j)/r, yCoord.get(j)/r, xCoord.get(k)/r, yCoord.get(k)/r);

                double m1 = Mass.get(j);
                double m2 = Mass.get(k);
                double f = (g * m1 * m2)/(Math.pow(r, 2));
                double a = f/m1;

            }
        }
        

        for(int i = 0; i < n; i++){
            xCoord.set(i,(int) (xCoord.get(i) + xVel.get(i)));
            yCoord.set(i,(int) (yCoord.get(i) + yVel.get(i)));
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
        nbody.g = 100;
        nbody.setPreferredSize(new Dimension(nbody.size, nbody.size));
        nbody.init(n);

        frame.add(nbody);
        frame.pack();

        Timer timer = new Timer(16, nbody);
        timer.start();

        frame.setVisible(true);
    }
}
