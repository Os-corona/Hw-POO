package Sys;

import clients.Client;
import clients.Order;
import products.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Makeup> makeups = new ArrayList<>();
    private ArrayList<Cleaning> cleaningProducts = new ArrayList<>();
    private ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void registerProduct(){
        String types = "comidaelectrodomesticomaquillajelimpieza";
        System.out.println("\nIngrese el nombre del producto: ");
        String name = sc.next();

        System.out.println("\nIngrese el precio: ");
        double price = sc.nextDouble();

        System.out.println("\nCual sera el stock inicial: ");
        int stock = sc.nextInt();

        System.out.println("\nQue dia se importo el producto: ");
        String importDate = sc.next();

        System.out.println("\nQue tipo de producto sera: (Comida / Electrodomestico / Limpieza / Maquillaje)");
        String type = sc.next();

        while (!types.contains(type)){
            System.out.println("\nTipo no reconocido por el sistema, ingrese uno valido: ");
            type = sc.next();
        }

        switch (type.toLowerCase()){
            case "comida" :
                System.out.println("\nCuales son las calorias del producto: ");
                int calories = sc.nextInt();
                Food food = new Food(name, importDate, price, stock, calories);
                foods.add(food);
                products.add(food);
                break;
            case "electrodomestico":
                System.out.println("\nIngrese la energia que gasta: (En Watts)");
                double energyUsed = sc.nextDouble();
                Electrodomestico electrodomestico = new Electrodomestico(name, importDate, price, stock, energyUsed);
                electrodomesticos.add(electrodomestico);
                products.add(electrodomestico);
                break;
            case "limpieza" :
                System.out.println("\nQue aroma tiene el producto: ");
                String aroma = sc.next();
                Cleaning cleaning = new Cleaning(name, importDate, price, stock, aroma);
                cleaningProducts.add(cleaning);
                products.add(cleaning);
                break;
            case "maquillaje" :
                System.out.println("\nDe que color es el maquillaje: ");
                String color = sc.next();
                Makeup makeup = new Makeup(name, importDate, price, stock ,color);
                makeups.add(makeup);
                products.add(makeup);
                break;
        }
        System.out.println("\n== SE HA REGISTRADO EL PRODUCTO CORRECTAMENTE ==");
    }

    public void registerClient(){
        System.out.println("Ingrese el nombre del cliente: ");
        String name = sc.next();

        System.out.println("Ingrese el apellido del cliente: ");
        String lastName = sc.next();

        System.out.println("Ingrese la edad del cliente: ");
        int age = sc.nextInt();

        System.out.println("Ingrese la direccion del cliente: ");
        String address = sc.next();

        System.out.println("Cual es el saldo del cliente: ");
        double wallet = sc.nextDouble();

        Client client = new Client(name, lastName, address, age, wallet);
        clients.add(client);
        System.out.println("\n== SE HA REGISTRADO EL CLIENTE CORRECTAMENTE ==");
    }

    public void printMakeup(){
        if (makeups.isEmpty()){
            System.out.println("\n== NO HAY PRODUCTOS EN EL SISTEMA ==");
            return;
        }
        System.out.println("\n== LISTA DE PRODUCTOS DE MAQUILLAJE ==");
        for (Makeup makeup : makeups) {
            System.out.printf("=== PRODUCTO %s: ===\n", makeup.getSeriesNumber());
            System.out.printf("""
                    \tNombre: %s Precio: %f Fecha Importe: %s
                    \tStock: %d Color: %s\s
                    """, makeup.getName(), makeup.getPrice(), makeup.getImportDate(), makeup.getStock(), makeup.getColor());
        }
    }

    public void printFood(){
        if (foods.isEmpty()){
            System.out.println("\n== NO HAY PRODUCTOS EN EL SISTEMA ==");
            return;
        }
        System.out.println("\n== LISTA DE PRODUCTOS DE COMIDA ==");
        for (Food food : foods) {
            System.out.printf("=== PRODUCTO %s: ===\n", food.getSeriesNumber());
            System.out.printf("""
                    \tNombre: %s Precio: %f Fecha Importe: %s
                    \tStock: %d Calorias: %s\s
                    """, food.getName(), food.getPrice(), food.getImportDate(), food.getStock(), food.getCalories());
        }
    }

    public void printCleaning(){
        if (cleaningProducts.isEmpty()){
            System.out.println("\n== NO HAY PRODUCTOS EN EL SISTEMA ==");
            return;
        }
        System.out.println("\n== LISTA DE PRODUCTOS DE LIMPIEZA ==");
        for (Cleaning cleaning : cleaningProducts) {
            System.out.printf("=== PRODUCTO %s: ===\n", cleaning.getSeriesNumber());
            System.out.printf("""
                    \tNombre: %s Precio: %f Fecha Importe: %s
                    \tStock: %d Aroma: %s\s
                    """, cleaning.getName(), cleaning.getPrice(), cleaning.getImportDate(), cleaning.getStock(), cleaning.getAroma());
        }
    }

    public void printElectrodomestico(){
        if (electrodomesticos.isEmpty()){
            System.out.println("\n== NO HAY PRODUCTOS EN EL SISTEMA ==");
            return;
        }
        System.out.println("\n== LISTA DE PRODUCTOS ELECTRODOMESTICOS ==");
        for (Electrodomestico electrodomestico : electrodomesticos) {
            System.out.printf("=== PRODUCTO %s: ===\n", electrodomestico.getSeriesNumber());
            System.out.printf("""
                    \tNombre: %s Precio: %f Fecha Importe: %s
                    \tStock: %d Watts: %s\s
                    """, electrodomestico.getName(), electrodomestico.getPrice(), electrodomestico.getImportDate(), electrodomestico.getStock(), electrodomestico.getEnergyUsed());
        }
    }

    public void printClients(){
        if (clients.isEmpty()){
            System.out.println("\n== NO HAY CLIENTES EN EL SISTEMA ==");
            return;
        }
        System.out.println("\n== LISTA DE CLIENTES ==");
        for (Client client: clients){
            System.out.printf("=== CLIENTE %s: ===\n", client.getId());
            System.out.printf("\tNombre: %s %s Edad: %d Direccion: %s Compras Totales: %d Saldo: %f\n",
                    client.getName(),client.getLastName(),client.getAge(),client.getAddress(),client.getTimesBought(),client.getWallet());
        }
    }

    public void printOrder(){
        if (orders.isEmpty()){
            System.out.println("\n== NO HAY COMPRAS EN EL SISTEMA ==");
            return;
        }
        System.out.println("\n== LISTA DE COMPRAS ==");
        for (Order order : orders){
            System.out.printf("Cliente: %s Precio Total: %f Fecha: %s\n",
                    order.getName(),order.getTotalPrice(),order.getDate());
            order.printProducts();
        }
    }

    public void buyOrder(){
        ArrayList<String> productNames = new ArrayList<>();
        double totalPrice = 0 ;

        if (clients.isEmpty()){
            System.out.println("\n== NO HAY CLIENTES EN EL SISTEMA ==");
            return;
        }

        if (electrodomesticos.isEmpty() && makeups.isEmpty() && cleaningProducts.isEmpty() && foods.isEmpty()){
            System.out.println("\n== NO HAY PRODUCTOS EN EL SISTEMA ==");
            return;
        }

        printClients();
        System.out.println("Quien va a realizar la compra: (Ingrese su ID)");
        String id = sc.next();

        while (!FindID.clientExists(this.clients,id)){
            System.out.println("\nID NO RECONOCIDO, INGRESE OTRO: ");
            id = sc.next();
        }
        Client client = FindID.findClient(clients, id);
        String clientName = STR."\{FindID.findClient(clients, id).getName()} \{FindID.findClient(clients, id).getLastName()}";

        if (!cleaningProducts.isEmpty()){printCleaning();}
        if (!electrodomesticos.isEmpty())printElectrodomestico();
        if (!foods.isEmpty())printFood();
        if (!makeups.isEmpty())printMakeup();

        while (true){
            double price = 0;
            System.out.println("Ingrese el numero de serie de los productos que compro el cliente: (fin para salir)");
            String seriesNumber = sc.next();

            if (seriesNumber.equalsIgnoreCase("fin")){
                break;
            }
            if (FindID.productExists(products, seriesNumber) && client.getWallet() >= FindID.findProduct(products, seriesNumber).getPrice()){
                price = FindID.findProduct(products, seriesNumber).getPrice();
                String productName = FindID.findProduct(products, seriesNumber).getName();
                FindID.findProduct(products, seriesNumber).reduceStock(1);
                productNames.add(productName);
                totalPrice += price;
                client.reduceWallet(price);
                System.out.println("SE AGREGO EL PRODUCTO CORRECTAMENTE\n");
            } else if (client.getWallet() < FindID.findProduct(products, seriesNumber).getPrice()) {
                System.out.println("\nEL CLIENTE NO TIENE SUFICIENTES FONDOS PARA HACER LA COMPRA\n");
            }
        }
        if (productNames.isEmpty()){
            System.out.println("\nNO SE PUDO REGISTRAR LA COMPRA, DEBIDO A QUE NO HAY PRODUCTOS");
            return;
        }
        String date = LocalDate.now().toString();
        Order order = new Order(clientName,productNames,totalPrice,date);
        orders.add(order);
        System.out.println("\n== SE HA REGISTRADO LA COMPRA CORRECTAMENTE ==");
    }

    public void modifyProduct(){
        if (!cleaningProducts.isEmpty()){printCleaning();}
        if (!electrodomesticos.isEmpty())printElectrodomestico();
        if (!foods.isEmpty())printFood();
        if (!makeups.isEmpty())printMakeup();

        System.out.println("Ingrese el numero de serie del producto a modificar: ");
        String seriesNumber = sc.next();

        while (!FindID.productExists(products, seriesNumber)){
            System.out.println("Ingrese el numero de serie del producto a modificar: ");
            seriesNumber = sc.next();
        }

        boolean flag = true;
        Product product = FindID.findProduct(products, seriesNumber);

        while (flag) {
            System.out.println("\nQue desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Precio");
            System.out.println("3. Stock");
            System.out.println("4. Salir");

            int opt = sc.nextInt();

            switch (opt){
                case 1 -> product.setName();
                case 2 -> product.setPrice();
                case 3 -> product.changeStock();
                case 4 -> flag = false;
                default -> System.out.println("\nOpcion ingresada incorrecta!");
            }
        }
    }

    public void modifyClient(){
        printClients();

        System.out.println("Ingrese el ID del cliente a modificar: ");
        String id = sc.next();

        while (!FindID.clientExists(clients, id)){
            System.out.println("\nIngrese el ID del cliente a modificar: ");
            id = sc.next();
        }

        boolean flag = true;
        Client client = FindID.findClient(clients, id);

        while (flag) {
            System.out.println("\nQue desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Saldo");
            System.out.println("3. Numero de Compras");
            System.out.println("4. Salir");

            int opt = sc.nextInt();

            switch (opt){
                case 1 -> client.setName();
                case 2 -> client.setWallet();
                case 3 -> client.setTimesBought();
                case 4 -> flag = false;
                default -> System.out.println("\nOpcion ingresada incorrecta!");
            }
        }
    }

    public void deleteClient(){
        printClients();

        System.out.println("Ingrese el ID del cliente a eliminar: ");
        String id = sc.next();

        while (!FindID.clientExists(clients, id)){
            System.out.println("\nIngrese el ID del cliente a eliminar: ");
            id = sc.next();
        }
        Client client = FindID.findClient(clients,id);
        System.out.printf("\n== SE HA ELIMINADO A %s CORRECTAMENTE ==",
                client.getName().toUpperCase());
        clients.remove(client);
    }

    public void deleteProduct(){
        String types = "comidaelectrodomesticomaquillajelimpieza";

        System.out.println("\nQue tipo de producto desea eliminar: ");
        String type = sc.next();

        while (!types.contains(type.toLowerCase())){
            System.out.println("\nTIPO INCORRECTO, INGRESE OTRO");
            System.out.println("\nQue tipo de producto desea eliminar: ");
            type = sc.next();
        }

        switch (type.toLowerCase()){
            case "comida" -> deleteFood();
            case "electrodomestico" -> deleteElectrodomestico();
            case "maquillaje" -> deleteMakeup();
            case "limpieza" -> deleteCleaning();
        }
    }

    public void deleteFood(){
        printFood();
        System.out.println("Ingrese el numero de serie del producto a modificar: ");
        String seriesNumber = sc.next();

        while (!FindID.productExists(products, seriesNumber)){
            System.out.println("\nNUMERO INCORRECTO");
            System.out.println("\nIngrese el numero de serie del producto a modificar: ");
            seriesNumber = sc.next();
        }

        Product product = FindID.findProduct(products, seriesNumber);
        products.remove(product);
        foods.remove(product);
        System.out.println("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==");
    }

    public void deleteCleaning(){
        printCleaning();
        System.out.println("Ingrese el numero de serie del producto a modificar: ");
        String seriesNumber = sc.next();

        while (!FindID.productExists(products, seriesNumber)){
            System.out.println("\nNUMERO INCORRECTO");
            System.out.println("\nIngrese el numero de serie del producto a modificar: ");
            seriesNumber = sc.next();
        }

        Product product = FindID.findProduct(products, seriesNumber);
        products.remove(product);
        cleaningProducts.remove(product);
        System.out.println("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==");
    }

    public void deleteElectrodomestico(){
        printElectrodomestico();
        System.out.println("Ingrese el numero de serie del producto a modificar: ");
        String seriesNumber = sc.next();

        while (!FindID.productExists(products, seriesNumber)){
            System.out.println("\nNUMERO INCORRECTO");
            System.out.println("\nIngrese el numero de serie del producto a modificar: ");
            seriesNumber = sc.next();
        }

        Product product = FindID.findProduct(products, seriesNumber);
        products.remove(product);
        electrodomesticos.remove(product);
        System.out.println("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==");
    }

    public void deleteMakeup(){
        printMakeup();
        System.out.println("Ingrese el numero de serie del producto a modificar: ");
        String seriesNumber = sc.next();

        while (!FindID.productExists(products, seriesNumber)){
            System.out.println("\nNUMERO INCORRECTO");
            System.out.println("\nIngrese el numero de serie del producto a modificar: ");
            seriesNumber = sc.next();
        }

        Product product = FindID.findProduct(products, seriesNumber);
        products.remove(product);
        makeups.remove(product);
        System.out.println("\n== SE HA ELIMINADO CORRECTAMENTE EL PRODUCTO ==");
    }

    public ArrayList<Makeup> getMakeups() {
        return makeups;
    }

    public ArrayList<Cleaning> getCleaningProducts() {
        return cleaningProducts;
    }

    public ArrayList<Electrodomestico> getElectrodomesticos() {
        return electrodomesticos;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
