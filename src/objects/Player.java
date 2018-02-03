package objects;

import core.Animation;
import core.Assets;
import core.KeyInput;
import core.Main;

import java.awt.*;
public class Player extends Entity{
    private int speed = 4;
    private Animation anim;
    private KeyInput keyInput;
    private Main game;
    private double shipA = 0.2;

    public Player(Main game, double x, double y, double vx, double vy, double ax, double ay){
        super(x, y, vx, vy, ax, ay);
        this.game = game;
        anim = new Animation(200, Assets.player);
    }

    public void render(Graphics2D g){
//        g.drawImage(Assets.player, (int) x, (int) y, 32, 32, null);
        g.drawImage(anim.getCurrentFrame(), (int) x, (int) y, 64, 64, null);
//        g.setPaint(Color.GREEN);
//        g.fillOval(position.x, position.y, 50, 50);
    }

    public void tick(){
        anim.tick();
        input();
        vx += ax;
        vy += ay;
        x += vx;
        y += vy;
    }

    public void input(){
        int directions = 0;
        if(game.getKeyInput().up || game.getKeyInput().w){
            vy = -speed;
            directions++;
        }
        if(game.getKeyInput().down || game.getKeyInput().s){
            vy = speed;
            directions++;
        }
        if(game.getKeyInput().left || game.getKeyInput().a){
            vx = -speed;
            directions++;
        }
        if(game.getKeyInput().right || game.getKeyInput().d){
            vx = speed;
            directions++;
        }
        if(directions > 1){
            vx = vx * 0.7;
            vy = vy * 0.7;
        }
        else{
            if(vx > 0) ax = -shipA;
            else if(vx < 0) ax = shipA;
            if(vy > 0) ay = -shipA;
            else if(vy < 0) ay = shipA;

            if(vx >= -shipA*2 && vx <= shipA*2){
                ax = 0;
                vx = 0;
            }
            if(vy >= -shipA*2 && vy <= shipA*2){
                ay = 0;
                vy = 0;
            }
        }
    }

    @Override
    public void clickNotify(Point mousePos, boolean move, boolean click, boolean release) {
        //nothing yet, focusing on UI
    }

    @Override
    public boolean mouseCollide(Point mousePos) {
        return false;
    }
}
