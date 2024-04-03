import java.util.ArrayList;

public class Init {
    public static void init(Zoo zoo){
        ArrayList<String> diseases = new ArrayList<>();
        ArrayList<String> visitants = new ArrayList<>();
        visitants.add("Oscar Corona");
        visitants.add("Samuel Villegas");

        Client client1 = new Client("Oscar", "Corona", "28-09-2005","AICO050928HMNRRSA4",18);
        zoo.getClients().add(client1);

        Client client2 = new Client("Samuel", "Villegas", "29-10-2005","VICS051029HMNRKLE3", 18);
        zoo.getClients().add(client2);

        Client client3 = new Client("Luis", "Perez", "18-02-2011", "PEHL110218HMNLASD2",13);
        zoo.getClients().add(client3);

        Employee em1 = new Employee("Diego", "Garcia", "09-05-2005","A123RGDF34","GAMD050509HMNRRPE2",2000.00,"12:00-19:00","Guia",18);
        zoo.getEmployees().add(em1);

        Employee em2 = new Employee("Miguel", "Gonzales", "11-01-1991","A143TEDF34","GOLM910111HMNRTQE2",3500.00,"10:00-19:00","Mantenimiento",33);
        zoo.getEmployees().add(em2);

        Employee em3 = new Employee("Amanda", "Fernandez", "27-12-1998","A1GER8DF34","FEHA981227MGLRWQE5",5000.00,"14:00-20:00","Veterinario",25);
        zoo.getEmployees().add(em3);

        Employee em4 = new Employee("Eduardo", "Martinez", "22-06-1979","A14EZ8LE34","MATE790622HBCFQQE6",3800.00,"11:00-20:00","Administracion",44);
        zoo.getEmployees().add(em4);

        Animal an1 = new Animal("Panda","11-04-2013",108.2,diseases,8,"Herbivoro",true);
        zoo.getAnimals().add(an1);

        Animal an2 = new Animal("Caballo","02-05-2020",113.5,diseases,6,"Herbivoro",false);
        zoo.getAnimals().add(an2);

        ArrayList<String> diseases1 = new ArrayList<>();
        diseases1.add("Lengua Azul");

        Animal an3 = new Animal("Tigre","20-09-2018",99.4,diseases1,10,"Carnivoro", false);
        zoo.getAnimals().add(an3);

        Visit v1 = new Visit("Diego Garcia",visitants,200,2,0);
        zoo.getVisits().add(v1);

        Order o1 = new Order("Miguel Gonzales", "003", "mantenimiento","Se cuido al tigre por la noche");
        zoo.getOrders().add(o1);
    }
}
