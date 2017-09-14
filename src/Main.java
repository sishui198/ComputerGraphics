public class Main {

    public static void main(String[] args) {
        point a = new point(1,2);
        point b = new point(7,5);
        int x = 10, y = 10;
        Bresenham br = new Bresenham(a,b,x,y);
        int picture[][] = br.Bresenham();
        display dis = new display(x,y);
        dis.show(picture);

    }
}

class point{
    private int x,y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class Bresenham{//中点Bresenham,0<=k<=1
    private point a,b;
    //dx,dy,判别值d=dx-2dy;x0,y0为初始点坐标,k为斜率,b0为截距
    private double dx,dy,d,x0,y0,x1,y1,k,b0;
    private int line, col;
    Bresenham(point a, point b, int line, int col){
        dx = Math.abs(a.getX()-b.getX());
        dy = Math.abs(a.getY()-b.getY());
        k = dy/dx;
        this.line = line;
        this.col = col;
        if(k<0||k>1){
            System.exit(1);
        }else{
            d = dx-2*dy;

            if(a.getX()<=b.getX()){
                x0 = a.getX();
                y0 = a.getY();
            }else{
                x0 = b.getX();
                y0 = b.getY();
            }
            b0 = y0-k*x0;
            //计算x0,y0
            if(b0>=0){
                x0 = 0;
                y0 = b0;
            }else{
                y0 = 0;
                x0 = -b0/k;
            }
            //计算x1,y1
            y1 = k*line+b0;
            if(y1<col){
                x1 = line;
            }else{
                y1 = col;
                x1 = (y1-b0)/k;
            }
        }
    }
    int[][] Bresenham(){
        int p[][] = new int[line][2];
        int x,y;
        if((int)(y0+0.5)>(int)y0){
            y = (int)(y0+0.5);
            if((int)(x0+0.5)>(int)x0){
                x = (int)(x0+0.5);
            }else{
                x = (int)(x0);
            }
        }else{
            y = (int)(y0);
            if((int)(x0+0.5)>(int)x0){
                x = (int)(x0+0.5);
            }else{
                x = (int)(x0);
            }
        }
        int i = 0;//循环line次
        do{
            p[i][0] = x;
            p[i][1] = y;
            if(d<0){
                x++;
                y++;
                d +=2*dx-2*dy;
            }else{
                x++;
                d -=2*dy;
            }
            i++;
        }while(i<line);
        return p;
    }
}

class display{
    int line,col;

    public display(int line, int col) {
        this.line = line;
        this.col = col;
    }

    void show(int p[][]){
        int dis[][] = new int[line][col];
        for(int i=0; i<line; i++){
            dis[p[i][0]][p[i][1]]=1;
        }

        for(int i=0; i<line; i++){
            for(int j=0; j<col; j++){
                System.out.printf("%3d",dis[i][j]);
            }
            System.out.println();
        }
    }
}
