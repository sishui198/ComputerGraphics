/**
 * Created by 我是姚七号 on 2017/9/18.
 */
public class BresenhamForEllipse {
    static int[][] bresenham(int a, int b){
        int p[][] = new int[100][2];
        int x = 0;
        int y = b;
        int i = 0;//记录当前是第几个点，从0开始
        double d1, d2;
        d1 = b*b+a*a*(-b+0.25);
        p[i][0] = x;
        p[i++][1] = y;
        while(b*b*(x+1)<a*a*(y-0.5)){
            if(d1<=0){
                d1 += b*b*(2*x+3);
                x++;
            }else{
                d1 += b*b*(2*x+3)+a*a*(-2*y+2);
                x++;
                y--;
            }
            p[i][0] = x;
            p[i++][1]= y;
        }
        d2 = b*b*b*(x+0.5)*(x+0.5)+a*a*(y-1)*(y-1)-a*a*b*b;
        while (y>0){
            if(d2<=0){
                d2 +=b*b*(2*x+2)+a*a*(-2*y+3);
                x++;
                y--;
            }else{
                d2 += a*a*(-2*y+3);
                y--;
            }
            p[i][0] = x;
            p[i++][1]= y;
        }
        int point[][] = new int[i][2];
        for(int j=0; j<i; j++){
            point[j][0] = p[j][0];
            point[j][1] = p[j][1];
        }
        return point;
    }
}
