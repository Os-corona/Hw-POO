import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee {
     private static Scanner sc = new Scanner(System.in);
    private static int cont = 1;
    private String ID;
    private String name;
    private String lastName;
    private String birthday;
    private String firstDayAsWorker;
    private String rfc;
    private String curp;
    private double salary;
    private String hours;
    private String role;
    private int age;

    public Employee(String name, String lastName, String birthday, String rfc, String curp,
                    double salary, String hours, String role, int age) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.ID = String.format("%03d", cont);
        this.firstDayAsWorker = String.valueOf(LocalDate.now());
        this.rfc = rfc;
        this.curp = curp;
        this.salary = salary;
        this.hours = hours;
        this.role = role;
        this.age = age;
        cont++;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getFirstDayAsWorker() {
        return firstDayAsWorker;
    }

    public String getRfc() {
        return rfc;
    }

    public String getCurp() {
        return curp;
    }

    public double getSalary() {
        return salary;
    }

    public String getHours() {
        return hours;
    }

    public String getRole() {
        return role;
    }

    public String getID() {
        return ID;
    }

    public void setName() {
        System.out.println("Ingrese el nombre de la persona: ");
        String name = sc.nextLine();
        this.name = name;
    }

    public void setLastName() {
        System.out.println("Ingrese el apellido de la persona: ");
        String name = sc.nextLine();
        this.lastName = name;
    }

    public void setSalary() {
        System.out.println("Ingrese el nuevo salario del empleado: ");
        double salary = sc.nextDouble();
        this.salary = salary;
    }

    public void setHours() {
        System.out.println("Ingrese el horario en el que el empleado trabajara (XX:XX - XX:XX)");
        String hours = sc.nextLine();
        this.hours = hours;
    }

    public void setRole() {
        String availableRoles = "administracionguiamantenimientoveterinario";

        System.out.println("Que rol desempeñara el empleado (Administracion, Guia, Mantenimiento, Veterinario)");
        String role = sc.nextLine();

        while (!availableRoles.contains(role.toLowerCase())) {

            System.out.println("Rol no reconocido por el sistema");
            System.out.println("Que rol desempeñara el empleado (Administracion, Guia, Mantenimiento, Veterinario)");
            role = sc.nextLine();
        }

        this.role = role;
    }
}
