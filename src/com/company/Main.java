package com.company;

public class Main {

    public static void main(String[] args) {
        point a = new point(1,3);
        point b = new point(5,7);
        DDA dda = new DDA(a,b);
        dda.DDALine();
        display disp = new display();
        disp.display(dda);
    }
}
