package usuarios;
import java.time.LocalDate;
import usuarios.User;
import usuarios.Utils.Rol;

public class Manager extends User {
    private String area;
    private LocalDate RegistrationDate;

    public Manager(String nombre, String apellido, String area, String birthday, String password, String username) {
        super(nombre, apellido, Rol.GERENTE, birthday, password, username);
        this.RegistrationDate = LocalDate.now();
        this.area = area;
    }

    public LocalDate getFechaDeRegistro() {
        return RegistrationDate;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s** Area: %s",
         super.toString(), RegistrationDate.toString(), this.area);
    }

}

