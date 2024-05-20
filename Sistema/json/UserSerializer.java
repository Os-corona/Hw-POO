package Sistema.json;

import Sistema.Library;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

import Sistema.*;
import usuarios.Utils.*;
import Sistema.json.model.*;

public class UserSerializer {
    public static void writeToJSON(Library library){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.json"));
            json.toJson(library.getUsers(), writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static void readFromJSON(Library library){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            Gson json = new Gson();
            UsuariosModel model = json.fromJson(reader, UsuariosModel.class);
            library.getUsers().get(Rol.CLIENTE).addAll(model.getCLIENTE());
            library.getUsers().get(Rol.TRABAJADOR).addAll(model.getTRABAJADOR());
            library.getUsers().get(Rol.GERENTE).addAll(model.getGERENTE());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}