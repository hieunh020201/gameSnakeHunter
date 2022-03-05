import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RanAnMoiJava extends JFrame {

    GameScreen game;

    public RanAnMoiJava(){
        setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new GameScreen();
        add(game);
        this.addKeyListener(new handler());

        setVisible(true);
    }

    public static void main(String[] args) {
        RanAnMoiJava f = new RanAnMoiJava();
    }
    private class handler implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                game.ran.setVector(ConRan.GO_UP);
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                game.ran.setVector(ConRan.GO_DOWN);
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                game.ran.setVector(ConRan.GO_LEFT);
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                game.ran.setVector(ConRan.GO_RIGHT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
