public class Hw3 {
    public static void main(String[] args) {
        System.out.println("Instancias de clase Persona: ");
        person p1 = new person("Alonso", 19, true);
        System.out.println(p1.toString());

        person p2 = new person("Mariana", 22, false);
        System.out.println(p2.toString());

        person p3 = new person("Cristian", 17, true);
        System.out.println(p3.toString());

        person p4 = new person("Cesar", 33, true);
        System.out.println(p4.toString());
        System.out.println();
        
        System.out.println("Instancias de clase Libro:");
        book b1 = new book();
        b1.author = "Saint-Exupery";
        b1.title = "El principito";
        b1.year = 1943;
        System.out.println(b1.toString());

        book b2 = new book();
        b2.author = "Stephen King";
        b2.title = "IT";
        b2.year = 1986;
        System.out.println(b2.toString());

        book b3 = new book();
        b3.author = "Franz Kafka";
        b3.title = "La Metamorfosis";
        b3.year = 1915;
        System.out.println(b3.toString());

        book b4 = new book();
        b4.author = "Kentaro Miura";
        b4.title = "Berserk";
        b4.year = 1989;
        System.out.println(b4.toString());
        System.out.println();

        System.out.println("Instancias de clase Rectangulo:");
        rectangle r1 = new rectangle(11.2, 5);
        System.out.println(r1.toString());

        rectangle r2 = new rectangle(20.3, 8.1);
        System.out.println(r2.toString());

        rectangle r3 = new rectangle(5, 2);
        System.out.println(r3.toString());

        rectangle r4 = new rectangle(Math.sqrt(16), 19.512);
        System.out.println(r4.toString());
    }        
}

class person{
    String name;
    int age;
    boolean isMale;

    public person(String n, int a, boolean im){
        name = n;
        age = a;
        isMale =im;
    }

    public String toString(){
        if (isMale) {
            return "Nombre: "+name+"\t Edad: "+age+"\t Genero: Hombre";
        } else {
            return "Nombre: "+name+"\t Edad: "+age+"\t Genero: Mujer";
        }
    }
}

class book{
    String title, author;
    int year;

    public String toString(){
        return "Titulo: "+title+"\t Autor: "+author+"\t Año: "+ year;
    }
}

class rectangle{
    double width, height;

    public rectangle(double b, double h){
        width = b;
        height = h;
    }

    public double P(){
        return (width*2) + (height*2);
    }

    public double A(){
         return width * height;
    }

    public String toString(){
        double x1 = 0, x2 = 0;
        x1 = this.P();
        x2 = this.A();
        return "Base: "+width+"\t Altura: "+height+"\t Perimetro: "+x1+"\t Area: "+x2;
    }
}