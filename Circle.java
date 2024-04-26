public class Circle implements Shape{
    double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return (2 * radius) * Math.PI;
    }

    @Override
    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public static double diameterToRadius(double diameter){
        return diameter/2;
    }
}
