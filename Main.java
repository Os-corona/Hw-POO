
// TAREA: Hacer clases Trabajador y Gerente
import java.time.LocalDate;

import Sistema.Library;
import Sistema.Sys;
import usuarios.Client;
import usuarios.Manager;
import usuarios.Worker;
import usuarios.Utils.Rol;

public class Main {
    public static void main(String[] args) {
        // LIBRERIA
        Library library = new Library();

        Client cliente = new Client("Diego", "Garcia",LocalDate.of(2005, 05, 9),"diego123","diego1");
        System.out.println(cliente.getFechaDeRegistro().toString());
        System.out.println(cliente.toString());
        library.getUsers().get(Rol.CLIENTE).add(cliente);

        Manager gerente=new Manager("Samuel","Villegas","Administracion",LocalDate.of(2005, 10, 26),"samuel123","samuel1");
        System.out.println(gerente.getFechaDeRegistro().toString());
        System.out.println(gerente.toString());
        library.getUsers().get(Rol.GERENTE).add(gerente);

        Worker trabajador= new Worker("Oscar","Corona",LocalDate.of(2005, 9, 28),"oscar123","oscar1", 10000);
        System.out.println(trabajador.getFechaDeRegistro().toString());
        System.out.println(trabajador.toString());
        library.getUsers().get(Rol.TRABAJADOR).add(trabajador);

        Sys.sys(library);
    }
}