public class Triangle extends Shape{
    double part1;
    double part2;
    double part3;

    public Triangle(double part1, double part2, double part3){
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
    }

    @Override
    public double perimeter() {
        return part1 + part2 + part3;
    }

    @Override
    public double area() {
        double semi = semiperimeter();
        return Math.sqrt(semi * (semi - part1) * (semi - part2) * (semi - part3));
    }

    public double semiperimeter(){
        return (part1+part2+part3)/2 ;
    }
}
