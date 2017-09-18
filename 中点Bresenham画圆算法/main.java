/**
 * Created by 我是姚七号 on 2017/9/18.
 */
public class main {
    public static void main(String args[]){
        int r= 8;
        int oneEighthPoints[][] = Bresenham.MidBresenhamCircle(r);
        display dis = new display(50,50,oneEighthPoints);
        int points[][] = dis.circle();
        dis.display(points);
    }
}
