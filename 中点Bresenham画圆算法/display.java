/**
 * Created by 我是姚七号 on 2017/9/18.
 */
public class display {
    int line;//行
    int col;//列
    int num;//有多少个点
    int points[][];

    public display(int line, int col, int[][] points) {
        this.line = line;
        this.col = col;
        this.points = points;
        num = points.length;
    }

    public int[][] circle(){
        int num = this.num*8;
        int circle[][] = new int[num][2];
        int j=0;
        for(int i=0; i<this.num; i++){
            circle[j][0] = points[i][0];
            circle[j++][1] = points[i][1];

            circle[j][0] = points[i][1];
            circle[j++][1] = points[i][0];

            circle[j][0] = -points[i][1];
            circle[j++][1] = points[i][0];

            circle[j][0] = -points[i][0];
            circle[j++][1] = points[i][1];

            circle[j][0] = -points[i][0];
            circle[j++][1] = -points[i][1];

            circle[j][0] = -points[i][1];
            circle[j++][1] = -points[i][0];

            circle[j][0] = points[i][1];
            circle[j++][1] = -points[i][0];

            circle[j][0] = points[i][0];
            circle[j++][1] = -points[i][1];
        }
        return circle;
    }

    public void display(int points[][]){
        int mid = line/2;
        int dis[][] = new int[line][col];
        for(int i=0; i<num*8; i++){
            dis[points[i][0]+mid][points[i][1]+mid] = 1;
        }
        for(int i=0; i<line; i++){
            for(int j=0; j<col; j++){
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }
    }
}
