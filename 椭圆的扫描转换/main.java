/**
 * Created by 我是姚七号 on 2017/9/18.
 */
public class main {
    public static void main(String args[]){
        int a = 8;
        int b = 5;
        int p[][] = BresenhamForEllipse.bresenham(a,b);
        display dis = new display(40,40,p);
        int points[][] = dis.circle();
        dis.display(points);
    }
}
