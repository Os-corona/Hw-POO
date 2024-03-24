import java.time.*;
import java.time.format.DateTimeFormatter;
public class Employee {
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
        this.firstDayAsWorker = String.valueOf(LocalDate.now());
        this.rfc = rfc;
        this.curp = curp;
        this.salary = salary;
        this.hours = hours;
        this.role = role;
        this.age = age;
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
}
