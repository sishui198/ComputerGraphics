/**
 * Created by 我是姚七号 on 2017/9/26.
 */
public class filling {
    private int col;
    private int line;
    private int points[][];
    private double edge[][];
    private point seed;
    private stackforPoint stack = new stackforPoint(100);//size不好确定

    public filling(int col, int line, double edge[][], point seed) {
        this.col = col;
        this.line = line;
        this.edge = edge;
        this.seed = seed;
        points = new int[col][line];
    }

    public void fill(){
        for(int i=0; i<edge.length; i++){
            points[(int)edge[i][0]][(int)edge[i][1]] = 1;
        }
        if(stack.push(seed)==false){
          //  System.out.println("error1.");
            System.exit(1);
        }
        while(stack.isEmpty()==false){
            point newp = stack.pop();
            if(newp==null){
                System.exit(2);
            }
            points[newp.getX()][newp.getY()] = 1;
            //以上下左右的顺序检查像素的4-邻接点
            //上
            if(newp.getX()+1<col&&points[newp.getX()+1][newp.getY()] == 0){
                stack.push(new point(newp.getX()+1,newp.getY()));
            }
            //下
            if(newp.getX()-1>=0&&points[newp.getX()-1][newp.getY()] == 0){
                stack.push(new point(newp.getX()-1,newp.getY()));
            }
            //左
            if(newp.getY()-1>=0&&points[newp.getX()][newp.getY()-1] == 0){
                stack.push(new point(newp.getX(),newp.getY()-1));
            }
            //右
            if(newp.getY()+1<line&&points[newp.getX()][newp.getY()+1] == 0){
                stack.push(new point(newp.getX(),newp.getY()+1));
            }
        }
    }
    public void display(){
        for(int i=0; i<col; i++){
            for(int j=0; j<line; j++){
                System.out.printf("%3d",points[i][j]);
            }
            System.out.println();
        }
    }
}
