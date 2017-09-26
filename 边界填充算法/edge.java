/**
 * Created by 我是姚七号 on 2017/9/26.
 */
public class edge {

    private double edge[][];
    private int edgeLength=0;

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

    public double[][] getEdge() {
        return edge;
    }
}
