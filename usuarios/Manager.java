package usuarios;
import java.time.LocalDate;
import usuarios.User;
import java.util.*;
import Sistema.utils.*;
import usuarios.Utils.*;

public class Manager extends User {
    private static Scanner sc = new Scanner(System.in);
    private String area;
    private LocalDate RegistrationDate;

    public Manager(String nombre, String apellido, String area, String birthday, String password, String username) {
        super(nombre, apellido, Rol.GERENTE, birthday, password, username);
        this.RegistrationDate = LocalDate.now();
        this.area = area;
    }

    public LocalDate getFechaDeRegistro() {
        return RegistrationDate;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s** Area: %s",
         super.toString(), RegistrationDate.toString(), this.area);
    }

    public static void registerManager(HashMap<Rol , ArrayList<User>> users){
        ArrayList<String> commonData = CommonData.commonData(users);
        String name = commonData.get(0);
        String lastName = commonData.get(1);
        String birthday = commonData.get(2);
        String username = commonData.get(3);
        String password = commonData.get(4);

        System.out.println("Ingrese el area de trabajo del gerente: ");
        String area = sc.next();

        Manager manager = new Manager(name, lastName, area, birthday, password, username);
        users.get(Rol.GERENTE).add(manager);

        System.out.println("Se ha registrado al gerente con exito!");
    }

    public static void printManagers(HashMap<Rol , ArrayList<User>> users){
        System.out.println("GERENTES:");
        for (User usuarioAMostrar : users.get(Rol.GERENTE)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
    }

    public static void modifyManager(HashMap<Rol , ArrayList<User>> users){
        System.out.println("Ha seleccionado modificar o eliminar un Gerente!");
        printManagers(users);
        System.out.println("Que gerente desea modificar o eliminar: (Ingrese el ID)");
        String id = sc.next();

        User usuarioModificable = FindID.findManager(users, id);

        while (usuarioModificable == null) {
            System.out.println("ID incorrecto ingresado");
            System.out.println("Que gerente desea modificar o eliminar: (Ingrese el ID)");
            id = sc.next();
            usuarioModificable = FindID.findManager(users, id);
        }
        System.out.println("Desea modificar o eliminar el usuario: ");
        String opt = sc.next();

        while (!opt.equalsIgnoreCase("modificar") || !opt.equalsIgnoreCase("eliminar")) {
            System.out.println("Opcion incorrecta ingresada!");
            System.out.println("Desea modificar o eliminar el usuario: ");
            opt = sc.next();              
        }

        switch (opt.toUpperCase()) {
            case "MODIFICAR" -> editManager(usuarioModificable);
            case "ELIMINAR" -> {
                users.get(Rol.GERENTE).remove(usuarioModificable);
                System.out.println("Gerente eliminado con exito!");
            }
        }

    }

    private static void editManager(User usuarioModificable){
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
}

