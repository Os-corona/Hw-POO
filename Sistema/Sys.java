package Sistema;

import java.util.*;

public class Sys {
    static Scanner sc = new Scanner(System.in);

    public static void sys(){
        System.out.println("Bienvenido!");
        System.out.println("Ingrese su usuario: ");
        String username = sc.nextLine();
        
        System.out.println("Ingrese su contraseña: ");
        String password = sc.nextLine();
    }

    private void clientMenu(){
        boolean flag = true;
        while (flag) {
            System.out.println("Bienvenido al menu de Cliente que desea realizar: ");
            System.out.println("1. Revisar Libros");
            System.out.println("2. Revisar mis rentas");
            System.out.println("3. Rentar libro");
            System.out.println("4. Salir");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> 
                case 2 ->
                case 3 ->
                case 4 -> flag = false;
                default -> System.out.println("ERROR");
            }
        }
    }

    private void workerMenu(){
        boolean flag = true;
        while (flag) {
            System.out.println("Bienvenido al menu de Trabajador que desea realizar: ");
            System.out.println("1. Revisar las rentas de libros");
            System.out.println("2. Revisar Clientes");
            System.out.println("3. Revisar Trabajadores");
            System.out.println("4. Registrar Usuario");
            System.out.println("5. Registrar Libro");
            System.out.println("6. Registrar Trabajador");
            System.out.println("7. Salir");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> 
                case 2 ->
                case 3 ->
                case 4 ->
                case 5 -> 
                case 6 ->
                case 7 -> flag = false;
                default -> System.out.println("ERROR");
            }
        }        
    }

    private void managerMenu(){
        boolean flag = true;
        while (flag) {
            System.out.println("Bienvenido al menu de Trabajador que desea realizar: ");
            System.out.println("1. Revisar las rentas de libros");
            System.out.println("2. Revisar Clientes");
            System.out.println("3. Revisar Trabajadores");
            System.out.println("4. Registrar Usuario");
            System.out.println("5. Registrar Libro");
            System.out.println("6. Registrar Trabajador");
            System.out.println("7. Despedir");
            System.out.println("8. Salir");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> 
                case 2 ->
                case 3 ->
                case 4 ->
                case 5 -> 
                case 6 ->
                case 7 -> 
                case 8 -> flag = false;
                default -> System.out.println("ERROR");
            }
        }
    }
}