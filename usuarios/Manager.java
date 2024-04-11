package usuarios;
import java.time.LocalDate;
import usuarios.User;
import usuarios.Utils.Rol;

public class Manager extends User {
    private double salary;
    private LocalDate RegistrationDate;

    public Manager(String nombre, String apellido, double salary, String birthday, String password, String username) {
        super(nombre, apellido, Rol.GERENTE, birthday, password, username);
        this.RegistrationDate = LocalDate.now();
        this.salary = salary;
    }

    public LocalDate getFechaDeRegistro() {
        return RegistrationDate;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s** Salario %f",
         super.toString(), RegistrationDate.toString(), this.salary);
    }

}

