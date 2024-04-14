package products;

public class Electrodomestico extends Product{
    double energyUsed;

    public Electrodomestico(String name, String importDate, double price, int stock, double energyUsed) {
        super(name, importDate, price, stock);
        this.energyUsed = energyUsed;
    }

    public double getEnergyUsed() {
        return energyUsed;
    }
}
