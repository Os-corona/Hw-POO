public class Rectangle implements Shape{
    double base;
    double height;

    public Rectangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public double perimeter() {
        return base + base + height + height;
    }

    @Override
    public double area() {
        return base * height;
    }

    public double diagonal(){
        return Math.sqrt(base * base + height * height);
    }
}
