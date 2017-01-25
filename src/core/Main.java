package core;

import objects.Planet;
import objects.Player;
import ui.AtmosphereBar;
import ui.StatBar;
import ui.TemperatureBar;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Main extends Canvas implements Runnable {
    private static final int WIDTH = (int) 990;
    private static final int HEIGHT = (int) 990;

    private final String title = "Game";

    private boolean running = false;
    private Thread thread;

    private Random rand = new Random();

    private KeyInput keyInput = new KeyInput();

    private Planet planet = null;
    private StatBar tempBar = null;
    private StatBar atmoBar = null;
    private synchronized void start() {
        addKeyListener(keyInput);
        addMouseListener(new MouseInput());
        this.requestFocus();

        Assets.init();
//        player = new Player(this, new Point(100, 100), new Point(0,0));
        planet = new Planet(new Point(445,445), new Point(0,0), 1.0, 0.0);
        tempBar = new TemperatureBar(new Point(600, 600), new Point(50, 150), planet,
                Color.decode("#00ABFF"), Color.decode("#FF0000"));
        atmoBar = new AtmosphereBar(new Point(675, 600), new Point(50, 150), planet,
                Color.decode("#333333"), Color.decode("#00D5FF"));
        //Create thread
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop(){
        if(!running) return;

        running = false;
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void run(){
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                System.out.println(frames);
                System.out.println(updates);
                timer += 1000;
                updates = 0;
                frames = 0;

            }
        }
        stop();
    }

    private void tick(){
        keyInput.tick();
        planet.tick();
        tempBar.tick();
        atmoBar.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs==null){
            createBufferStrategy(2);
            return;
        }

        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        /**
         * DRAW STUFF UNDER HERE
         * Like "g2d.(BufferedImage object, int x, int y, this)"
         */
        //Clear screen
        g2d.setPaint(new Color(20, 20, 20));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        //draw stuff
        planet.render(g2d);
        tempBar.render(g2d);
        atmoBar.render(g2d);
        //Throw away drawings and show buffer
        g2d.dispose();
        bs.show();
    }

    public static void main(String args[]){
        Main game = new Main();
        game.setSize(WIDTH, HEIGHT);
        JFrame frame;
        frame = new JFrame(game.title);
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.setAutoRequestFocus(true);
        game.start();
    }

    /**
     * Gets the object responsibe for tracking key input
     * @return The Key Input tracker for the game
     */
    public KeyInput getKeyInput() {
        return keyInput;
    }

}
