public class Main {
    public static void main(String[] args) {
        Square square = new Square(6);
        Rectangle rectangle = new Rectangle(8.5, 2);
        Triangle triangle = new Triangle(5,2,3.333);
        Circle circle = new Circle(6.25);

        System.out.println("\t/// FIGURAS CON PERIMETRO Y AREA ///");
        System.out.println("== CUADRADO ==");
        System.out.println("Perimetro: "+square.perimeter()+" Area: "+square.area());
        System.out.println();
        square.printSquare();
        System.out.println();
        System.out.println("== TRIANGULO ==");
        System.out.println("Perimetro: " + triangle.perimeter() + " Area: " + triangle.area() + " Semiperimetro: "+triangle.semiperimeter());
        System.out.println();
        System.out.println("== CIRCULO ==");
        System.out.println("Perimetro: " + circle.perimeter() + " Area: " + circle.area());
        System.out.println();
        System.out.println("== RECTANGULO ==");
        System.out.println("Perimetro: " + rectangle.perimeter() + " Area: " + rectangle.area() + " Diagonal: "+rectangle.diagonal());
    }
}
