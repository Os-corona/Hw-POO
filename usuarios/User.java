package usuarios;
import usuarios.Utils.Rol;

public class User {
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private String birthday;
    private String password;
    private String username;

    public User(String nombre, String apellido, Rol rol, String birthday, String password, String username) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.id = nextID;
        this.birthday = birthday;
        this.password = password;
        nextID++;
    }

    @Override
    public String toString(){
        return String.format("**ID: %d\t**Nombre completo: %s %s\t**Rol: %s", id, nombre, apellido, rol);
    }

    public String getUser(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public Rol getRol(){
        return this.rol;
    }

}
