package products;

public class Cleaning extends Product{
    String aroma;

    public Cleaning(String name, String importDate, double price, int stock, String aroma) {
        super(name, importDate, price, stock);
        this.aroma = aroma;
    }

    public String getAroma() {
        return aroma;
    }
}
