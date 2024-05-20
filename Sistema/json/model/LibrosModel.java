package Sistema.json.model;

import java.util.ArrayList;

import Libros.Book;

public class LibrosModel {
    private ArrayList<Book> Accion;
    private ArrayList<Book> Comedia;
    private ArrayList<Book> Terror;

    public ArrayList<Book> getAccion() {
        return Accion;
    }
    public ArrayList<Book> getComedia() {
        return Comedia;
    }
    public ArrayList<Book> getTerror() {
        return Terror;
    }
}