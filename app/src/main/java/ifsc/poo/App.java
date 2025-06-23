package ifsc.poo;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

public class App {
    Draw draw;
    public App() {
        draw = new Draw();
        draw.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        draw.setCanvasSize(1000, 600);
        draw.setXscale(0, 1000);
        draw.setYscale(0, 600);
    }

    public static void main(String[] args) {
        App app = new App();
        app.draw.show();
    }
}
