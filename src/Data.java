import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Data {
    public static Image imageHead;

    public static void loadImage() {
        try{
            imageHead = ImageIO.read(new File("res/snake_head.png"));
        }catch (Exception e){
        }
    }
}
