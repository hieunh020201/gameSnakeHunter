import javax.swing.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class GameScreen extends JPanel implements Runnable{

    int [][] bg = new int[20][20];

    ConRan ran;
    Thread thread;
    public GameScreen(){
        ran = new ConRan();

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
        for(int i=0;i<20;i++)
            for(int j=0;j<20;j++){
                if(bg[i][j]==0)
                    g.setColor(Color.gray);
                if(bg[i][j]==1)
                    g.setColor(Color.red);
                if(bg[i][j]==2)
                    g.setColor(Color.yellow);
                g.fillRect(i*20, j*20, 20, 20);
            }
    }

    public void paint(Graphics g){
        paintBg(g);
        ran.veRan(g);
    }
}
