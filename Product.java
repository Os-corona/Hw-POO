public class Product {

    private String name;
    private int stock;
    private double price;

    public void increaseStock(int stock) {
        if (stock <= 0) {
            System.out.println("Aumento nulo o negativo");
        } else {
            this.stock += stock;
        }
    }

    public void reduceStock(int stock) {
        if (stock <= 0 || stock >= this.stock) {
            System.out.println("Reduccion imposible");
        } else {
            this.stock -= stock;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equalsIgnoreCase("")) {
            System.out.println("Nombre nulo");
        } else {
            this.name = name;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            System.out.println("El stock no puede ser negativo");
        } else {
            this.stock = stock;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("El precio no puede ser negativo");
        } else {
            this.price = price;
        }
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.stock = 0;
    }

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

}
