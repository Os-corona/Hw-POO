import java.time.*;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Init.init(zoo);

        Sys sys = new Sys();
        sys.system(zoo);
    }
}