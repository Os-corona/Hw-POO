import java.time.LocalDate;
public class Client {
    private static int cont = 1;
    private String ID;
    private String name;
    private String lastName;
    private String birthday;
    private String curp;
    int age;
    private int vists = 0;
    private String dayRegistration;

    public Client(String name, String lastName, String birthday, String curp, int age) {
        this.name = name;
        this.ID = String.format("%03d", cont);
        this.lastName = lastName;
        this.birthday = birthday;
        this.curp = curp;
        this.age = age;
        this.dayRegistration = LocalDate.now().toString();
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
        return vists;
    }

    public String getDayRegistration() {
        return dayRegistration;
    }

    public String getID() {
        return ID;
    }
}
