/**
 * Created by 我是姚七号 on 2017/9/18.
 */
public class Bresenham {
    static int[][] MidBresenhamCircle(int r){
        int x = 0;
        int y = r;
        int d = 1-r;
        int num = (int)(((double)r/2.0)*Math.sqrt(2))+1;//点的个数
        int points[][] = new int[num][2];
        for(int i=0; i<num; i++){
            points[i][0] = x;
            points[i][1] = y;
            if(d<0){
                d+=2*x+3;
            }else{
                d+=2*(x-y)+5;
                y--;
            }
            x++;
        }
        return points;
    }
}
