package usuarios;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import Sistema.utils.*;
import usuarios.Utils.*;

public class Worker extends User {
    private static Scanner sc = new Scanner(System.in);
    private LocalDate RegistrationDate;
    private double salary;

    public Worker(String nombre, String apellido, LocalDate birthday, String password, String username, double salary) {
        super(nombre, apellido, Rol.TRABAJADOR, birthday, password, username);
        this.RegistrationDate = LocalDate.now();
        this.salary = salary;
    }

    public LocalDate getFechaDeRegistro() {
        return RegistrationDate;
    }

    public double salary(){
        return this.salary;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s**", super.toString(), RegistrationDate.toString());
    }

    public static void registerWorker(HashMap<Rol , ArrayList<User>> users){
        ArrayList<String> commonData = CommonData.commonData(users);
        String name = commonData.get(0);
        String lastName = commonData.get(1);
        LocalDate birthday = LocalDate.parse(commonData.get(2));
        String username = commonData.get(3);
        String password = commonData.get(4);

        System.out.println("Ingrese el salario del trabajador: ");
        double salary = sc.nextDouble();

        Worker worker = new Worker(name, lastName, birthday, password, username, salary);

        users.get(Rol.TRABAJADOR).add(worker);

        System.out.println("El trabajador se registro con exito!");
    }

    public static void printWorkers(HashMap<Rol , ArrayList<User>> users){
        System.out.println("EMPLEADOS:");
        for (User usuarioAMostrar : users.get(Rol.TRABAJADOR)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
    }

    public static void modifyWorker(HashMap<Rol , ArrayList<User>> users){
        System.out.println("Ha seleccionado modificar o eliminar un trabajador!");
        printWorkers(users);
        System.out.println("Que trabajador desea modificar o eliminar: (Ingrese el ID)");
        String id = sc.next();

        User usuarioModificable = FindID.findWorker(users, id);

        while (usuarioModificable == null) {
            System.out.println("ID incorrecto ingresado");
            System.out.println("Que trabajador desea modificar o eliminar: (Ingrese el ID)");
            id = sc.next();
            usuarioModificable = FindID.findWorker(users, id);
        }
        System.out.println("Desea modificar o eliminar el usuario: ");
        String opt = sc.next();

        while (!opt.equalsIgnoreCase("modificar") || !opt.equalsIgnoreCase("eliminar")) {
            System.out.println("Opcion incorrecta ingresada!");
            System.out.println("Desea modificar o eliminar el usuario: ");
            opt = sc.next();              
        }

        switch (opt.toUpperCase()) {
            case "MODIFICAR" -> editWorker(usuarioModificable);
            case "ELIMINAR" -> {
                users.get(Rol.TRABAJADOR).remove(usuarioModificable);
                System.out.println("Trabajador eliminado con exito!");
            }
        }

    }

    private static void editWorker(User usuarioModificable){
        boolean flag = true;
        while (flag) {
            System.out.println("Que desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Username");
            System.out.println("3. Password");
            System.out.println("4. Volver");
            System.out.println("5. Salario");
    
            int opt = sc.nextInt();
    
            switch (opt) {
                case 1 -> usuarioModificable.setName();
                case 2 -> usuarioModificable.setUser();
                case 3 -> usuarioModificable.setPassword();
                case 4 -> flag = false;
                default -> System.out.println("Opcion incorrecta, intente de nuevo");
            }    
        }
    }

    public static void checarSalida(){
        System.out.println("Trabajador salio a las: " + LocalDateTime.now());
    }
}
