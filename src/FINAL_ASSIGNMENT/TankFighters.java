package FINAL_ASSIGNMENT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import javax.swing.Timer;

/**
 *
 * @author abdeo8431
 */
public class TankFighters extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 1200;
    static final int HEIGHT = 650;
    //Title of the window
    String title = "RIGHT THEN";
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 120;
    int desiredTime = Math.round((1000 / desiredFPS));
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // YOUR GAME VARIABLES WOULD GO HERE
    Rectangle tank1 = new Rectangle(25, HEIGHT / 2 - 12, 25, 25);
    Rectangle tank2 = new Rectangle(WIDTH - 50, HEIGHT / 2 - 12, 25, 25);
    Rectangle bullet1 = new Rectangle(65, HEIGHT / 2 - 6, 10, 10);
    Rectangle bullet2 = new Rectangle(WIDTH - 50, HEIGHT / 2 - 6, 10, 10);
    Rectangle border1 = new Rectangle(0, 0, WIDTH, 10);
    Rectangle border2 = new Rectangle(0, 0, 11, HEIGHT);
    Rectangle border3 = new Rectangle(0, 590, WIDTH, 10);
    Rectangle border4 = new Rectangle(WIDTH - 10, 0, 10, HEIGHT);
    Rectangle wall1 = new Rectangle(WIDTH / 2 - 50, HEIGHT / 2 - 150, 100, 300);
    int tankSpeed1 = 0;
    int tankSpeed2 = 0;
    int bulletSpeed1 = 0;
    int bulletSpeed2 = 0;
    int bullet1Angle = 0;
    int bullet2Angle = 0;
    int tank1BarrelPosition = 0;
    int tank2BarrelPosition = 180;
    boolean shotsFired = false;
    boolean tank1Up = false;
    boolean tank1Down = false;
    boolean tank1Right = false;
    boolean tank1Left = false;
    boolean tank2Up = false;
    boolean tank2Down = false;
    boolean tank2Right = false;
    boolean tank2Left = false;
    boolean tank1Shoot = false;
    boolean tank2Shoot = false;
    boolean bullet1Up = false;
    boolean bullet1Down = false;
    boolean bullet1Right = false;
    boolean bullet1Left = false;
    boolean bullet2Up = false;
    boolean bullet2Down = false;
    boolean bullet2Right = false;
    boolean bullet2Left = false;
    boolean tank1RotateBarrelL = false;
    boolean tank1RotateBarrelR = false;
    boolean tank2RotateBarrelL = false;
    boolean tank2RotateBarrelR = false;
    long timeFired1 = 0;
    long timeFired2 = 0;
    int delay = 10000; // 10 second delay
    int player1Score = 0;
    int player2Score = 0;
    Rectangle[] borders = new Rectangle[4];
    Rectangle[] walls = new Rectangle[44];
    //create a custom font!
    Font scoreboardFont = new Font("Comic Sans", Font.BOLD, 36);
    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)

    public TankFighters() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);
        preSetup();
        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);

        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        AffineTransform old = g2d.getTransform();

        g.setColor(Color.GREEN);
        g.fillOval(bullet1.x, bullet1.y, bullet1.width, bullet1.height);

        g.setColor(Color.MAGENTA);
        g.fillOval(bullet2.x, bullet2.y, bullet2.width, bullet2.height);


        g.setColor(Color.RED);
        g.fillRect(tank1.x, tank1.y, tank1.width, tank1.height);
        g.setColor(Color.BLUE);
        g.fillRect(tank2.x, tank2.y, tank2.width, tank2.height);

        g.setColor(Color.BLACK);
        g2d.rotate(Math.toRadians(tank1BarrelPosition), tank1.x + 12, tank1.y + 12);
        g.drawRect(tank1.x + 12, tank1.y + 10, 15, 5);
        g2d.setTransform(old);

        g2d.rotate(Math.toRadians(tank2BarrelPosition), tank2.x + 12, tank2.y + 12);
        g.drawRect(tank2.x + 12, tank2.y + 10, 15, 5);
        g2d.setTransform(old);

        g.setColor(Color.GRAY);
        g.fillRect(border1.x, border1.y, border1.width, border1.height);
        g.fillRect(border2.x, border2.y, border2.width, border2.height);
        g.fillRect(border3.x, border3.y, border3.width, border3.height);
        g.fillRect(border4.x, border4.y, border4.width, border4.height);
        for (int i = 0; i < walls.length; i++) {
            g.fillRect(walls[i].x, walls[i].y, walls[i].width, walls[i].height);
        }

        g.fillRect(0, 600, WIDTH, 50);
        g.setColor(Color.BLACK);
        g.setFont(scoreboardFont);
        g.drawString("" + player1Score, WIDTH / 2 - 50, 625);
        g.drawString("" + player2Score, WIDTH / 2 + 50, 625);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

        walls[0] = new Rectangle(75, 75, 487, 7);
        walls[1] = new Rectangle(562, 75, 75, 7);
        walls[2] = new Rectangle(637, 75, 488, 7);
        walls[3] = new Rectangle(75, 75, 7, 100);
        walls[4] = new Rectangle(75, 250, 7, 100);
        walls[5] = new Rectangle(75, 425, 7, 100);
        walls[6] = new Rectangle(75, 525, 192, 7);
        walls[7] = new Rectangle(125, 470, 87, 7);
        walls[8] = new Rectangle(262, 425, 7, 100);
        walls[9] = new Rectangle(262, 425, 300, 7);
        walls[10] = new Rectangle(562, 425, 7, 50);
        walls[11] = new Rectangle(562, 475, 75, 7);
        walls[12] = new Rectangle(637, 425, 7, 55);
        walls[13] = new Rectangle(637, 425, 300, 7);
        walls[14] = new Rectangle(937, 425, 7, 100);
        walls[15] = new Rectangle(937, 525, 193, 7);
        walls[16] = new Rectangle(987, 470, 88, 7);
        walls[17] = new Rectangle(1125, 425, 7, 100);
        walls[18] = new Rectangle(1125, 250, 7, 100);
        walls[19] = new Rectangle(1125, 75, 7, 100);
        walls[20] = new Rectangle(412, 550, 7, 50);
        walls[21] = new Rectangle(787, 550, 7, 50);
        walls[22] = new Rectangle(562, 550, 7, 50);
        walls[23] = new Rectangle(637, 550, 7, 50);
        walls[24] = new Rectangle(562, 250, 7, 100);
        walls[25] = new Rectangle(637, 250, 7, 100);
        walls[26] = new Rectangle(562, 75, 7, 100);
        walls[27] = new Rectangle(637, 75, 7, 100);
        walls[28] = new Rectangle(150, 150, 7, 50);
        walls[29] = new Rectangle(150, 150, 337, 7);
        walls[30] = new Rectangle(1050, 150, 7, 50);
        walls[31] = new Rectangle(713, 150, 337, 7);
        walls[32] = new Rectangle(462, 250, 100, 7);
        walls[33] = new Rectangle(462, 350, 105, 7);
        walls[34] = new Rectangle(637, 250, 100, 7);
        walls[35] = new Rectangle(637, 350, 100, 7);
        walls[36] = new Rectangle(150, 250, 7, 100);
        walls[37] = new Rectangle(150, 250, 100, 7);
        walls[38] = new Rectangle(200, 300, 7, 50); //this is the wall
        walls[39] = new Rectangle(200, 300, 50, 7);
        walls[40] = new Rectangle(1050, 250, 7, 100);
        walls[41] = new Rectangle(1000, 300, 7, 50);
        walls[42] = new Rectangle(950, 250, 100, 7);
        walls[43] = new Rectangle(950, 300, 50, 7);
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        moveTanksAndBullets();
        detectACollision();
        bulletLogic();
        scoreTally();
    }

    private void moveTanksAndBullets() {
        if (tank1Right) {
            tank1.x += tankSpeed1;
        } else if (tank1Left) {
            tank1.x -= tankSpeed1;
        }

        if (tank1Up) {
            tank1.y -= tankSpeed1;
        } else if (tank1Down) {
            tank1.y += tankSpeed1;
        }

        if (tank2Right) {
            tank2.x += tankSpeed2;
        } else if (tank2Left) {
            tank2.x -= tankSpeed2;
        }

        if (tank2Up) {
            tank2.y -= tankSpeed2;
        } else if (tank2Down) {
            tank2.y += tankSpeed2;
        }

        if (bulletSpeed1 > 0 || bulletSpeed1 < 0) {
            tankSpeed1 = 0;
            tank1Down = false;
            tank1Right = false;
            tank1Left = false;
            bullet1Up = false;
            bullet1Down = false;
            bullet1Right = false;
            bullet1Left = false;

        } else if (bulletSpeed1 == 0) {
            tankSpeed1 = 4;
        }

        if (bulletSpeed2 > 0 || bulletSpeed2 < 0) {
            tankSpeed2 = 0;
            tank2Up = false;
            tank2Down = false;
            tank2Right = false;
            tank2Left = false;
            bullet2Up = false;
            bullet2Down = false;
            bullet2Right = false;
            bullet2Left = false;
        } else if (bulletSpeed2 == 0) {
            tankSpeed2 = 4;
        }
        if (bullet1Up) {
            bullet1.y -= tankSpeed1;
        } else if (bullet1Down) {
            bullet1.y += tankSpeed1;
        }

        if (bullet1Right) {
            bullet1.x += tankSpeed1;
        } else if (bullet1Left) {
            bullet1.x -= tankSpeed1;
        }

        if (bullet2Up) {
            bullet2.y -= tankSpeed2;
        } else if (bullet1Down) {
            bullet2.y += tankSpeed2;
        }

        if (bullet2Right) {
            bullet2.x += tankSpeed2;
        } else if (bullet2Left) {
            bullet2.x -= tankSpeed2;
        }

    }

    private void detectACollision() {
        if (tank1.intersects(border1)) {
            tank1.y = border1.y + 10;
        }
        if (tank1.intersects(border2)) {
            tank1.x = border2.x + 10;
        }
        if (tank1.intersects(border3)) {
            tank1.y = border3.y - 25;
        }
        if (tank1.intersects(border4)) {
            tank1.x = border4.x - 25;
        }

        if (tank2.intersects(border1)) {
            tank2.y = border1.y + 10;
        }
        if (tank2.intersects(border2)) {
            tank2.x = border2.x + 10;
        }
        if (tank2.intersects(border3)) {
            tank2.y = border3.y - 25;
        }
        if (tank2.intersects(border4)) {
            tank2.x = border4.x - 25;

        }

        if (bullet1.intersects(border2) || bullet1.intersects(border4)) {
            bullet1Angle = (180 + bullet1Angle * -1) % 360;
        }
        if (bullet1.intersects(border1) || bullet1.intersects(border3)) {
            bullet1Angle = bullet1Angle * -1;
        }

        if (bullet2.intersects(border2) || bullet2.intersects(border4)) {
            bullet2Angle = (180 + bullet2Angle * -1) % 360;
        }
        if (bullet2.intersects(border1) || bullet2.intersects(border3)) {
            bullet2Angle = bullet2Angle * -1;
        }

        for (int i = 0; i < walls.length; i++) {
            if (tank1.intersects(walls[i])) {
                if (tank1.x + 25 > walls[i].x && tank1.x + 25 < walls[i].x + 5) {
                    tank1.x = walls[i].x - 25;
                }
                if (tank1.x < walls[i].x + walls[i].width && tank1.x > walls[i].x + walls[i].width - 5) {
                    tank1.x = walls[i].x + walls[i].width;
                }
                if (tank1.y + 25 > walls[i].y && tank1.y + 25 < walls[i].y + 5) {
                    tank1.y = walls[i].y - 25;
                }
                if (tank1.y < walls[i].y + walls[i].height && tank1.y > walls[i].y + walls[i].height - 5) {
                    tank1.y = walls[i].y + walls[i].height;
                }
            }
        }

        for (int i = 0; i < walls.length; i++) {
            if (tank2.intersects(walls[i])) {
                if (tank2.x + 25 > walls[i].x && tank2.x + 25 < walls[i].x + 5) {
                    tank2.x = walls[i].x - 25;
                }
                if (tank2.x < walls[i].x + walls[i].width && tank2.x > walls[i].x + walls[i].width - 5) {
                    tank2.x = walls[i].x + walls[i].width;
                }
                if (tank2.y + 25 > walls[i].y && tank2.y + 25 < walls[i].y + 5) {
                    tank2.y = walls[i].y - 25;
                }
                if (tank2.y < walls[i].y + walls[i].height && tank2.y > walls[i].y + walls[i].height - 5) {
                    tank2.y = walls[i].y + walls[i].height;
                }
            }
        }

        for (int i = 0; i < walls.length; i++) {
            if (bullet1.intersects(walls[i])) {
                if (bullet1.x + 10 >= walls[i].x && bullet1.x + 10 <= walls[i].x + 5) {
                    bullet1Angle = (180 + bullet1Angle * -1) % 360;
                } if (bullet1.x <= walls[i].x + 7 && bullet1.x >= walls[i].x + 2) {
                    bullet1Angle = (180 + bullet1Angle * -1) % 360;
                }
                if (bullet1.y + 10 >= walls[i].y && bullet1.y + 10 <= walls[i].y + 5) {
                    bullet1Angle = bullet1Angle * -1;
                } if (bullet1.y <= walls[i].y + 7 && bullet1.y >= walls[i].y + 2) {
                    bullet1Angle = bullet1Angle * -1;
                }
            }

        }

        for (int i = 0; i < walls.length; i++) {
            if (bullet2.intersects(walls[i])) {
                if (bullet2.x + 10 > walls[i].x && bullet2.x + 10 < walls[i].x + 6) {
                    bullet2Angle = (180 + bullet2Angle * -1) % 360;
                }
                if (bullet2.x < walls[i].x + walls[i].width && bullet2.x > walls[i].x + walls[i].width - 6) {
                    bullet2Angle = (180 + bullet2Angle * -1) % 360;
                }
                if (bullet2.y + 10 > walls[i].y && bullet2.y + 10 < walls[i].y + 6) {
                    bullet2Angle = bullet2Angle * -1;
                }
                if (bullet2.y < walls[i].y + walls[i].height && bullet2.y > walls[i].y + walls[i].height - 6) {
                    bullet2Angle = bullet2Angle * -1;
                }
            }
        }
    }

    private void bulletLogic() {
        if (bulletSpeed1 > 0 || bulletSpeed1 < 0) {
            shotsFired = true;
        }
        if (tank1RotateBarrelL) {
            tank1BarrelPosition -= 3;
            bullet1Angle -= 3;
        } else if (tank1RotateBarrelR) {
            tank1BarrelPosition += 3;
            bullet1Angle += 3;
        }

        double newAngle = Math.toRadians(bullet1Angle);
        double tank1BulletX = bulletSpeed1 * Math.cos(newAngle);
        double tank1BulletY = bulletSpeed1 * Math.sin(newAngle);

        if (tank1Shoot && bulletSpeed1 == 0) {
            bulletSpeed1 = 5;
            timeFired1 = System.currentTimeMillis(); // the time it shot
        }
        if (shotsFired) {
            bullet1.x = bullet1.x + (int) tank1BulletX;
            bullet1.y = bullet1.y + (int) tank1BulletY;
            tank1BarrelPosition = bullet1Angle;
        }

        // timer should stop
        if (System.currentTimeMillis() > timeFired1 + delay) {
            shotsFired = false;
            bulletSpeed1 = 0;
        }
        if (bulletSpeed1 == 0) {
            bullet1.x = tank1.x + 15;
            bullet1.y = tank1.y + 7;
        }

        if (bulletSpeed2 > 0 || bulletSpeed2 < 0) {
            shotsFired = true;
        }
        if (tank2RotateBarrelL) {
            tank2BarrelPosition -= 3;
            bullet2Angle -= 3;
        } else if (tank2RotateBarrelR) {
            tank2BarrelPosition += 3;
            bullet2Angle += 3;
        }

        double newAngle2 = Math.toRadians(bullet2Angle);
        double tank2BulletX = bulletSpeed2 * Math.cos(newAngle2);
        double tank2BulletY = bulletSpeed2 * Math.sin(newAngle2);
        if (tank2Shoot && bulletSpeed2 == 0) {
            bulletSpeed2 = -5;
            timeFired2 = System.currentTimeMillis(); // the time it shot
        }
        if (shotsFired) {
            bullet2.x = bullet2.x + (int) tank2BulletX;
            bullet2.y = bullet2.y + (int) tank2BulletY;
            tank2BarrelPosition = 180 + bullet2Angle;
        }
        // timer should stop
        if (System.currentTimeMillis() > timeFired2 + delay) {
            shotsFired = false;
            bulletSpeed2 = 0;
        }

        if (bulletSpeed2 == 0) {
            bullet2.x = tank2.x;
            bullet2.y = tank2.y + 7;
        }

    }

    private void scoreTally() {
        if (!(tank1.intersects(tank2))) {
            if (bullet1.intersects(tank2)) {
                player1Score++;

            }
            if (bullet2.intersects(tank1)) {
                player2Score++;

            }
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

// Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            //get keyCode
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
                tank1Up = true;
                bullet1Up = true;
            } else if (keyCode == KeyEvent.VK_S) {
                tank1Down = true;
                bullet1Down = true;
            }

            if (keyCode == KeyEvent.VK_D) {
                tank1Right = true;
                bullet1Right = true;
            } else if (keyCode == KeyEvent.VK_A) {
                tank1Left = true;
                bullet1Left = true;
            }

            if (keyCode == KeyEvent.VK_E) {
                tank1RotateBarrelL = true;
            } else if (keyCode == KeyEvent.VK_F) {
                tank1RotateBarrelR = true;
            }

            if (keyCode == KeyEvent.VK_R) {
                tank1Shoot = true;
            }

            if (keyCode == KeyEvent.VK_I) {
                tank2Up = true;
                bullet2Up = true;
            } else if (keyCode == KeyEvent.VK_K) {
                tank2Down = true;
                bullet2Down = true;
            }

            if (keyCode == KeyEvent.VK_L) {
                tank2Right = true;
                bullet2Right = true;
            } else if (keyCode == KeyEvent.VK_J) {
                tank2Left = true;
                bullet2Left = true;
            }

            if (keyCode == KeyEvent.VK_H) {
                tank2RotateBarrelL = true;
            } else if (keyCode == KeyEvent.VK_U) {
                tank2RotateBarrelR = true;
            }

            if (keyCode == KeyEvent.VK_Y) {
                tank2Shoot = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            //get keyCode
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
                tank1Up = false;
                bullet1Up = false;
            } else if (keyCode == KeyEvent.VK_S) {
                tank1Down = false;
                bullet1Down = false;
            }

            if (keyCode == KeyEvent.VK_D) {
                tank1Right = false;
                bullet1Right = false;
            } else if (keyCode == KeyEvent.VK_A) {
                tank1Left = false;
                bullet1Left = false;
            }

            if (keyCode == KeyEvent.VK_E) {
                tank1RotateBarrelL = false;
            } else if (keyCode == KeyEvent.VK_F) {
                tank1RotateBarrelR = false;
            }

            if (keyCode == KeyEvent.VK_R) {
                tank1Shoot = false;
            }

            if (keyCode == KeyEvent.VK_I) {
                tank2Up = false;
                bullet2Up = false;
            } else if (keyCode == KeyEvent.VK_K) {
                tank2Down = false;
                bullet2Down = false;
            }

            if (keyCode == KeyEvent.VK_L) {
                tank2Right = false;
                bullet2Right = false;
            } else if (keyCode == KeyEvent.VK_J) {
                tank2Left = false;
                bullet2Left = false;
            }

            if (keyCode == KeyEvent.VK_H) {
                tank2RotateBarrelL = false;
            } else if (keyCode == KeyEvent.VK_U) {
                tank2RotateBarrelR = false;
            }

            if (keyCode == KeyEvent.VK_Y) {
                tank2Shoot = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        TankFighters game = new TankFighters();
    }
}
