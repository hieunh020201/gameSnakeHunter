import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import static java.lang.Thread.sleep;

public class GameScreen extends JPanel implements Runnable{

    static int [][] bg = new int[20][20];

    ConRan ran;
    Thread thread;
    public GameScreen(){
        ran = new ConRan();
        Data.loadImage();

        bg[10][10] = 2;

        thread = new Thread(this);
        thread.start();
    }
    public void run() {
        while(true) {
            ran.update();
            repaint();
            try {
                thread.sleep(20);
            }catch (InterruptedException ex) {}
        }
    }

    public void paintBg(Graphics g){
        g.setColor(Color.gray);
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++) {
                g.fillRect(i * 20, j * 20, 18, 18);
                if (bg[i][j] == 2)
                {
                    g.setColor(Color.red);
                    g.fillRect(i*20, j*20, 18, 18);
                    g.setColor(Color.gray);
                }
            }
    }

    public void paint(Graphics g){
        paintBg(g);
        ran.veRan(g);

        Image image = null;
        try{
            image = ImageIO.read(new File("res/snake_head.png"));
        }catch (Exception e) {
        }
    }
}
