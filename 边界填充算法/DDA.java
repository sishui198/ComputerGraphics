/**
 * Created by 我是姚七号 on 2017/9/25.
 */
public class DDA {
    private point a,b;
    private double p[][];//线段上的点
    private double dx,dy;
    private double epsilon;
    private int num;
    DDA(point a, point b){
        this.a = a;
        this.b = b;
        dx = a.getX()-b.getX();
        dy = a.getY()-b.getY();
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        if(dx>=dy){
            epsilon = 0;
        }else{
            epsilon = 1;
        }
    }
    public void DDALine(){
        int num;
        double k,dx1=dx,dy1=dy,x,y;
        if(a.getX()<=b.getX()){
            x = (int)(a.getX()+0.5);
            y = (int)(a.getY()+0.5);
            if(a.getY()>b.getY()){
                dy = -dy;
            }
            k = dy/dx;//斜率
        }else{
            x = (int)(b.getX()+0.5);
            y = (int)(b.getY()+0.5);
            if(b.getY()>a.getY()){
                dy = -dy;
            }
            k = dy/dx;
        }

        if(epsilon==0){//x
            num = (int)dx1;//需要描点的个数-1
            this.num = num;
            System.out.println("num1:"+num);
            p = new double[num+1][2];
            p[0][0] = x;
            p[0][1] = y;
            for(int i=1; i<=num; i++){
                x++;
                y=y+k;
                p[i][0]=x;
                p[i][1]=y;

            }
        }else{
            num = (int)(dy1);//需要描点的个数-1
            this.num = num;
            System.out.println("num2:"+num);
            p = new double[num+1][2];
            p[0][0] = x;
            p[0][1] = y;
            for(int i=1; i<=num; i++){//对于斜率为无穷大的分析
                if(k==Double.POSITIVE_INFINITY){
                    y++;
                    p[i][0]=x;
                    p[i][1]=y;
                }else if(k==Double.NEGATIVE_INFINITY){
                    y--;
                    p[i][0]=x;
                    p[i][1]=y;
                }else {
                    x = x + 1 / k;
                    y++;
                    p[i][0] = x;
                    p[i][1] = y;
                }

            }
        }
        for(int i=0; i<=num; i++){
            p[i][0] = (int)(p[i][0]+0.5);
            p[i][1] = (int)(p[i][1]+0.5);
            // System.out.printf("%d,%d\n",p[i][0],p[i][1]);
        }
    }

    public double[][] getP() {
        System.out.println("num="+num);
        for(int i=0; i<num; i++){
            System.out.printf("%f, %f\n",p[i][0],p[i][1]);
        }
        return p;
    }

    public int getNum() {
        return num;
    }
}