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
        do {
            c++;
            if (c == 5){
                System.out.println("Ha ingresado demasiadas veces la contraseña incorrecta...");
                return;
            }
            System.out.println("\nCONTRASEÑA INCORRECTA INTENTE DE NUEVO\n");
            System.out.println("Ingrese la contraseña del sistema: ");
            pass = sc.nextLine();
        } while (!pass.equals(password));
        System.out.println("Contraseña correcta!");
        System.out.println("\n=== Bienvenido al Sistema!! ===\n");
        firstMenu(zoo);
    }

    private void firstMenu(Zoo zoo){
        boolean flag = true;
        while (flag) {
            System.out.println("\t== Que desea realizar: ==");
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
                    modify(zoo);
                    break;
                default:

                    break;
            }
        }
    }

    private void register(Zoo zoo){
        System.out.println("\n\tHA SELECCIONADO REGISTRAR\n");
        System.out.println("\t== Que desea registrar: ==");
        System.out.println("1. Nuevo Empleado");
        System.out.println("2. Nuevo Animal");
        System.out.println("3. Nuevo Cliente");
        System.out.println("4. Registrar Visita");
        System.out.println("5. Volver al menu");

        int opt = sc.nextInt();

        switch (opt){
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
        }
    }

    private void data(Zoo zoo){

    }

    private void directions(Zoo zoo){

    }

    private void modify(Zoo zoo){

    }

}
