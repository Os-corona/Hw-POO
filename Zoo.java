import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
public class Zoo {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Visit> visits = new ArrayList<>();

    public void registerEmployee() {
        String lastName = "";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("\n\t== HA SELECCIONADO REGISTRAR UN EMPLEADO ==\n");
        System.out.println("|| A continuacion ingresara los datos del nuevo empleado ||");
        System.out.println("Ingrese su nombre completo (Un nombre seguido de sus apellidos): ");
        String name = sc.nextLine();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                lastName = name.substring(i + 1);
                name = name.substring(0, i);
                break;
            }
        }

        System.out.println("Ingrese el cumpleaños del empleado (dd-MM-yyyy)");
        String birthday = sc.nextLine();

        int age = Period.between(LocalDate.parse(birthday, formato), LocalDate.now()).getYears();
        if (age < 18) {
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
        schedule = sc.nextLine();
        String availableRoles = "administracionguiamantenimientoveterinario";
        System.out.println("Que rol desempeñara el empleado (Administracion, Guia, Mantenimiento, Veterinario)");
        String role = sc.nextLine();
        while (!availableRoles.contains(role.toLowerCase())) {

            System.out.println("Rol no reconocido por el sistema");
            System.out.println("Que rol desempeñara el empleado (Administracion, Guia, Mantenimiento, Veterinario)");
            role = sc.nextLine();
        }

        Employee employee = new Employee(name, lastName, birthday, rfc, curp, salary, schedule, role, age);
        employees.add(employee);
        System.out.println("\n\t== SE HA REGISTRADO A " + name + " CORRECTAMENTE ==\n");
    }

    public void registerAnimal() {
        ArrayList<String> diseases = new ArrayList<>();
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
        char isSick = sc.next().charAt(0);

        while ((isSick == 'S' || isSick == 's')) {
            System.out.println("Con que enfermedad cuenta el animal: ");
            String disease = sc.next();
            diseases.add(disease);
            System.out.println("Cuenta con mas enfermedades: (S/N)");
            isSick = sc.next().charAt(0);
        }

        System.out.println("Cada cuantas horas se alimentara al animal: ");
        int feedingSchedule = sc.nextInt();
        System.out.println("Ingrese su tipo de alimentacion: (Herbivoro, Carnivoro, Omnivoro)");
        String foodType = sc.nextLine();
        foodType = sc.nextLine();
        System.out.println("El animal esta vacunado: ");
        char Vaccinated = sc.next().charAt(0);
        isVaccinated = Vaccinated == 'S' || Vaccinated == 's';

        Animal animal = new Animal(animalType, birthday, weight, diseases, feedingSchedule, foodType, isVaccinated);
        animals.add(animal);
        System.out.println("\n\t== SE HA REGISTRADO EL ANIMAL ==\n");
    }

    public void registerClient() {
        String lastName = "";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("\n\t== HA SELECCIONADO REGISTRAR UN CLIENTE ==\n");
        System.out.println("|| A continuacion ingresara los datos del nuevo cliente ||");
        System.out.println("Ingrese su nombre completo (Un nombre seguido de sus apellidos): ");
        String name = sc.nextLine();

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                lastName = name.substring(i + 1);
                name = name.substring(0, i);
                break;
            }
        }

        System.out.println("Ingrese el cumpleaños del cliente (dd-MM-yyyy)");
        String birthday = sc.nextLine();
        int age = Period.between(LocalDate.parse(birthday, formato), LocalDate.now()).getYears();
        System.out.println("Ingrese el CURP del cliente: ");
        String curp = sc.nextLine();

        Client client = new Client(name, lastName, birthday, curp, age);
        clients.add(client);
        System.out.println("\n\t== SE HA REGISTRADO A " + name + " CORRECTAMENTE ==\n");
    }

    public void registerVisit() {
        ArrayList<String> visitants = new ArrayList<String>();
        String employee;
        String clientName;
        int adults = 0;
        int children = 0;
        double totalPrice = 0;
        ArrayList<String> clientsInVisit = new ArrayList<>();

        System.out.println("\n\t== HA SELECCIONADO REGISTRAR UNA VISITA =\n");
        System.out.println("|| A continuacion ingresara los datos de la visita ||");
        printEmployees("Guia");
        do {
            System.out.println("\nQuien estara a cargo de esta visita: (Seleccione el ID del empleado)");
            String inCharge = sc.next();
            employee = FindID.employeeID(this.employees, inCharge);
        } while (employee == "incorrect");
        printClients();
        System.out.println("\nA continuacion ingrese los visitantes que entraran a la visita: (Ingrese el ID de los visitantes)\n");
        String client = sc.next();

        do {
            clientName = FindID.clientName(clients, client);
            if (clientName.equalsIgnoreCase("incorrect") || clientsInVisit.contains(client)) {
                System.out.println("ID Inexistente o ya ingresado. Ingrese otro ID: ");
                client = sc.next();
            } else {
                System.out.println("\nCliente " + clientName + " se ha agregado a la visita");
                visitants.add(FindID.clientName(clients, client));
                clientsInVisit.add(client);

                if (FindID.clientAge(clients, client) >= 18) {
                    if (FindID.clientVisists(clients, client) >= 5)
                        totalPrice += 80;
                    else {
                        totalPrice += 100;
                    }
                    adults++;
                } else {
                    if (FindID.clientVisists(clients, client) >= 5)
                        totalPrice += 40;
                    else {
                        totalPrice += 50;
                    }
                    children++;
                }

                FindID.client(clients, client).addVisit();

                System.out.println("Si desea agregar otro visitante, ingrese el numero de otro visitante, sino, ingrese -1");
                client = sc.next();
            }
        } while (!client.equalsIgnoreCase("-1"));

        Visit visit = new Visit(employee, visitants, totalPrice, adults, children);
        visits.add(visit);
        System.out.println("\n\t==LA VISITA HA SIDO REGISTRADA EN EL SISTEMA ==\n");
    }

    public void printEmployees(String role) {
        System.out.println("\n\t== LISTA DE EMPLEADOS CON EL ROL DE " + role.toUpperCase() + " ==\n");
        for (Employee employee : employees) {
            if (employee.getRole().equalsIgnoreCase(role)) {
                System.out.printf("Empleado %s. | Nombre: %s %s | Horario: %s \n",
                        employee.getID(), employee.getName(), employee.getLastName(), employee.getHours());
            }
        }
        System.out.println();
    }

    public void printClients() {
        System.out.println("\n\t== LISTA DE VISITANTES REGISTRADOS ==");
        for (Client client : clients) {
            System.out.printf("Cliente %s. | Nombre: %s %s | Dia Nacimiento: %s | Num. Visitas: %d | Dia Registro: %s\n",
                    client.getID(), client.getName(), client.getLastName(), client.getBirthday(), client.getVists(), client.getDayRegistration());
        }
        System.out.println();
    }

    public void printEmployees() {
        System.out.println("\n\t== LISTA DE EMPLEADOS ==\n");
        for (Employee employee : employees) {
            System.out.printf("Empleado %s. | Nombre: %s %s\n",
                    employee.getID(), employee.getName(), employee.getLastName());
            System.out.printf("\tEdad: %d | Horario: %s | Rol: %s | Salario: %f \n",
                    employee.getAge(), employee.getHours(), employee.getRole(), employee.getSalary());
            System.out.printf("\tRFC: %s | CURP: %s | Dia de contratacion: %s \n",
                    employee.getRfc(), employee.getCurp(), employee.getFirstDayAsWorker());
        }
        System.out.println();
    }

    public void printAnimals() {
        System.out.println("\n\t== LISTA DE ANIMALES ==\n");
        for (Animal animal : animals) {
            String vacunado = animal.isVaccinated() ? "Si" : "No";
            System.out.printf("Animal %s. | Tipo: %s | Nacio el: %s | Esta vacunado: %s | Peso: %f | Se alimenta cada: %d horas\n",
                    animal.getID(), animal.getAnimalType(), animal.getBirthday(), vacunado, animal.getWeight(), animal.getFeedingSchedule());
            if (!animal.getDiseases().isEmpty()) {
                animal.printDiseases(animal);
            }
        }
        System.out.println();
    }

    public void printVisits() {
        System.out.println("\n\t== LISTA DE VISITAS ==\n");
        for (Visit visit : visits) {
            System.out.println("\t= VISITA " + visit.getID() + " =");
            System.out.printf("Empleado a Cargo: %s | Precio total: %f | Dia: %s\n",
                    visit.getEmployeeInCharge(), visit.getTotalPrice(), visit.getDayOfVisit());
            visit.printVisitants();
            System.out.println();
        }
    }

    public void printOrders() {
        System.out.println("\n\t== LISTA DE ORDENES ==\n");
        for (Order order : orders){
            System.out.println("\t= ORDEN PARA "+order.getEmployee().toUpperCase()+" =");
            System.out.printf("Proceso realizado: %s Fecha: %s Animal: %s \n",
                    order.getProcess(),order.getDate(),order.getAnimalID());
            if (order.getObservations() != null){
                System.out.println("Observaciones: "+order.getObservations());
            }
        }
    }

    public void orderMaintenance() {
        String employee;
        String animalId;

        printEmployees("mantenimiento");

        while (true) {
            System.out.println("Que empleado desea asignar: (Ingrese el ID)");
            String id = sc.nextLine();
            employee = FindID.employeeID(employees, id);
            if (!employee.equalsIgnoreCase("incorrect")) {
                break;
            }
        }

        printAnimals();

        do {
            System.out.println("A que animal se le hara el mantenimiento: ");
            animalId = sc.nextLine();
        } while (!FindID.animalExists(animals, animalId));

        System.out.println("Que proceso realizara el empleado (Alimentar, Limpiar, Cuidar)");
        String process = sc.nextLine();
        System.out.println("El empleado desea realizar observaciones: (S/N)");
        char ob = sc.nextLine().charAt(0);
        if (ob == 'S' || ob == 's') {
            System.out.println("Que observaciones tuvo el empleado: ");
            String observation = sc.nextLine();
            Order order = new Order(employee, animalId, process, observation);
            orders.add(order);
        } else {
            Order order = new Order(employee, animalId, process);
            orders.add(order);
        }
        System.out.println("\n\t== SE HA REGISTRADO LA ORDEN CORRECTAMENTE ==\n");

    }

    public void modifyClient(){
        boolean flag = true;
        String id;

        System.out.println("\n\t==HA SELECCIONADO MODIFICAR UN CLIENTE==\n");
        printClients();

        while(true) {
            System.out.println("\nQue cliente desea modificar: (INGRESE SU ID)");
            id = sc.nextLine();

            if (FindID.clientName(clients, id) != "incorrect"){
                System.out.println("Ha seleccionado a: " + FindID.clientName(clients, id));
                break;
            }

            else {
                System.out.println("\nID INGRESADO INCORRECTO\n");
            }
        }
        while (flag) {
            System.out.println("Que desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. CURP");
            System.out.println("4. Num. Visitas");
            System.out.println("5. Salir");

            int opt = sc.nextInt();

            switch (opt){
                case 1 -> FindID.client(clients, id).setName();
                case 2 -> FindID.client(clients, id).setLastName();
                case 3 -> FindID.client(clients, id).setCurp();
                case 4 -> FindID.client(clients, id).setVisits();
                case 5 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta");
            }
        }

    }

    public void modifyEmployee(){
        boolean flag = true;
        String id;

        System.out.println("\n\t==HA SELECCIONADO MODIFICAR UN EMPLEADO==\n");
        printEmployees();

        while(true) {
            System.out.println("\nQue empleado desea modificar: (INGRESE SU ID)");
            id = sc.nextLine();

            if (FindID.employeeID(employees, id) != "incorrect"){
                System.out.println("Ha seleccionado a: " + FindID.employeeID(employees, id));
                break;
            }

            else {
                System.out.println("\nID INGRESADO INCORRECTO\n");
            }
        }

        while (flag) {
            System.out.println("\nQue desea modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Rol");
            System.out.println("4. Salario");
            System.out.println("5. Horario");
            System.out.println("6. Salir");

            int opt = sc.nextInt();

            switch (opt){
                case 1 -> FindID.employee(employees, id).setName();
                case 2 -> FindID.employee(employees, id).setLastName();
                case 3 -> FindID.employee(employees, id).setRole();
                case 4 -> FindID.employee(employees, id).setSalary();
                case 5 -> FindID.employee(employees, id).setHours();
                case 6 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta");
            }
        }
    }

    public void modifyAnimal(){
        boolean flag = true;
        String id;

        System.out.println("\n\t==HA SELECCIONADO MODIFICAR UN ANIMAL==\n");
        printAnimals();

        while(true) {
            System.out.println("\nQue animal desea modificar: (INGRESE SU ID)");
            id = sc.nextLine();

            if (FindID.animalExists(animals, id)){
                System.out.println("Ha seleccionado a el animal con ID: "+id);
                break;
            }

            else {
                System.out.println("\nID INGRESADO INCORRECTO\n");
            }
        }

        while (flag) {
            System.out.println("\nQue desea modificar: ");
            System.out.println("1. Peso");
            System.out.println("2. Dias de Alimentacion");
            System.out.println("3. Vacunar al Animal");
            System.out.println("4. Salir");

            int opt = sc.nextInt();

            switch (opt){
                case 1 -> FindID.animal(animals, id).setWeight();
                case 2 -> FindID.animal(animals, id).setFeedingSchedule();
                case 3 -> FindID.animal(animals, id).setVaccinated();
                case 4 -> flag = false;
                default -> System.out.println("Opcion ingresada incorrecta");
            }
        }
    }

    public void deleteClient(){
        String id;

        System.out.println("\n\t==HA SELECCIONADO ELIMINAR UN CLIENTE==\n");
        printClients();

        while(true) {
            System.out.println("\nQue cliente desea eliminar: (INGRESE SU ID)");
            id = sc.nextLine();

            if (FindID.clientName(clients, id) != "incorrect"){
                System.out.println("Ha seleccionado a: " + FindID.clientName(clients, id));
                break;
            }

            else {
                System.out.println("\nID INGRESADO INCORRECTO\n");
            }
        }

        System.out.println("Esta seguro? (S/N)");
        char delete = sc.nextLine().charAt(0);

        if (delete == 'S' || delete == 's'){
            System.out.printf("\nSE HA ELIMINADO A %s DEL SISTEMA\n",
                    FindID.clientName(clients, id).toUpperCase());
            clients.remove(FindID.client(clients, id));
        } else {
            System.out.println("\nNO SE ELIMINO NINGUN CLIENTE DEL SISTEMA\n");
        }
    }

    public void deleteEmployee(){
        String id;

        System.out.println("\n\t==HA SELECCIONADO ELIMINAR UN EMPLEADO==\n");
        printEmployees();

        while(true) {
            System.out.println("\nQue empleado desea eliminar: (INGRESE SU ID)");
            id = sc.nextLine();

            if (FindID.employeeID(employees, id) != "incorrect"){
                System.out.println("Ha seleccionado a: " + FindID.employeeID(employees, id));
                break;
            }

            else {
                System.out.println("\nID INGRESADO INCORRECTO\n");
            }
        }

        System.out.println("Esta seguro? (S/N)");
        char delete = sc.nextLine().charAt(0);

        if (delete == 'S' || delete == 's'){
            System.out.printf("\nSE HA ELIMINADO A %s DEL SISTEMA\n",
                    FindID.employeeID(employees, id).toUpperCase());
            employees.remove(FindID.employee(employees, id));
        } else {
            System.out.println("\nNO SE ELIMINO NINGUN EMPLEADO DEL SISTEMA\n");
        }
    }

    public void deleteAnimal(){
        String id;

        System.out.println("\n\t==HA SELECCIONADO ELIMINAR UN ANIMAL==\n");
        printAnimals();

        while(true) {
            System.out.println("\nQue animal desea eliminar: (INGRESE SU ID)");
            id = sc.nextLine();

            if (FindID.animalExists(animals, id)){
                System.out.println("Ha seleccionado a el animal con ID: "+id);
                break;
            }

            else {
                System.out.println("\nID INGRESADO INCORRECTO\n");
            }
        }

        System.out.println("Esta seguro? (S/N)");
        char delete = sc.nextLine().charAt(0);

        if (delete == 'S' || delete == 's'){
            System.out.printf("\nSE HA ELIMINADO A %s DEL SISTEMA\n",
                    FindID.animal(animals, id).getAnimalType().toUpperCase());
            animals.remove(FindID.animal(animals, id));
        } else {
            System.out.println("\nNO SE ELIMINO NINGUN ANIMAL DEL SISTEMA\n");
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