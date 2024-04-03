import java.util.ArrayList;

public class FindID {

    public static String employeeID(ArrayList<Employee> employees, String ID){
        for (Employee employee : employees){
            if (employee.getID().equalsIgnoreCase(ID)){
                return employee.getName() + " " + employee.getLastName();
            }
        }
        System.out.println("\nNO SE ENCONTRO NINGUN EMPLEADO CON ESE ID\n");
        return "incorrect";
    }

    public static String clientName(ArrayList<Client> clients, String ID){
        for (Client client : clients){
            if (client.getID().equalsIgnoreCase(ID)){
                return client.getName() + " " + client.getLastName() ;
            }
        }
        System.out.println("\nNO SE ENCONTRO NINGUN CLIENTE CON ESE ID\n");
        return "incorrect";
    }

    public static Client client(ArrayList<Client> clients, String ID){
        for (Client client : clients){
            if (client.getID().equalsIgnoreCase(ID)){
                return client;
            }
        }
        return null;
    }

    public static Employee employee(ArrayList<Employee> employees, String ID){
        for (Employee employee : employees){
            if (employee.getID().equalsIgnoreCase(ID)){
                return employee;
            }
        }
        return null;
    }

    public static int clientAge(ArrayList<Client> clients, String ID){
        for (Client client : clients){
            if (client.getID().equalsIgnoreCase(ID)){
                return client.age;
            }
        }
        return 0;
    }

    public static int clientVisists(ArrayList<Client> clients, String ID){
        for (Client client : clients){
            if (client.getID().equalsIgnoreCase(ID)){
                return client.getVists();
            }
        }
        return 0;
    }

    public static boolean animalExists(ArrayList<Animal> animals, String ID){
        for (Animal animal : animals){
            if (animal.getID().equalsIgnoreCase(ID)){
                return true;
            }
        }
        System.out.println("\nNO SE ENCONTRO NINGUN ANIMAL CON ESE ID\n");
        return false;
    }

    public static Animal animal(ArrayList<Animal> animals, String ID){
        for (Animal animal : animals){
            if (animal.getID().equalsIgnoreCase(ID)){
                return animal;
            }
        }
        return null;
    }
}

