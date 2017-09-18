package com.company;

public class Main {

    public static void main(String[] args) {
        point a = new point(0,0);
        point b = new point(2,3);
        DDA dda = new DDA(a,b);
        dda.DDALine();
        display disp = new display();
        disp.display(dda);
    }
}
