package MiscellaneousProjects;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author abdeo8431
 */
public class SonicLeHedgehogRemake extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 2000;
    static final int HEIGHT = 600;

    //Title of the window
    String title = "Sanic Spring";

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));

    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    BufferedImage sonic = loadImage("Sonic's Death.png");
    BufferedImage robotnik = loadImage("Laughing Robotnik Sprite.png");
    BufferedImage eHZGround = loadImage("4.png");
    BufferedImage sonicRolling1 = loadImage("Sonic Rolling Position 1.png");

    // YOUR GAME VARIABLES WOULD GO HERE
    double sonicX = 100;
    double sonicY = 432;
    double robotnikX = 50;
    double robotnikY = 421;
    double terrainMovementX = 0;
    double terrainMovementY = 0;

    boolean lookUp = false;
    boolean rolling = false;
    boolean moveLeft = false;
    boolean moveRight = false;
    boolean jump = false;
    boolean falling = false;

    //Variables
    //Horizontal x-speed of Sonic
    double xsp = 0;
    //Vertical y-speed of Sonic
    double ysp = 0;
    //Total ground speed of sonic (x and y speeds work together to determine speed on inclines.
    double gsp = 0;
    //Constants for Accelertation, Deccelertation, friction, top speed, and gravity of all characters/objects!
    double acc = 0.046875;
    double accAir = 0.09375;
    double dec = 0.5;
    double frc = 0.046875;
    double top = 6;
    double grv = 0.21875;
    double jmp = 0;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public SonicLeHedgehogRemake() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

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

    //Set up a method to play music while the game and game levels is running.
    public static void playMusic(String filepath) {
        InputStream music;
        try {
            //Be able to locate and play and audio files.
            music = new FileInputStream(new File(filepath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        } catch (Exception e) {
            //Print out an error message if the file cannot be found/played.
            System.out.println("Music file cannot be played!");
            e.printStackTrace();
        }
    }

    public BufferedImage loadImage(String name) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(name));
        } catch (Exception e) {
            System.out.println("Can't load image");
            e.printStackTrace();
        }
        return img;
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {

        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(sonic, (int) sonicX, (int) sonicY, null);
        g.drawImage(robotnik, (int) robotnikX, (int) robotnikY, null);
        g.drawImage(eHZGround, 0 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 128 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 256 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 384 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 512 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 640 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 768 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 896 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 1024 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 1152 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 1280 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 1408 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);
        g.drawImage(eHZGround, 1536 - (int) terrainMovementX, 472 + (int) terrainMovementY, null);

        if(rolling && xsp >= 1.03125 || xsp <= -1.03125){
            g.drawImage(sonicRolling1, (int) sonicX, (int) sonicY, null);
        }
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {

        if (lookUp) {
            sonicY = sonicY - 25;
            robotnikY = robotnikY - 25;
        }
        if (rolling && xsp >= 1.03125 && gsp > 0 && !(gsp == 0)) {
            if (gsp > 0) {
                gsp -= 0.0234375;
            }
            if (moveLeft) {
                gsp -= 0.125;
            }
            xsp = gsp * cos(0);
            sonicX = sonicX + xsp;
            robotnikX = robotnikX + xsp;
            terrainMovementX = terrainMovementX + xsp;
        }
        if (rolling && xsp <= -1.03125 && gsp < 0 && !(gsp == 0)) {
            if (gsp < 0) {
                gsp += 0.0234375;
            }
            if (moveRight) {
                gsp += 0.125;
            }
            xsp = gsp * cos(0);
            sonicX = sonicX - (-1 * xsp);
            robotnikX = robotnikX - (-1 * xsp);
            terrainMovementX = terrainMovementX - (-1 * xsp);

        }
        ysp = gsp * -1 * sin(0);
        if (rolling == false && moveLeft == false && moveRight == false && gsp < 0 && !(gsp == 0)) {
            if (sonicY >= 432 && robotnikY >= 421) {
                gsp += frc;
                if (gsp > 0) {
                    gsp = 0;
                }
                xsp = gsp * cos(0);
                sonicX = sonicX - (-1 * xsp);
                robotnikX = robotnikX - (-1 * xsp);
                terrainMovementX = terrainMovementX - (-1 * xsp);
            } else if (sonicY < 432 && robotnikY < 421) {
                xsp = gsp * cos(0) * 0.96875;
                sonicX = sonicX - (-1 * xsp);
                robotnikX = robotnikX - (-1 * xsp);
                terrainMovementX = terrainMovementX - (-1 * xsp);
            }
        }
        if (rolling == false && moveRight == false && moveLeft == false && gsp > 0 && !(gsp == 0)) {
            if (sonicY >= 432 && robotnikY >= 421) {
                gsp -= frc;
                if (gsp < 0) {
                    gsp = 0;
                }
                xsp = gsp * cos(0);
                sonicX = sonicX + xsp;
                robotnikX = robotnikX + xsp;
                terrainMovementX = terrainMovementX + xsp;
            } else if (sonicY < 432 && robotnikY < 421) {
                xsp = gsp * cos(0) * 0.96875;
                sonicX = sonicX + xsp;
                robotnikX = robotnikX + xsp;
                terrainMovementX = terrainMovementX + xsp;
            }
        }

        //jumping!
        if (jump) {
            if (sonicY == 432) {
                jmp = -6.5;
            }
        }
        if (falling == true) {
            if (sonicY <= 432 && robotnikY <= 421) {
                ysp += jmp;
                sonicY = sonicY + ysp;
                robotnikY = robotnikY + ysp;
                terrainMovementY = terrainMovementY - ysp;
                jmp = jmp + grv;
            }
            if (ysp > 16) {
                ysp = 16;
            }
            if (sonicY >= 432) {
                sonicY = 432;
            }
            if (robotnikY >= 421) {
                robotnikY = 421;  
            }
            if(terrainMovementY <= 0){
                terrainMovementY = 0;
            }
        }

        if (moveLeft && rolling == false) {
            if (!(sonicY > 432 && robotnikY > 421)) {
                if (gsp > 0) {
                    gsp -= dec;
                } else if (gsp > -top) {
                    gsp -= acc;
                }
                xsp = gsp * cos(0);
            }

            if (sonicY > 432 && robotnikY > 421) {
                if (gsp > 0) {
                    gsp -= dec;
                } else if (gsp > -top) {
                    gsp -= accAir;
                }
                xsp = gsp * cos(0);
                if (xsp <= -0.125) {
                    xsp = xsp * 0.96875;
                }
            }
            sonicX = sonicX - (-1 * xsp);
            robotnikX = robotnikX - (-1 * xsp);
            terrainMovementX = terrainMovementX - (-1 * xsp);
        }
        if (moveRight && rolling == false) {
            if (!(sonicY > 432 && robotnikY > 421)) {
                if (gsp < 0) {
                    gsp += dec;
                } else if (gsp < top) {
                    gsp += acc;
                }
                xsp = gsp * cos(0);
            }
            if (sonicY > 432 && robotnikY > 421) {
                if (gsp < 0) {
                    gsp += dec;
                } else if (gsp < top) {
                    gsp += acc;
                }
                xsp = gsp * cos(0);
                if (xsp >= 0.125) {
                    xsp = xsp * 0.96875;
                }
            }
            sonicX = sonicX + xsp;
            robotnikX = robotnikX + xsp;
            terrainMovementX = terrainMovementX - (-1 * xsp);
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
            //get the key code
            int keyCode = e.getKeyCode();
            //which key is being pressed
            if (keyCode == KeyEvent.VK_UP) {
                lookUp = true;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                rolling = true;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                moveLeft = true;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                moveRight = true;
            }
            if (keyCode == KeyEvent.VK_X) {
                jump = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            //get the key code
            int keyCode = e.getKeyCode();
            //which key is being pressed
            if (keyCode == KeyEvent.VK_UP) {
                lookUp = false;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                rolling = false;
            }
            if (keyCode == KeyEvent.VK_LEFT) {
                moveLeft = false;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                moveRight = false;
            }
            if (keyCode == KeyEvent.VK_X) {
                jump = false;
                falling = true;

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        SonicLeHedgehogRemake game = new SonicLeHedgehogRemake();
        playMusic("Sonic Team - Green Hill Zone.wav");
    }
}
