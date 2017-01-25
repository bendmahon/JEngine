package core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage loadImage(String path){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            System.out.println("Error loading image from " + path);
            e.printStackTrace();
            System.exit(-1);
        }
        return image;
    }
}
