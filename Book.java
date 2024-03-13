public class Book {
    private String name;
    private String author;
    private boolean isRented = false;
    private String user;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isRented() {
        return isRented;
    }

    public String getUser() {
        return user;
    }
}
