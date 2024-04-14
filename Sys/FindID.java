package Sys;

import clients.Client;
import products.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class FindID {
    static Scanner sc = new Scanner(System.in);

    public static boolean clientExists(ArrayList<Client> clients, String id){
        for (Client client : clients){
            if (client.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
    public static Client findClient(ArrayList<Client> clients, String id){
        for (Client client : clients){
            if (client.getId().equalsIgnoreCase(id)) {
                return client;
            }
        }
        return null;
    }
    public static boolean productExists(ArrayList<Product> products, String seriesNumber){
        for (Product product : products){
            if (product.getSeriesNumber().equalsIgnoreCase(seriesNumber)) {
                if (product.getStock() <= 0){
                    System.out.println("\nNO HAY STOCK DE ESE PRODUCTO");
                    return false;
                }
                return true;
            }
        }
        System.out.println("\nNO EXISTE EL NUMERO DE SERIE INGRESADO");
        return false;
    }

    public static Product findProduct(ArrayList<Product> products, String seriesNumber){
        for (Product product : products){
            if (product.getSeriesNumber().equalsIgnoreCase(seriesNumber)) {
                return product;
            }
        }
        return null;
    }
}
