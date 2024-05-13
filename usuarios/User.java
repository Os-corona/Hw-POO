package usuarios;
import java.time.LocalDate;
import java.util.Scanner;

import usuarios.Utils.Rol;

public class User {
    private static Scanner sc = new Scanner(System.in);
    private static int nextID = 1;
    private String id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate birthday;
    private String password;
    private String username;

    public User(String nombre, String apellido, Rol rol, LocalDate birthday, String password, String username) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.id = String.format("%03d",nextID);
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

    public String getID(){
        return this.id;
    }
    
    public void setName(){
        System.out.println("Ingrese el nuevo nombre del usuario: ");
        String name = sc.next();

        this.nombre = name;
        System.out.println("Nombre modificado con exito!");
    }

    public void setPassword(){
        System.out.println("Ingrese la nueva contrasena del usuario: ");
        String password = sc.next();

        this.password = password;
        System.out.println("Contrasena modificada con exito!");
    }

    public void setUser(){
        System.out.println("Ingrese el nuevo username del usuario: ");
        String username = sc.next();

        this.username = username;
        System.out.println("Username modificado con exito!");
    }

}
