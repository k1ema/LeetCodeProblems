package math.GenerateRandomPointInACircle_478;

import java.util.Random;

public class Solution2 {
    private static final Random rnd = new Random();
    private double r, xc, yc;

    public Solution2(double radius, double x_center, double y_center) {
        this.r = radius;
        this.xc = x_center;
        this.yc = y_center;
    }

    public double[] randPoint() {
        double fi = rnd.nextDouble() * 2 * Math.PI;
        double R = Math.sqrt(rnd.nextDouble()) * r;
        return new double[] {xc + R * Math.cos(fi), yc + R * Math.sin(fi)};
    }
}
