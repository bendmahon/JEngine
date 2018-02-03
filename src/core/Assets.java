package core;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int DIM = 64;

    //Static Images
    public static BufferedImage background, asteroid, bullet;

    //core.Animation Arrays
    public static BufferedImage[] player;
//    public static BufferedImage[] laser;

    public static void init(){
        //Assign Spritesheets to core.Animation Arrays
//        SpriteSheet playerSpriteSheet = new SpriteSheet(ImageLoader.loadImage("sprites/walking.png"));
        //Initialize BufferedImage Arrays for Spritesheets
//        player = new BufferedImage[6];
//        for(int i = 0; i < 6; i++){
//            player[i] = playerSpriteSheet.crop(i, 0, DIM);
//        }
        SpriteSheet shipSheet = new SpriteSheet(ImageLoader.loadImage("spaceshipsheet.png"));
        player = new BufferedImage[4];
        for(int i = 0; i<4; i++){
            player[i] = shipSheet.crop(i, 0, DIM);
        }

//        player = ImageLoader.loadImage("jeplayer.png");
        //column    //row   //side length
        //grass  = background.crop(0, 0, DIM);
//        asteroid = ImageLoader.loadImage("sprites/asteroid.png");
//        background = ImageLoader.loadImage("backgrounds/space_background.png");
//        bullet = ImageLoader.loadImage("sprites/bullet.png");
    }
}
