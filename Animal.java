import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    private static Scanner sc = new Scanner(System.in);
    private static int cont = 1;
    private String ID;
    private String animalType;
    private String birthday;
    private String dayOfArrival;
    private double weight;
    private ArrayList<String> diseases = new ArrayList<>();
    private int feedingSchedule;
    private String foodType;
    private boolean isVaccinated;

    public Animal(String animalType, String birthday, double weight, ArrayList<String> diseases, int feedingSchedule, String foodType, boolean isVaccinated) {
        this.animalType = animalType;
        this.ID = String.format("%03d", cont);
        this.birthday = birthday;
        this.weight = weight;
        this.diseases = diseases;
        this.feedingSchedule = feedingSchedule;
        this.foodType = foodType;
        this.isVaccinated = isVaccinated;
        this.dayOfArrival = LocalDate.now().toString();
        cont++;
    }

    public void printDiseases(Animal animal){
        System.out.printf("\tLista de enfermedades de %s %s: ",
                animal.animalType,animal.getID());
        for (String disease : diseases) {
            System.out.print(disease + " ");
        }
        System.out.println();
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDayOfArrival() {
        return dayOfArrival;
    }

    public double getWeight() {
        return weight;
    }

    public ArrayList<String> getDiseases() {
        return diseases;
    }

    public int getFeedingSchedule() {
        return feedingSchedule;
    }

    public String getFoodType() {
        return foodType;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public String getID() {
        return ID;
    }

    public void setWeight() {
        System.out.println("Ingrese el peso del animal: ");
        double weight = sc.nextDouble();
        this.weight = weight;
    }

    public void setFeedingSchedule() {
        System.out.println("Cada cuantas horas se alimentara al animal: ");
        int feedingSchedule = sc.nextInt();
        this.feedingSchedule = feedingSchedule;
    }

    public void setVaccinated() {
        if (!this.isVaccinated){
            this.isVaccinated = true;
            System.out.println("El animal ha sido vacunado!");
        } else {
            System.out.println("El animal ya estaba vacunado!");
        }
    }
}


