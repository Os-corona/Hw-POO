import java.time.LocalDate;
import java.time.Period;

public class Animal {
    private static int cont = 1;
    private String ID;
    private String animalType;
    private String birthday;
    private String dayOfArrival;
    private double weight;
    private String[] diseases = new String[10];
    private int feedingSchedule;
    private String foodType;
    private boolean isVaccinated;

    public Animal(String animalType, String birthday, double weight, String[] diseases, int feedingSchedule, String foodType, boolean isVaccinated) {
        this.animalType = animalType;
        this.ID = String.format("%03d", cont);
        this.birthday = birthday;
        this.weight = weight;
        this.diseases = diseases;
        this.feedingSchedule = feedingSchedule;
        this.foodType = foodType;
        this.isVaccinated = isVaccinated;
        this.dayOfArrival = LocalDate.now().toString();
    }

    public void printDiseases(Animal animal){
        System.out.println("Lista de enfermedades: ");
        for (int i = 0; i < animal.diseases.length; i++) {
            System.out.print("\t"+animal.diseases[i]+" ");
        }
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

    public String[] getDiseases() {
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
}
