import java.util.*;
public class User {
    private String name;
    private String lastName;
    private ArrayList<Book> booksRented = new ArrayList<Book>();
    private boolean hasRented;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public void rentBook(ArrayList<Book> library){
        Scanner sc = new Scanner(System.in);
        int i = 1;
        System.out.println("\t=====LISTA DE LIBROS======");
        for (Book libros: library){
            System.out.println(i+". Libro: "+libros.getName()+" Autor: "+libros.getAuthor());
            i++;
        }
        System.out.println("Ingrese el id del libro que desea rentar: ");
        int index = sc.nextInt();
        library.get(index-1).setRented(true);
        library.get(index-1).setUser(this.name);
        this.booksRented.add(library.get(index-1));
        this.hasRented = true;
        System.out.println(name+" ha rentado: "+library.get(index-1).getName()+" correctamente");
        sc.close();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isHasRented() {
        return hasRented;
    }

    public ArrayList<Book> getBooksRented() {
        return booksRented;
    }
}
