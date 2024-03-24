import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
public class Zoo {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Visit> visits = new ArrayList<Visit>();

    public void registerEmployee(){
        String lastName = "";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("\n\t== HA SELECCIONADO REGISTRAR UN EMPLEADO ==\n");
        System.out.println("|| A continuacion ingresara los datos del nuevo empleado ||");
        System.out.println("Ingrese su nombre completo (Un nombre seguido de sus apellidos): ");
        String name = sc.nextLine();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i)==' '){
                lastName = name.substring(i+1);
                name = name.substring(0,i);
                break;
            }
        }

        System.out.println("Ingrese el cumpleaños del empleado (dd-MM-yyyy)");
        String birthday = sc.nextLine();

        int age = Period.between(LocalDate.now(),LocalDate.parse(birthday, formato)).getYears();
        if (age < 18){
            System.out.println("El empleado es menor de edad!! LLAMANDO AL 911");
            return;
        }

        System.out.println("Ingrese el RFC del empleado: ");
        String rfc = sc.nextLine();
        System.out.println("Ingrese el CURP del empleado: ");
        String curp = sc.nextLine();
        System.out.println("Ingrse el salario que recibira el empleado: ");
        double salary = sc.nextDouble();
        System.out.println("Ingrese el horario en el que el empleado trabajara (XX:XX - XX:XX)");
        String schedule = sc.nextLine();
        System.out.println("Que rol desempeñara el empleado (Administracion, Guia, Mantenimiento, Veterinario)");
        String role = sc.nextLine();
        while (role.equalsIgnoreCase("Administracion") || role.equalsIgnoreCase("Guia")
                || role.equalsIgnoreCase("Mantenimiento") || role.equalsIgnoreCase("Veterinario")) {

            System.out.println("Rol no reconocido por el sistema");
            System.out.println("Que rol desempeñara el empleado (Administracion, Guia, Mantenimiento, Veterinario)");
            role = sc.nextLine();
        }

        Employee employee = new Employee(name, lastName, birthday, rfc, curp, salary, schedule, role , age);
        employees.add(employee);
        System.out.println("\n== SE HA REGISTRADO A "+name+" CORRECTAMENTE ==\n");
    }

    public void registerAnimal(){
        String[] diseases = new String[10];
        int c = 0;
        boolean isVaccinated;

        System.out.println("\n\t== HA SELECCIONADO REGSITRAR UN ANIMAL ==\n");
        System.out.println("|| A continuacion ingresera los datos del animal ||");
        System.out.println("Que tipo de animal es: ");
        String animalType = sc.nextLine();
        System.out.println("Cual es la fecha de nacimiento: (dd-MM-yyyy)");
        String birthday = sc.nextLine();
        System.out.println("Ingrese el peso del animal: ");
        double weight = sc.nextDouble();
        System.out.println("El animal cuenta con efermedades: (S/N)");
        char isSick = sc.nextLine().charAt(0);

        do {
            System.out.println("Con que enfermedad cuenta el animal: ");
            diseases[c] = sc.nextLine();
            System.out.println("Cuenta con mas enfermedades: (S/N)");
            isSick = sc.nextLine().charAt(0);
            c++;
        } while ((isSick == 'S' || isSick == 's'));

        System.out.println("Cada cuantos dias se alimentara al animal: ");
        int feedingSchedule = sc.nextInt();
        System.out.println("Ingrese su tipo de alimentacion: (Herbivoro, Carnivoro, Omnivoro)");
        String foodType = sc.nextLine();
        System.out.println("El animal esta vacunado: ");
        char Vaccinated = sc.nextLine().charAt(0);
        if ((Vaccinated == 'S' || Vaccinated == 's')){
            isVaccinated = true;
        } else {
            isVaccinated = false;
        }

        Animal animal = new Animal(animalType,birthday,weight,diseases,feedingSchedule,foodType,isVaccinated);
        animals.add(animal);
        System.out.println("\n== SE HA REGISTRADO EL ANIMAL ==\n");
    }

    public void registerClient(){
        String lastName = "";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("\n\t== HA SELECCIONADO REGISTRAR UN CLIENTE ==\n");
        System.out.println("|| A continuacion ingresara los datos del nuevo cliente ||");
        System.out.println("Ingrese su nombre completo (Un nombre seguido de sus apellidos): ");
        String name = sc.nextLine();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i)==' '){
                lastName = name.substring(i+1);
                name = name.substring(0,i);
                break;
            }
        }

        System.out.println("Ingrese el cumpleaños del cliente (dd-MM-yyyy)");
        String birthday = sc.nextLine();
        int age = Period.between(LocalDate.now(),LocalDate.parse(birthday, formato)).getYears();
        System.out.println("Ingrese el CURP del cliente: ");
        String curp = sc.nextLine();

        Client client = new Client(name, lastName, birthday, curp, age);
        clients.add(client);
        System.out.println("\n== SE HA REGISTRADO A "+name+" CORRECTAMENTE ==\n");
    }

    public void registerVisit(){

        System.out.println("\n\t== HA SELECCIONADO REGISTRAR UNA VISITA =\n");
        System.out.println("|| A continuacion ingresara los datos de la visita ||");
        printEmployees("Guia");
        System.out.println("\nQuien estara a cargo de esta visita: (Seleccione el numero del empleado)");
        int inCharge = sc.nextInt();
        System.out.println("A continuacion ingrese los visitantes que entraran a la visita");
    }

    public void printEmployees(String role){
        int c = 1;
        System.out.println("\n== LISTA DE EMPLEADOS CON EL ROL DE "+role.toUpperCase()+" ==\n");
        for (Employee employee: employees){
            if (employee.getRole().equalsIgnoreCase(role)){
                System.out.printf("Empleado %d. Nombre: %s %s Horario: %s \n",
                        c,employee.getName(),employee.getLastName(),employee.getHours());
                c++;
            }
        }
    }

    public void printClients(){
        int c = 1;
        for (Client client : clients){
            System.out.printf("Cliente %d. Nombre: %s %s Dia Nacimiento: %s Num. Visitas: %d Dia Registro: %s\n",
                    c, client.getName(),client.getLastName(),client.getBirthday(),client.getVists(),client.getDayRegistration());
            c++;
        }
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }
}
