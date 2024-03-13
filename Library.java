import java.util.*;
public class Library {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Book> books = new ArrayList<Book>();

    public void printUsers(){
        int i = 1;
        String hasRented = "";
        if (users.isEmpty()){
            System.out.println("No hay usuarios registrados\n");
            return;
        }
        System.out.println("\t=====LISTA DE USUARIOS======");
        for (User usuarios: this.users){
            if (usuarios.isHasRented()) {
                hasRented = "Si";
            } else {
                hasRented = "No";
            }
            System.out.println("ID: "+i+" | Nombre: "+usuarios.getName()+" "+usuarios.getLastName()+" | Ha rentado: "+hasRented);
            i++;
        }
        System.out.println();
    }

    public void printBooks(){
        int i = 1;
        String isRented = "";
        if (books.isEmpty()){
            System.out.println("No hay libros registrados\n");
            return;
        }
        System.out.println("\t=====LISTA DE LIBROS======");
        for (Book libros: this.books){
            if (libros.isRented()) {
                isRented = "Si";
            } else {
                isRented = "No";
            }
            System.out.println(i+". Libro: "+libros.getName()+" | Autor: "+libros.getAuthor()+" | Esta rentado: "+isRented);
            i++;
        }
        System.out.println();
    }

    public void printRentedBooks(){
        int i = 1;
        int c = 0;
        for (Book libros: this.books){
            if (libros.isRented()) {
                c++;
            }
        }
        if (c == 0) {
            System.out.println("No hay libros rentados\n");
            return;
        }
        System.out.println("\t=====LISTA DE LIBROS RENTADOS======");
        for (Book libros: this.books){
            if (libros.isRented()) {
                System.out.println(i + ". Libro: " + libros.getName() + " | Autor: " + libros.getAuthor()+" | Lo rento: "+libros.getUser());
                i++;
            }
        }
        System.out.println();
    }
    public void printUsersWithBooks(){
        int i = 1;
        int c = 0;
        for (User usuarios: this.users){
            if (usuarios.isHasRented()) {
                c++;
            }
        }
        if (c == 0) {
            System.out.println("No hay usuarios con libros\n");
            return;
        }
        System.out.println("\t=====LISTA DE USUARIOS QUE HAN RENTADO======");
        for (User usuarios: this.users){
            if (usuarios.isHasRented()) {
                System.out.println(i + ". Nombre: " + usuarios.getName() + " " + usuarios.getLastName());
                System.out.println("\tLibros que ha rentado "+usuarios.getName()+": ");
                for (Book libros : usuarios.getBooksRented()){
                    System.out.println("\t\tLibro: " + libros.getName() + " | Autor: " + libros.getAuthor());
                }
                i++;
            }
        }
        System.out.println();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}

