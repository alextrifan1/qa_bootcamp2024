package TemaClase;

public class Library {
    public static void main(String[] args) {
        Author a = new Author("Gabriel García Márquez", "gabrielg.márquez@gmail.com");
        Book b = new Book("One Hundred Years of Solitude", 1967, a, 20.99);
        printBook(b);
    }

    public static void printBook(Book b) {
        System.out.println("Book " + b.getName() + " " + b.getPrice() + " RON" + ", by " + b.getAuthor().getName() + ", published in " + b.getYear());
    }
}
