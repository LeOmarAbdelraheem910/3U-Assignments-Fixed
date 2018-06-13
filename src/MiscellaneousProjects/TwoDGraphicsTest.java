/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiscellaneousProjects;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.Timer;

public class TwoDGraphicsTest extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TwoDGraphicsTest();
    }

    public TwoDGraphicsTest() {
        this.setSize(500, 500);
        this.setTitle("Drawing Shapes!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new drawThings(), BorderLayout.CENTER);
        this.setVisible(true);
    }

    private class drawThings extends JComponent {

        public void paint(Graphics g) {
            Graphics2D graph2 = (Graphics2D) g;

            graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Shape drawLine = new Line2D.Float(20, 90, 55, 250);
            Shape drawArc2D = new Arc2D.Double(5, 150, 100, 100, 45, 45, Arc2D.OPEN);
            Shape drawArc2D2 = new Arc2D.Double(5, 200, 100, 100, 45, 45, Arc2D.CHORD);
            Shape drawArc2D3 = new Arc2D.Double(5, 250, 100, 100, 45, 45, Arc2D.PIE);

            graph2.setPaint(Color.RED);
            graph2.draw(drawLine);
            graph2.setPaint(Color.GREEN);
            graph2.draw(drawArc2D);
            graph2.setPaint(Color.BLUE);
            graph2.draw(drawArc2D2);
            graph2.setPaint(Color.MAGENTA);
            graph2.draw(drawArc2D3);

            Shape drawEllipse = new Ellipse2D.Float(10, 10, 100, 100);

            Shape drawRoundRec = new RoundRectangle2D.Double(25, 25, 50, 50, 45, 45);

            CubicCurve2D cubicCurve = new CubicCurve2D.Double();

            cubicCurve.setCurve(110, 50, 300, 200, 200, 200, 90, 263);

            Shape drawRect = new Rectangle2D.Float(300, 300, 150, 150);

            Shape drawQuadCurve = new QuadCurve2D.Float(300, 100, 400, 200, 150, 300);

            Shape drawTransRect = new Rectangle2D.Double(300, 300, 75, 30);

            graph2.draw(drawEllipse);
            graph2.setColor(Color.BLACK);

            graph2.fill(drawRoundRec);
            graph2.setColor(new Color(0, 221, 0));

            graph2.draw(cubicCurve);
            graph2.setColor(new Color(123, 32, 78));

            graph2.draw(drawRect);
            graph2.setColor(Color.PINK);

            graph2.draw(drawQuadCurve);
            graph2.setColor(Color.YELLOW);
            graph2.draw(drawTransRect);
            graph2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.40F));

            GradientPaint theGradient = new GradientPaint(0, 0, Color.BLUE, 60, 0, new Color(0x66ffff), true);

            graph2.setPaint(theGradient);

            this.setBackground(Color.CYAN);

            graph2.fill(new Rectangle2D.Float(10, 10, 150, 100));

            graph2.fill(drawTransRect);

            Timer t = new Timer(5, (ActionListener) this);
            
        }
    }
}
