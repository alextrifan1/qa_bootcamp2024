package TemaClase;

public class Book {
    private String name;
    private int year;
    private Author author;
    private double price;

    public Book(String name, int year, Author author, double price) {
        this.name = name;
        this.year = year;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }
    public Author getAuthor() {
        return this.author;
    }
    public double getPrice() {
        return this.price;
    }
    public int getYear() {
        return this.year;
    }
}
