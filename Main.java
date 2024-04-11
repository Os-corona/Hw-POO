
// TAREA: Hacer clases Trabajador y Gerente
import Sistema.Library;
import usuarios.Client;
import usuarios.Manager;
import usuarios.Utils.Rol;
import usuarios.Worker;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Client cliente = new Client("Dylan", "Raya","23-11-2005","1234","dylan1");
        System.out.println(cliente.getFechaDeRegistro().toString());
        System.out.println(cliente.toString());
        library.getUsers().add(cliente);

        Manager gerente=new Manager("Samuel","Villegas",1500,"26-10-2005","1234","samuel1");
        System.out.println(gerente.getFechaDeRegistro().toString());
        System.out.println(gerente.toString());
        library.getUsers().add(gerente);

        Worker trabajador= new Worker("Max","Villegas","19-10-2005","1234","max1");
        System.out.println(trabajador.getFechaDeRegistro().toString());
        System.out.println(trabajador.toString());
        library.getUsers().add(trabajador);
    }
}