package clients;

import java.util.ArrayList;

public class Order {
    private String name;
    private ArrayList<String> products;
    private double totalPrice;
    private String date;

    public Order(String name, ArrayList<String> products, double totalPrice, String date) {
        this.name = name;
        this.products = products;
        this.totalPrice = totalPrice;
        this.date = date;
    }
    public void printProducts(){
        for (String product : products){
            System.out.println("\t"+product);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getDate() {
        return date;
    }
}
