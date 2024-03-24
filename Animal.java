import java.time.LocalDate;
import java.time.Period;

public class Animal {
    String animalType;
    String birthday;
    String dayOfArrival;
    double weight;
    String[] diseases = new String[10];
    int feedingSchedule;
    String foodType;
    boolean isVaccinated;

    public Animal(String animalType, String birthday, double weight, String[] diseases, int feedingSchedule, String foodType, boolean isVaccinated) {
        this.animalType = animalType;
        this.birthday = birthday;
        this.weight = weight;
        this.diseases = diseases;
        this.feedingSchedule = feedingSchedule;
        this.foodType = foodType;
        this.isVaccinated = isVaccinated;
        this.dayOfArrival = LocalDate.now().toString();
    }
}
