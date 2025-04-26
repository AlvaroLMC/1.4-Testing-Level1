package Exercise1;

import java.util.ArrayList;
import java.util.List;

import static Exercise1.Management.lib;

public class Main {
    public static void main(String[] args) throws NotFoundException {

        Management.loadSampleBooks();
        lib.getLibrarySize();
        lib.removeBook("Book 4");
        lib.getAllBooks();
        lib.getBookByPosition(0);
        lib.getBookByTitle("Book 3");

        List<Book> positionBooks = new ArrayList<>();
        lib.addBookByPosition(positionBooks,2,"Book 5","Autor 5","978-84-322-2787-5");

        lib.getAllBooks();
    }
}
