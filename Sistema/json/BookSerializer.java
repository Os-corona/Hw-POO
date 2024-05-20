package Sistema.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Libros.utils.*;
import Sistema.Library;
import Sistema.json.model.LibrosModel;

public class BookSerializer {

    public static void writeToJSON(Library library){
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("libros.json"));
            json.toJson(library.getBooks(), writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static void readFromJSON(Library library){
        try {
            //Reader or READ file (file that has been read)
            BufferedReader reader = new BufferedReader(new FileReader("libros.json"));
            Gson json = new Gson();
            LibrosModel model = json.fromJson(reader, LibrosModel.class);
            library.getBooks().get(Genero.Accion).addAll(model.getAccion());
            library.getBooks().get(Genero.Comedia).addAll(model.getComedia());
            library.getBooks().get(Genero.Terror).addAll(model.getTerror());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}