public class Main {

    public static void main(String[] args) {
	    point p[] = new point[4];
        p[0] = new point(2,2);
        p[1] = new point(2,5);
        p[2] = new point(5,5);
        p[3] = new point(5,2);
        int col = 7, line = 7;
        edgeFlag ef = new edgeFlag(col,line);
        ef.initEdge(p);
        ef.initPicture();
        double points[][] = ef.getPoint();
        for(int i=0; i<col; i++){
            for(int j=0; j<line; j++){
                int value = (int)points[i][j];
                System.out.printf("%3d", value);
            }
            System.out.println();
        }

    }
}
