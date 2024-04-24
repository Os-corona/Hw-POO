package Sistema;
import usuarios.Utils.*;
import utils.LogInUser;
import usuarios.Client;
import usuarios.Manager;
import usuarios.User;
import usuarios.Worker;
import Sistema.utils.*;

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
        Client.registerClient(users);
    }

    public void registerManager(){
        Manager.registerManager(users);
    }

    public void registerWorker(){
        Worker.registerWorker(users);
    }

    public void printClients(){
        Client.printClients(users);
    }

    public void printWorkers(){
        Worker.printWorkers(users);
    }

    public void printManagers(){
        Manager.printManagers(users);
    }

    public void modifyClient(){
        Client.modifyClient(users);
    }
    
    public void modifyWorker(){
        Worker.modifyWorker(users);
    }

    public void modifyManager(){
        Manager.modifyManager(users);
    }

}