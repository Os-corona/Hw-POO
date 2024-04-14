package products;
import java.util.Scanner;
import java.util.Random;

public class Product {
    private String name;
    private String importDate;
    private String seriesNumber;
    private double price;
    private int stock;

    public Product(String name, String importDate, double price, int stock) {
        Random ran = new Random();
        this.name = name;
        this.importDate = importDate;
        this.seriesNumber = String.format("%06d",ran.nextLong(999998)+1);
        this.price = price;
        this.stock = stock;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cual sera el nuevo nombre del producto: ");
        String name = sc.next();
        this.name = name;
        System.out.println("\n= SE HA MODIFICADO CORRECTAMENTE EL NOMBRE =");
    }

    public java.lang.String getImportDate() {
        return importDate;
    }

    public void setImportDate(java.lang.String importDate) {
        this.importDate = importDate;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cual sera el nuevo nombre del producto: ");
        double price = sc.nextDouble();
        this.price = price;
        System.out.println("\n= SE HA MODIFICADO CORRECTAMENTE EL PRECIO =");
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void changeStock(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n|| Desea aumentar o disminuir el stock: ||");
        String opt = sc.next();

        while (!opt.equalsIgnoreCase("aumentar") && !opt.equalsIgnoreCase("disminuir")){
            System.out.println("\n||No ingreso una opcion correcta ingrese (aumentar) o (disminuir)! ||");
            opt = sc.next();
        }

        if (opt.equalsIgnoreCase("aumentar")){
            System.out.println("\n|| Cuanto stock desea aumentar: ||");
            int stock = sc.nextInt();
            while (stock <= 0){
                System.out.println("|| Cantidad menor o igual a 0, favor de ingresar una cantidad congruente! ||");
                stock = sc.nextInt();
            }
            this.stock += stock;
            System.out.println("\n=== SE HA AUMENTADO EL STOCK CON EXITO! ===");
        } else {
            System.out.println("\n|| Cuanto stock desea disminuir: ||");
            int stock = sc.nextInt();
            while (stock > this.stock){
                System.out.println("||Cantidad demasiado alta para disminuir, ingrese una menor cantidad: ||");
                stock = sc.nextInt();
            }
            this.stock -= stock;
            System.out.println("\n=== SE HA DISMINUIDO EL STOCK CON EXITO! ===");
        }
    }

    public void reduceStock(int a){
        this.stock -= a;
    }
}
