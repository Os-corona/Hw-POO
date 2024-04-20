package Sistema;

import java.util.*;
import usuarios.Utils.Rol;
import utils.LogInUser;
import usuarios.User;

public class Sys {
    static Scanner sc = new Scanner(System.in);

    public static void sys(Library library){
        System.out.println("\nBienvenido!");
        boolean flag = true;
        while (flag) {
            System.out.println("\nDesea iniciar sesion o registrarse: ");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Cerrar programa");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> Sys.logIn(library);
                case 2 -> Sys.register(library);
                case 3 -> flag = false;
                default -> System.out.println("\nOpcion incorrecta");
            }
        }
    }

    private static void logIn(Library library){
        boolean flag = true;
        User logInUser = new User(null, null, null, null, null, null);
        do {
            System.out.println("Ingrese su usuario: ");
            String username = sc.next();
            
            System.out.println("Ingrese su contraseña: ");
            String password = sc.next();

            for (ArrayList<User> usuarios : library.getUsers().values()) {
                for (User usuarioABuscar : usuarios) {
                    if(usuarioABuscar.getUser().equals(username)){
                        logInUser = usuarioABuscar;
                        if(logInUser.getPassword().equals(password)){
                            flag = false;
                        }
                    }
                }
            }
            if (flag) {
                System.out.println("\nUsuario o contrasena incorrectas, intente de nuevo!\n");
            }
        } while (flag);
        LogInUser user = LogInUser.getInstancia();
        user.setUsuario(logInUser);

        switch (user.getUsuarioActual().getRol()) {
            case CLIENTE -> Sys.clientMenu(library);
            case TRABAJADOR -> Sys.workerMenu(library);
            case GERENTE -> Sys.managerMenu(library);        
        }
    }

    private static void register(Library library){
        System.out.println("Ingrese el tipo de cuenta a crear: ");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Manager");

        int opt = sc.nextInt();

        switch (opt) {
            case 1 -> library.registerClient();
            case 2 -> library.registerWorker();
            case 3 -> library.registerManager();
        }
    }

    private static void clientMenu(Library library){
        boolean flag = true;
        while (flag) {
            System.out.println("Bienvenido al menu de Cliente que desea realizar: ");
            System.out.println("1. Revisar Libros");
            System.out.println("2. Revisar mis rentas");
            System.out.println("3. Rentar libro");
            System.out.println("4. Salir");

            int opt = sc.nextInt();

            switch (opt) {
                case 1 -> flag = false;
                case 2 ->flag = false;
                case 3 ->flag = false;
                case 4 -> flag = false;
                default -> System.out.println("ERROR");
            }
        }
    }

    private static void workerMenu(Library library){
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
                case 1 -> flag = false;
                case 2 -> library.printClients();
                case 3 -> library.printWorkers();
                case 4 ->flag = false;
                case 5 -> flag = false;
                case 6 ->flag = false;
                case 7 -> flag = false;
                default -> System.out.println("ERROR");
            }
        }        
    }

    private static void managerMenu(Library library){
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
                case 1 -> flag = false;
                case 2 -> library.printClients();
                case 3 -> library.printWorkers();
                case 4 ->flag = false;
                case 5 -> flag = false;
                case 6 ->flag = false;
                case 7 -> flag = false;
                case 8 -> flag = false;
                default -> System.out.println("ERROR");
            }
        }
    }
}