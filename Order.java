import java.time.LocalDate;

public class Order {
    private String employee;
    private String animalID;
    private String process;
    private String date;
    private String observations;

    public Order(String employee, String animalID, String process, String observations) {
        this.employee = employee;
        this.animalID = animalID;
        this.process = process;
        this.date = LocalDate.now().toString();
        this.observations = observations;
    }

    public Order(String employee, String animalID, String process) {
        this.employee = employee;
        this.animalID = animalID;
        this.date = LocalDate.now().toString();
        this.process = process;
    }
}
