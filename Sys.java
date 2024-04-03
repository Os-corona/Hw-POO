import java.util.Scanner;
import java.time.LocalDate;
public class Sys {
    private final String password = "Z0O/1";
    static Scanner sc = new Scanner(System.in);
    public void system(Zoo zoo){
        int c = 0;
        String pass = "";
        System.out.println("===== BIENVENIDO AL SISTEMA DEL ZOOLOGICO =====\n");
        System.out.println("Ingrese la contraseña del sistema: ");
        pass = sc.nextLine();
        while (!pass.equals(password)) {
            c++;
            if (c == 5){
                System.out.println("Ha ingresado demasiadas veces la contraseña incorrecta...");
                return;
            }
            System.out.println("\nCONTRASEÑA INCORRECTA INTENTE DE NUEVO\n");
            System.out.println("Ingrese la contraseña del sistema: ");
            pass = sc.nextLine();
        }
        System.out.println("Contraseña correcta!");
        System.out.println("\n=== Bienvenido al Sistema!! ===\n");
        firstMenu(zoo);
    }

    private void firstMenu(Zoo zoo){
        boolean flag = true;
        while (flag) {
            System.out.println("\n\t== Que desea realizar: ==");
            System.out.println("1. Registrar");
            System.out.println("2. Revisar");
            System.out.println("3. Dirigir");
            System.out.println("4. Modificar");
            System.out.println("5. Cerrar programa");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    register(zoo);
                    break;
                case 2:
                    data(zoo);
                    break;
                case 3:
                    directions(zoo);
                    break;
                case 4:
                    edit(zoo);
                    break;
                case 5:
                    System.out.println("\nGRACIAS POR UTILIZAR EL SISTEMA!\n");
                    flag = false;
                    break;
                default:
                    System.out.println("\nHa ingresado un numero incorrecto!!\n");
                    break;
            }
        }
    }

    private void register(Zoo zoo){
        boolean flag = true;

        System.out.println("\n\tHA SELECCIONADO REGISTRAR\n");

        while(flag) {
            System.out.println("\t\n== Que desea registrar: ==");
            System.out.println("1. Nuevo Empleado");
            System.out.println("2. Nuevo Animal");
            System.out.println("3. Nuevo Cliente");
            System.out.println("4. Registrar Visita");
            System.out.println("5. Volver al menu");

            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    zoo.registerEmployee();
                    break;
                case 2:
                    zoo.registerAnimal();
                    break;
                case 3:
                    zoo.registerClient();
                    break;
                case 4:
                    zoo.registerVisit();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("\nHa ingresado un numero no valido!!\n");
                    break;
            }
        }
    }

    private void data(Zoo zoo){
        boolean flag = true;

        System.out.println("\n\tHA SELECCIONADO REVISAR LOS DATOS DEL ZOO\n");
        while (flag){
            System.out.println("\t\n== Que desea consultar: ==");
            System.out.println("1. Empleados");
            System.out.println("2. Visitantes");
            System.out.println("3. Animales");
            System.out.println("4. Visitas");
            System.out.println("5. Asignacion de Empleados");
            System.out.println("6. Volver al menu");

            int opt = sc.nextInt();

            switch (opt){
                case 1:
                    zoo.printEmployees();
                    break;
                case 2:
                    zoo.printClients();
                    break;
                case 3:
                    zoo.printAnimals();
                    break;
                case 4:
                    zoo.printVisits();
                    break;
                case 5:
                    zoo.printOrders();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("\nHa ingresado un numero no valido!!\n");
                    break;
            }
        }
    }

    private void directions(Zoo zoo){
        System.out.println("\n\tHA SELECCIONADO DIRIGIR A LOS EMPLEADOS\n");
        zoo.orderMaintenance();
    }

    private void edit(Zoo zoo){
        boolean flag = true;
        System.out.println("\n\tHA SELECCIONADO MODIFICAR EL SISTEMA\n");

        while (flag) {
            System.out.println("\nDesea eliminar o modificar algo del sistema: ");
            System.out.println("1. Modificar");
            System.out.println("2. Eliminar");
            System.out.println("3. Volver al menu");

            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    modify(zoo);
                    break;
                case 2:
                    delete(zoo);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void modify(Zoo zoo) {
        boolean flag = true;

        while (flag) {
            System.out.println("\nQue desea modificar: ");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");
            System.out.println("3. Animal");
            System.out.println("4. Volver");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> zoo.modifyClient();
                case 2 -> zoo.modifyEmployee();
                case 3 -> zoo.modifyAnimal();
                case 4 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta");
            }
        }
    }

    private void delete(Zoo zoo){
        boolean flag = true;

        while (flag) {
            System.out.println("\nQue desea eliminar: ");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");
            System.out.println("3. Animal");
            System.out.println("4. Volver");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> zoo.deleteClient();
                case 2 -> zoo.deleteEmployee();
                case 3 -> zoo.deleteAnimal();
                case 4 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta");
            }
        }
    }
}
