package com.company;

/**
 * Created by 我是姚七号 on 2017/9/12.
 */
public class display {
    private int numofX = 10;
    private int numofY = 10;
    void display(DDA dda){
        int picture[][] = new int[numofX][numofY];
        int p[][] = dda.getP();
        for(int i=0; i<dda.getNum(); i++){
            picture[p[i][0]][p[i][1]] = 1;
        }
        for(int i=0; i<numofX; i++){
            for(int j=0; j<numofY; j++){
                System.out.printf("%3d",picture[i][j]);
            }
            System.out.println();
        }
    }
}
