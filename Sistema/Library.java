package Sistema;
import usuarios.Utils.*;
import utils.LogInUser;
import usuarios.Client;
import usuarios.Manager;
import usuarios.User;
import usuarios.Worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
public class Library{
    private HashMap<Rol , ArrayList<User>> users = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public Library(){
        ArrayList<User> clients = new ArrayList<>();
        ArrayList<User> workers = new ArrayList<>();
        ArrayList<User> managers = new ArrayList<>();
        users.put(Rol.GERENTE, managers);
        users.put(Rol.CLIENTE, clients);
        users.put(Rol.TRABAJADOR, workers);
    }

    public HashMap<Rol , ArrayList<User>> getUsers(){
        return this.users;
    }

    public void registerClient(){
        ArrayList<String> commonData = commonData();
        String name = commonData.get(0);
        String lastName = commonData.get(1);
        String birthday = commonData.get(2);
        String username = commonData.get(3);
        String password = commonData.get(4);
        Client client = new Client(name, lastName, birthday, password, username);

        users.get(Rol.CLIENTE).add(client);

        System.out.println("El cliente se registro correctamente!");
    }

    public void registerManager(){
        ArrayList<String> commonData = commonData();
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

    public void registerWorker(){
        ArrayList<String> commonData = commonData();
        String name = commonData.get(0);
        String lastName = commonData.get(1);
        String birthday = commonData.get(2);
        String username = commonData.get(3);
        String password = commonData.get(4);

        System.out.println("Ingrese el salario del trabajador: ");
        double salary = sc.nextDouble();

        Worker worker = new Worker(name, lastName, birthday, password, username, salary);

        users.get(Rol.TRABAJADOR).add(worker);

        System.out.println("El trabajador se registro con exito!");
    }

    private ArrayList<String> commonData(){
        ArrayList<String> commonData = new ArrayList<>();
        System.out.println("Ingrese su nombre");
        String nombre = sc.next();
        System.out.println("Ingrese su apellido");
        String apellido = sc.next();
        System.out.println("Ingrese su fecha de nacimiento: (dd-MM-yyyy)");
        String birthday = sc.next();
        String nombreUsuario = getUsername();
        System.out.println("Ingrese su contraseña");
        String contraseña = sc.next();
        commonData.addAll(Arrays.asList(nombre, apellido, birthday, nombreUsuario, contraseña));
        return commonData;
    }

    private String getUsername(){
        String username = "";
        boolean flag = true;
        while (flag) {
            System.out.println("Ingrese su nombre de usuario: ");
            username = sc.next();

            for (ArrayList<User> usuarios : users.values()) {
                for (User user : usuarios) {
                    if (user.getUser().equals(username)) {
                        System.out.println("Nombre de usuario ya existente!");
                    } else {
                        System.out.println("Nombre de usuario correcto!!");
                        flag = false;
                    }
                }
            }
        }
        return username;
    }

    public void printClients(){
        System.out.println("CLIENTES:");
        for (User usuarioAMostrar : users.get(Rol.CLIENTE)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
    }

    public void printWorkers(){
        System.out.println("EMPLEADOS:");
        for (User usuarioAMostrar : users.get(Rol.TRABAJADOR)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
    }

    public void printManagers(){
        System.out.println("GERENTES:");
        for (User usuarioAMostrar : users.get(Rol.GERENTE)) {
            System.out.println("   * " + usuarioAMostrar.toString());
        }
    }

}