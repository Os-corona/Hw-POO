public class Square implements Shape {
    double base;

    public Square(double base){
        this.base = base;
    }

    @Override
    public double perimeter() {
        return base * 4;
    }

    @Override
    public double area() {
        return base * base;
    }

    public void printSquare(){
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
