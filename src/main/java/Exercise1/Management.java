package Exercise1;

public class Management {
    public static Library lib = new Library();

    public Management(Library lib) {
        this.lib = lib;
    }

    public static void loadSampleBooks() {
        lib.addBook(new Book("Book 1", "Autor 1", "978-84-322-2787-1"));
        lib.addBook(new Book("Book 2", "Autor 2", "978-84-322-2787-2"));
        lib.addBook(new Book("Book 3", "Autor 3", "978-84-322-2787-3"));
        lib.addBook(new Book("Book 4", "Autor 4", "978-84-322-2787-4"));
        lib.addBook(new Book("Book 1", "Autor 6", "978-84-322-2787-6"));
    }
}
