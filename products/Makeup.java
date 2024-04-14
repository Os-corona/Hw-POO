package products;

public class Makeup extends Product{
    String color;

    public Makeup(String name, String importDate, double price, int stock, String color) {
        super(name, importDate, price, stock);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
