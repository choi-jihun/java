import java.util.Random;

class Solution {
    double radius;
    double x_center;
    double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        Random rand = new Random();
        while(true){
            double x_range = (radius + x_center) + (radius - x_center);
            double y_range = (radius + y_center) + (radius - y_center);
            double x = rand.nextDouble() * x_range + (x_center - radius);
            double y = rand.nextDouble() * y_range + (y_center - radius);
            double []coord = new double[2];
            if(Math.pow((x - x_center),2) + Math.pow((y - y_center),2) < Math.pow(radius,2)){
                coord[0] = x;
                coord[1] = y;
                return coord;
            }
        }
    }
}
