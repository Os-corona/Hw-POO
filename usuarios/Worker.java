package usuarios;
import java.time.LocalDate;

import usuarios.Utils.Rol;

public class Worker extends User {
    private LocalDate RegistrationDate;
    private double salary;

    public Worker(String nombre, String apellido, String birthday, String password, String username, double salary) {
        super(nombre, apellido, Rol.TRABAJADOR, birthday, password, username);
        this.RegistrationDate = LocalDate.now();
        this.salary = salary;
    }

    public LocalDate getFechaDeRegistro() {
        return RegistrationDate;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s**", super.toString(), RegistrationDate.toString());
    }

}
