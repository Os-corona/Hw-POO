import java.time.LocalDate;
import java.util.ArrayList;

public class Visit {
    private static int cont = 1;
    private String ID;
    private String employeeInCharge;
    private ArrayList<String> visitants = new ArrayList<String>();
    private double totalPrice;
    private String dayOfVisit;
    private int adults;
    private int children;

    public Visit(String employeeInCharge, ArrayList<String> visitants, double totalPrice, int adults, int children) {
        this.employeeInCharge = employeeInCharge;
        this.ID = String.format("%03d", cont);
        this.visitants = visitants;
        this.totalPrice = totalPrice;
        this.dayOfVisit = LocalDate.now().toString();
        this.adults = adults;
        this.children = children;
    }

    public void printVisitants(){
        System.out.println("Lista de visitantes: ");
        for (String visitant : visitants){
            System.out.println("\t"+visitant);
        }
    }

    public String getEmployeeInCharge() {
        return employeeInCharge;
    }

    public ArrayList<String> getVisitants() {
        return visitants;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getDayOfVisit() {
        return dayOfVisit;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public String getID() {
        return ID;
    }
}
