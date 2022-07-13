import java.awt.*;
import javax.swing.*;

public class DrawTicTacToe extends Canvas
{
    public int xRow, xCol;
    public int oRow, oCol;

    
    public void drawCircle(Graphics g, int x, int y, int r){
        g.setColor(Color.blue);
        g.drawOval(x-(r/2),y-(r/2),r,r);
    }

    public void drawX(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        g.setColor(Color.red);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x3, y3, x4, y4);
    }

    public void paint(Graphics g) {
        int x = 0;
        int y = 0;

        //draws the board
        g.drawLine(50,150,350,150);
        g.drawLine(50,250,350,250);
        g.drawLine(150,50,150,350);
        g.drawLine(250,50,250,350);
        
        x = (oRow * 100) + 100;
        y = (oCol * 100) + 100;

        drawCircle(g,y,x,75); //inversed coordinate plane since starting from top left not bottom left.

    
        int x1 = (xRow * 100) + 65;
        int y1 = (xCol * 100) + 65;
        int x2 = (xRow * 100) + 135;
        int y2 = (xCol * 100) + 135;

        int x3 = (xRow * 100) + 135;
        int y3 = (xCol * 100) + 65;
        int x4 = (xRow * 100) + 65;
        int y4 = (xCol * 100) + 135;

        drawX(g,y1,x1,y2,x2,y3,x3,y4,x4); //Inverting x and y for flipped coordinate plane
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawTicTacToe drawing = new DrawTicTacToe();

        drawing.xRow = Integer.parseInt(args[0]); //x1
        drawing.xCol = Integer.parseInt(args[1]); //y1

        drawing.oRow = Integer.parseInt(args[2]); //x2
        drawing.oCol = Integer.parseInt(args[3]); //y2

        drawing.setSize(400, 400);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }
}