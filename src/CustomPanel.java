
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class CustomPanel extends JPanel{
    int progress=0;
    public void updateProgress(int progress_value){
        progress=progress_value;
        
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(this.getWidth()/2, this.getHeight()/2);
        g2.rotate(Math.toRadians(270));
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        Ellipse2D circle = new Ellipse2D.Float(0,0,110,110);
        arc.setFrameFromCenter(new Point(0, 0), new Point(120, 120));
        circle.setFrameFromCenter(new Point(0, 0), new Point(110, 110));
        arc.setAngleStart(1);
        arc.setAngleExtent(-progress*3.6);
        g2.setColor(Color.getHSBColor(143, 246, 197));
        g2.draw(arc);
        g2.fill(arc);
        
        
        g2.setColor(Color.black);
        g2.draw(circle);
        g2.fill(circle);
        
        //setting text
        g2.setColor(Color.getHSBColor(143, 246, 197));
        g2.rotate(Math.toRadians(90));
        g.setFont(new Font("Verdana", Font.BOLD, 50));
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r =fm.getStringBounds(progress+"%", g);
        int x=(0-(int)r.getWidth())/2;
        int y=(0-(int)r.getHeight())/2 + fm.getAscent();
        g2.drawString(progress+"%",x,y);
    }
}
