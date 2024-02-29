public class Encapsu {

    public static void main(String[] args) {
        Product p1 = new Product("camara",11,51.1);
        System.out.println(p1.getName());
        System.out.println(p1.getPrice());
        System.out.println(p1.getStock());
        
        p1.setStock(8);
        System.out.println("Nuevo stock: "+p1.getStock());
        
        Product p2 = new Product("Telefono",2000.99);
        System.out.println(p2.getName());
        System.out.println(p2.getPrice());
        System.out.println(p2.getStock());
        p2.increaseStock(22);
        
        System.out.println(p2.getName());
        System.out.println(p2.getPrice());
        System.out.println(p2.getStock());
    }

}
