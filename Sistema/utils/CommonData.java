package Sistema.utils;
import java.util.*;
import usuarios.Utils.*;
import usuarios.*;

public class CommonData {
    private static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> commonData(HashMap<Rol , ArrayList<User>> users){
        ArrayList<String> commonData = new ArrayList<>();
        System.out.println("Ingrese su nombre");
        String nombre = sc.next();
        System.out.println("Ingrese su apellido");
        String apellido = sc.next();
        System.out.println("Ingrese su fecha de nacimiento: (dd-MM-yyyy)");
        String birthday = sc.next();
        String nombreUsuario = getUsername(users);
        System.out.println("Ingrese su contraseña");
        String contraseña = sc.next();
        commonData.addAll(Arrays.asList(nombre, apellido, birthday, nombreUsuario, contraseña));
        return commonData;
    }

    private static String getUsername(HashMap<Rol , ArrayList<User>> users){
        String username = "";
        boolean flag = true;
        while (flag) {
            System.out.println("Ingrese su nombre de usuario: ");
            username = sc.next();

            for (ArrayList<User> usuarios : users.values()) {
                for (User user : usuarios) {
                    if (user.getUser().equals(username)) {
                        System.out.println("Nombre de usuario ya existente!");
                    } else {
                        System.out.println("Nombre de usuario correcto!!");
                        flag = false;
                    }
                }
            }
        }
        return username;
    }
}
