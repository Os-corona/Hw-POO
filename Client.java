import java.time.LocalDate;
import java.util.Scanner;
public class Client {
    private static int cont = 1;
    private String ID;
    private String name;
    private String lastName;
    private String birthday;
    private String curp;
    int age;
    private int visits = 0;
    private String dayRegistration;

    public Client(String name, String lastName, String birthday, String curp, int age) {
        this.name = name;
        this.ID = String.format("%03d", cont);
        this.lastName = lastName;
        this.birthday = birthday;
        this.curp = curp;
        this.age = age;
        this.dayRegistration = LocalDate.now().toString();
        cont++;
    }

    public void addVisit(){
        this.visits++ ;
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

    public String getCurp() {
        return curp;
    }

    public int getVists() {
        return visits;
    }

    public String getDayRegistration() {
        return dayRegistration;
    }

    public String getID() {
        return ID;
    }

    public void setName() {
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el nombre de la persona: ");
        String name = sc.nextLine();
        this.name = name;
    }

    public void setLastName() {
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el apellido de la persona: ");
        String name = sc.nextLine();
        this.lastName = name;
    }

    public void setCurp() {
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el CURP de la persona: ");
        String curp = sc.nextLine();
        this.curp = curp;
    }

    public void setVisits() {
        Scanner sc = new Scanner (System.in);
        System.out.println("Ingrese el numero de visitas de la persona: ");
        int visits = sc.nextInt();
        this.visits = visits;
    }
}
