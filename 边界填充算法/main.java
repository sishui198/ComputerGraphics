/**
 * Created by 我是姚七号 on 2017/9/26.
 */
public class main {
    public static void main(String args[]){
        point points[] = new point[5];
        points[0] = new point(2,1);
        points[1] = new point(2,4);
        points[2] = new point(4,6);
        points[3] = new point(6,4);
        points[4] = new point(6,1);
        point seed = new point(3,3);
        int col = 9, line = 9;
        edge e = new edge();
        e.initEdge(points);
        filling fill = new filling(col,line,e.getEdge(),seed);
        fill.fill();
        fill.display();
    }
}
