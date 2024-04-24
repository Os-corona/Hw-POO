package usuarios.Utils;

import java.util.*;
import usuarios.*;

public class FindID {
    private static Scanner sc = new Scanner(System.in);

    public static User findClient(HashMap<Rol , ArrayList<User>> users, String id){
        for (ArrayList<User> usuarios : users.values()) {
            for (User usuarioABuscar : usuarios) {
                if (usuarioABuscar.getRol().equals(Rol.CLIENTE)) {
                    if (usuarioABuscar.getID().equals(id)) {
                        return usuarioABuscar;
                    }
                }
            }
        }
        return null;
    }

    public static User findWorker(HashMap<Rol , ArrayList<User>> users, String id){
        for (ArrayList<User> usuarios : users.values()) {
            for (User usuarioABuscar : usuarios) {
                if (usuarioABuscar.getRol().equals(Rol.TRABAJADOR)) {
                    if (usuarioABuscar.getID().equals(id)) {
                        return usuarioABuscar;
                    }
                }
            }
        }
        return null;
    }

    public static User findManager(HashMap<Rol , ArrayList<User>> users, String id){
        for (ArrayList<User> usuarios : users.values()) {
            for (User usuarioABuscar : usuarios) {
                if (usuarioABuscar.getRol().equals(Rol.GERENTE)) {
                    if (usuarioABuscar.getID().equals(id)) {
                        return usuarioABuscar;
                    }
                }
            }
        }
        return null;
    }
}
