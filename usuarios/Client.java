package usuarios;
import java.time.LocalDate;
import usuarios.User;
import usuarios.Utils.FindID;
import usuarios.Utils.Rol;
import java.util.ArrayList;
import Sistema.utils.*;
import java.util.HashMap;
import java.util.Scanner;

public class Client extends User {
    private static Scanner sc = new Scanner(System.in);
    private LocalDate fechaDeRegistro;

    public Client(String nombre, String apellido, String birthday, String password, String username) {
        super(nombre, apellido, Rol.CLIENTE, birthday, password, username);
        this.fechaDeRegistro = LocalDate.now();
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s**", super.toString(), fechaDeRegistro.toString());
    }

    public static void registerClient(HashMap<Rol , ArrayList<User>> users){
        ArrayList<String> commonData = CommonData.commonData(users);
        String name = commonData.get(0);
        String lastName = commonData.get(1);
        String birthday = commonData.get(2);
        String username = commonData.get(3);
        String password = commonData.get(4);
        Client client = new Client(name, lastName, birthday, password, username);

        users.get(Rol.CLIENTE).add(client);

        System.out.println("El cliente se registro correctamente!");
    }

    public static void printClients(HashMap<Rol , ArrayList<User>> users){
        System.out.println("CLIENTES:");
        for (User usuarioAMostrar : users.get(Rol.CLIENTE)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
    }

    public static void modifyClient(HashMap<Rol , ArrayList<User>> users){
        System.out.println("Ha seleccionado modificar o eliminar un cliente!");
        printClients(users);
        System.out.println("Que cliente desea modificar o eliminar: (Ingrese el ID)");
        String id = sc.next();

        User usuarioModificable = FindID.findClient(users, id);

        while (usuarioModificable == null) {
            System.out.println("Que cliente desea modificar o eliminar: (Ingrese el ID)");
            id = sc.next();
            usuarioModificable = FindID.findClient(users, id);
        }
        System.out.println("Desea modificar o eliminar el usuario: ");
        String opt = sc.next();

        while (!opt.equalsIgnoreCase("modificar") || !opt.equalsIgnoreCase("eliminar")) {
            System.out.println("Opcion incorrecta ingresada!");
            System.out.println("Desea modificar o eliminar el usuario: ");
            opt = sc.next();              
        }

        switch (opt.toUpperCase()) {
            case "MODIFICAR" -> editClient(usuarioModificable);
            case "ELIMINAR" -> {
                users.get(Rol.CLIENTE).remove(usuarioModificable);
                System.out.println("Cliente eliminado con exito!");
            }
        }

    }

    private static void editClient(User usuarioModificable){
        boolean flag = true;
        while (flag) {
            System.out.println("Que desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Username");
            System.out.println("3. Password");
            System.out.println("4. Volver");
    
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
