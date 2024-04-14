package products;

public class Food extends Product{
    int calories;

    public Food(String name, String importDate, double price, int stock, int calories) {
        super(name, importDate, price, stock);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}
