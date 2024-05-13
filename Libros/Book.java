package Libros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Libros.utils.*;
import Sistema.Library;

public class Book {
    private static Scanner sc = new Scanner(System.in);

    private static int nextID = 1;
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private LocalDate fechaPublicacion;
    private Genero genero;
    private Subgenero subgenero;
    private double precio;
    private int stock;

    public Book(String titulo, String autor, String editorial, LocalDate fechaPublicacion, Genero genero,
            Subgenero subgenero, double precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.subgenero = subgenero;
        this.precio = precio;
        this.stock = stock;
        this.id = nextID;
        nextID++;
    }

    public static void registerBook(HashMap<Genero, ArrayList<Book>> books){
        Genero genero = null;
        Subgenero subgenero = null;

        System.out.println("Ingrese el nombre del libro: ");
        System.out.print(">> ");
        String titulo = sc.nextLine();

        System.out.println("Ingrese el autor: ");
        System.out.print(">> ");
        String autor =  sc.nextLine();

        System.out.println("Ingrese la editorial: ");
        System.out.print(">> ");
        String editorial = sc.nextLine();

        System.out.println("Ingrese la fecha de publicacion: (dd-MM-yyyy)");
        System.out.print(">> ");
        String fechaPublicacion = sc.nextLine();

        System.out.println("Ingrese el genero del libro: ");
        System.out.println("1. Terror");
        System.out.println("2. Comedia");
        System.out.println("3. Accion");
        System.out.print(">> ");
        int opt = sc.nextInt();

        switch (opt) {
            case 1 -> genero = Genero.Terror;
            case 2 -> genero = Genero.Comedia;
            case 3 -> genero = Genero.Accion;
        }

        switch (genero) {
            case Genero.Terror -> {
                System.out.println("Ingrese el subgenero: ");
                System.out.println("1. Crimen");
                System.out.println("2. Psicologico");
                System.out.print(">> ");

                int opt2 = sc.nextInt();

                switch (opt2) {
                    case 1 -> subgenero = Subgenero.Crimen;
                    case 2 -> subgenero = Subgenero.Psicologico;
                }
            }
            case Genero.Comedia -> {
                System.out.println("Ingrese el subgenero: ");
                System.out.println("1. Romantica");
                System.out.println("2. Satira");
                System.out.print(">> ");

                int opt2 = sc.nextInt();

                switch (opt2) {
                    case 1 -> subgenero = Subgenero.Romantica;
                    case 2 -> subgenero = Subgenero.Satira;
                }
            }
            case Genero.Accion -> {
                System.out.println("Ingrese el subgenero: ");
                System.out.println("1. Ciencia Ficcion");
                System.out.println("2. Thriller");
                System.out.print(">> ");

                int opt2 = sc.nextInt();

                switch (opt2) {
                    case 1 -> subgenero = Subgenero.CienciaFiccion;
                    case 2 -> subgenero = Subgenero.Thriller;
                }
            }
        }
        System.out.println("Ingrese el precio: ");
        System.out.print(">> ");
        Double precio = sc.nextDouble();

        System.out.println("Ingrese el stock: ");
        System.out.print(">> ");
        int stock = sc.nextInt();

        Book book = new Book(titulo, autor, editorial, LocalDate.parse(fechaPublicacion), genero, subgenero, opt, stock);
        books.get(genero).add(book);
    }

    public void deleteBook(HashMap<Genero, ArrayList<Book>> books){
        //printBooks()
        System.out.println("Ingrese el id del libro: ");
        System.out.print(">> ");
        int id = sc.nextInt();

        books.remove(books);
        System.out.println("Libro borrado correctamente...");
    }
}
