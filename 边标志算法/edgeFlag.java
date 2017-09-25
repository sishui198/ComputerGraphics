/**
 * Created by 我是姚七号 on 2017/9/25.
 */
public class edgeFlag {
    private int col;//行
    private int line;//列
    private double point[][];//显示的点
    private double edge[][];
    private int edgeLength=0;

    public edgeFlag(int line, int col) {
        this.line = line;
        this.col = col;
        this.point = new double[col][line];
    }

    public double[][] getPoint() {
        return point;
    }

    public void initEdge(point p[]){
        int nums = p.length;
        DDA ddas[] = new DDA[nums];
        for(int i=0; i<nums; i++){
            ddas[i] = new DDA(p[i%nums], p[(i+1)%nums]);
            ddas[i].DDALine();
            int pointsnum = ddas[i].getNum()+1;
            edgeLength += pointsnum;
        }
        edge = new double[edgeLength][2];
        int index = 0;//下标，给每个dege[i]赋值
        for(int i=0; i<nums; i++){
            double newp[][] = ddas[i].getP();
            for(int j=0; j<=ddas[i].getNum(); j++){
                edge[index][0] = newp[j][0];
                edge[index++][1] = newp[j][1];
               // System.out.printf("%f,%f",newp[j][0],newp[j][1]);
              //  System.out.println();
            }
        }

    }
    //点x,y是否在边上，是返回1，否则返回0
    public int isEdge(double x, double y){
        for(int i=0; i<edgeLength; i++){
            if(x==edge[i][0]&&y==edge[i][1])return 1;
            else continue;
        }
        return 0;
    }
    public void initPicture(){
        int flag = 0;
        for(int i=0; i<col; i++){
            for(int j=0; j<line; j++){
                if(isEdge(i,j)==0&&flag==0)
                    point[i][j]=0;
                else if(isEdge(i,j)==1&&flag==0){
                    point[i][j] = 1;
                    flag = 1;
                }else if(isEdge(i,j)==1&&flag==1){
                    point[i][j]=1;
                    flag = 0;
                }else if(isEdge(i,j)==0&&flag==1){
                    point[i][j] = 1;
                }
            }
        }
    }
}
