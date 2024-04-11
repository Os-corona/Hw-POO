package usuarios;
import java.time.LocalDate;
import usuarios.User;
import usuarios.Utils.Rol;

public class Worker extends User {
    private LocalDate RegistrationDate;

    public Worker(String nombre, String apellido, String birthday, String password, String username) {
        super(nombre, apellido, Rol.TRABAJADOR, birthday, password, username);
        this.RegistrationDate = LocalDate.now();
    }

    public LocalDate getFechaDeRegistro() {
        return RegistrationDate;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s**", super.toString(), RegistrationDate.toString());
    }

}
