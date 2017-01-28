package objects;

import core.Animation;
import core.Assets;
import core.KeyInput;
import core.Main;

import java.awt.*;

public class Player extends Entity{
    private int speed = 1;
    private Animation anim;
    private KeyInput keyInput;
    private Main game;

    public Player(Main game, Point position, Point velocity, Point accleration){
        super(position, velocity, accleration);
        this.game = game;
        anim = new Animation(200, Assets.player);
    }

    public void render(Graphics2D g){
//        g.drawImage(anim.getCurrentFrame(), position.x, position.y, 32, 32, null);
        g.setPaint(Color.GREEN);
        g.fillOval(position.x, position.y, 50, 50);
    }

    public void tick(){
//        anim.tick();
        input();
        position.x += velocity.x;
        position.y += velocity.y;
    }

    public void input(){
        velocity = new Point(0,0);
        if(game.getKeyInput().up || game.getKeyInput().w){
            velocity.y = -speed;
        }
        if(game.getKeyInput().down || game.getKeyInput().s){
            velocity.y = speed;
        }
        if(game.getKeyInput().left || game.getKeyInput().a){
            velocity.x = -speed;
        }
        if(game.getKeyInput().right || game.getKeyInput().d){
            velocity.x = speed;
        }
    }
}
