package Sys;
import java.util.Scanner;
public class Menu {
    private static Scanner sc = new Scanner(System.in);
    public static void logIn(Store store){
        System.out.println("|| BIENVENIDO AL SISTEMA DE LA TIENDA! ||");
        System.out.println("\nPorfavor ingrese la contrasena para acceder al sistema: ");
        String pass = sc.next();

        while (!pass.equals("tienda123")){
            System.out.println("\n|| Contrasena incorrecta, intente de nuevo: ||");
            pass = sc.next();
        }

        System.out.println("\n|| Ha ingresado la contrasena correcta!! ||");
        firstMenu(store);
    }

    private static void firstMenu(Store store){
        boolean flag = true;

        while (flag) {
            System.out.println("\n== QUE DESEA HACER EL DIA DE HOY ==");
            System.out.println("1. Registrar");
            System.out.println("2. Imprimir datos");
            System.out.println("3. Modificar productos");
            System.out.println("4. Eliminar");
            System.out.println("5. Realizar compra");
            System.out.println("6. Cerrar programa");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> register(store);
                case 2 -> prints(store);
                case 3 -> modify(store);
                case 4 -> delete(store);
                case 5 -> buyOrder(store);
                case 6 -> {
                    flag = false;
                    System.out.println("\n== GRACIAS POR USAR EL SISTEMA ==");
                }
                default -> System.out.println("Opcion ingresada incorrecta!");
            }

        }
    }

    private static void register(Store store){
        boolean flag = true;

        while (flag) {
            System.out.println("\n== QUE DESEA REGISTRAR: ==");
            System.out.println("1. Producto");
            System.out.println("2. Cliente");
            System.out.println("3. Volver");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> store.registerProduct();
                case 2 -> store.registerClient();
                case 3 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta!");
            }
        }
    }

    private static void prints(Store store){
        boolean flag = true;

        while (flag) {
            System.out.println("\n== QUE DESEA IMPRIMIR: ==");
            System.out.println("1. Productos maquillaje");
            System.out.println("2. Productos comida");
            System.out.println("3. Productos limpieza");
            System.out.println("4. Productos electrodomesticos");
            System.out.println("5. Clientes");
            System.out.println("6. Compras");
            System.out.println("7. Volver al menu");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> store.printMakeup();
                case 2 -> store.printFood();
                case 3 -> store.printCleaning();
                case 4 -> store.printElectrodomestico();
                case 5 -> store.printClients();
                case 6 -> store.printOrder();
                case 7 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta!");
            }
        }
    }

    private static void modify(Store store){
        boolean flag = true;
        while (flag) {
            System.out.println("\n== QUE DESEA MODIFICAR ==");
            System.out.println("1. Productos");
            System.out.println("2. Clientes");
            System.out.println("3. Volver al menu");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> store.modifyProduct();
                case 2 -> store.modifyClient();
                case 3 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta!");
            }
        }
    }

    private static void delete(Store store){
        boolean flag = true;
        while (flag) {
            System.out.println("\n== QUE DESEA ELIMINAR ==");
            System.out.println("1. Productos");
            System.out.println("2. Clientes");
            System.out.println("3. Volver al menu");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> store.deleteProduct();
                case 2 -> store.deleteClient();
                case 3 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta!");
            }
        }
    }

    private static void buyOrder(Store store){
        System.out.println("\n== INGRESE LOS DATOS DE LA COMPRA ==");
        store.buyOrder();
    }
}
