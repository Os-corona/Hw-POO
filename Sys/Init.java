package Sys;

import clients.Client;
import products.Cleaning;
import products.Electrodomestico;
import products.Food;
import products.Makeup;

public class Init {

    public static void init(Store store){
        Food food = new Food("Pizza","12-04-2024",129.99,5,1050);
        store.getFoods().add(food);
        store.getProducts().add(food);

        Makeup makeup = new Makeup("Labial", "11-03-2024",30,2,"Rojo");
        store.getMakeups().add(makeup);
        store.getProducts().add(makeup);

        Electrodomestico electrodomestico = new Electrodomestico("Microondas","09-12-2023",1600,1,35);
        store.getElectrodomesticos().add(electrodomestico);
        store.getProducts().add(electrodomestico);

        Cleaning cleaning = new Cleaning("Detergente", "05-02-2024",40,18,"Limon");
        store.getCleaningProducts().add(cleaning);
        store.getProducts().add(cleaning);

        Client client = new Client("Oscar", "Corona","Morelia, Michoacan",18,11,2999.99);
        store.getClients().add(client);

        Client client2 = new Client("Samuel","Villegas","Tarimbaro, Michoacan",18,2,450);
        store.getClients().add(client2);
    }
}
