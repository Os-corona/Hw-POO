
// TAREA: Hacer clases Trabajador y Gerente
import Sistema.Library;
import Sistema.Sys;
import usuarios.Client;
import usuarios.Manager;
import usuarios.Worker;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Client cliente = new Client("Diego", "Garcia","09-05-2005","diego123","diego1");
        System.out.println(cliente.getFechaDeRegistro().toString());
        System.out.println(cliente.toString());
        library.getUsers().add(cliente);

        Manager gerente=new Manager("Samuel","Villegas",1500,"26-10-2005","samuel123","samuel1");
        System.out.println(gerente.getFechaDeRegistro().toString());
        System.out.println(gerente.toString());
        library.getUsers().add(gerente);

        Worker trabajador= new Worker("Oscar","Corona","28-09-2005","oscar123","oscar1");
        System.out.println(trabajador.getFechaDeRegistro().toString());
        System.out.println(trabajador.toString());
        library.getUsers().add(trabajador);

        Sys.sys(library);
    }
}