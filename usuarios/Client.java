package usuarios;
import java.time.LocalDate;
import usuarios.User;
import usuarios.Utils.Rol;

public class Client extends User {
    private LocalDate fechaDeRegistro;

    public Client(String nombre, String apellido, String birthday, String password, String username) {
        super(nombre, apellido, Rol.CLIENTE, birthday, password, username);
        this.fechaDeRegistro = LocalDate.now();
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    @Override
    public String toString(){
        return String.format("**%s, Fecha de Registro %s**", super.toString(), fechaDeRegistro.toString());
    }

}
