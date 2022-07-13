import java.awt.*;
import javax.swing.*;

public class Sierpinski extends Canvas
{
    public int n;
    public int size;
    public int x = 0;
    public int y = 700;
    
    
    public void drawTriangle(int x, int y, int size, Graphics g){
        
        int x2 = x + size/2;
        int x3 = x + size;
        int y2 = y - size;
        int y3 = y;

        int[] xcoord = {x, x2, x3};
        int[] ycoord = {y, y2, y3};
        
        g.drawPolygon(xcoord, ycoord, 3);

        size = size/2;
        

        int iteration = 700;

        for(int i = -1; i < n; i++){
            iteration = iteration/2;
        }

        if(size > iteration){
            drawTriangle(x, y, size, g);
            drawTriangle(x+size, y, size, g);
            drawTriangle(x+(size/2), y-(size), size, g);
        }



    }
    public void paint(Graphics g)
    {

        drawTriangle(x, y, size, g);
        
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sierpinski drawing = new Sierpinski();
        drawing.n = Integer.parseInt(args[0]);
        drawing.size = 700;
        drawing.setSize(drawing.size, drawing.size);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }
}