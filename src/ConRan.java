import java.awt.*;

public class ConRan {
    int doDai = 3;
    int []x;
    int []y;

//    biến tĩnh được tạo trước con rắn
    public static int GO_UP = 1;
    public static int GO_DOWN = -1;
    public static int GO_LEFT = 2;
    public static int GO_RIGHT = -2;

    int vector = ConRan.GO_DOWN;

    long t1=0;

    public ConRan() {
        x = new int[20];
        y = new int[20];

        x[0]=5;
        y[0]=4;

        x[1]=5;
        y[1]=3;

        x[2]=5;
        y[2]=2;
    }
    public void setVector(int v){
        if(vector != -v)
            vector = v;
    }
    public void update(){



        if(System.currentTimeMillis()-t1 >500){

            for(int i=doDai-1;i>0;i--) {
                x[i]=x[i-1];
                y[i]=y[i-1];
            }

            if(vector == ConRan.GO_UP)
                y[0]--;
            if(vector == ConRan.GO_DOWN)
                y[0]++;
            if(vector == ConRan.GO_LEFT)
                x[0]--;
            if(vector == ConRan.GO_RIGHT)
                x[0]++;

            if(x[0]<0)
                x[0]=19;
            if (x[0]>19)
                x[0]=0;
            if(y[0]<0)
                y[0]=19;
            if (y[0]>19)
                y[0]=0;
            t1 = System.currentTimeMillis();
        }

    }
    public void veRan(Graphics g){
        g.setColor(Color.red);
        for(int i=0;i<doDai;i++)
            g.fillRect(x[i]*20, y[i]*20, 20,20);
    }
}
