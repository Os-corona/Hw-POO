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
        if (library.get(index).isRented()) {
            System.out.println("El libro seleccionado ya esta rentado");
            return;
        }
        library.get(index-1).setRented(true);
        library.get(index-1).setUser(this.name);
        this.booksRented.add(library.get(index-1));
        this.hasRented = true;
        System.out.println(name+" ha rentado: "+library.get(index-1).getName()+" correctamente");
    }

    public void returnBook(Library library){
        Scanner sc = new Scanner(System.in);
        int i = 1;
        if (this.booksRented.isEmpty()) {
            System.out.println("No ha rentado ningun libro aun");
            return;
        }
        System.out.println("Indique el ID del libro que desea regresar");
        for(Book libros : this.booksRented){
            System.out.println("ID: "+i+" | Libro: "+libros.getName()+" | Autor: "+libros.getAuthor());
        }
        int id = sc.nextInt();
        library.getBooks().get(id-1).setRented(false);
        library.getBooks().get(id-1).setUser("");
        this.booksRented.remove(id-1);
        if (this.booksRented.isEmpty()) {
            this.hasRented = false;
        }
        System.out.println("Ha devuelto el libro: "+library.getBooks().get(id-1).getName());
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
