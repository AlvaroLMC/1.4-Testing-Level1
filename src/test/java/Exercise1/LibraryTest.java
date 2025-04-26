package Exercise1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    private Library lib;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book Abook1;


    @BeforeEach
    void setUp() {
        lib = new Library();
        lib.addBook(book1 = new Book("Book 1", "Autor 1", "978-84-322-2787-1"));
        lib.addBook(book3 = new Book("Book 3", "Autor 3", "978-84-322-2787-3"));
        lib.addBook(book2 = new Book("Book 2", "Autor 2", "978-84-322-2787-2"));
        lib.addBook(book4 = new Book("Book 1", "Autor", "978-84-322-2787-1"));
    }

    @Test
    public void listOfBooksNotNull() {
        book1 = new Book("Book 1", "Autor 1", "978-84-322-2787-1");
        lib.addBook(book1);
    }

    @Test
     public void listWithExpectedSize() {
        lib.getLibrarySize();
    }

    @Test
    public void bookInCorrectPosition() {
        lib.getBookByPosition(1);
    }

    @Test
    public void NoDuplicateTitles() {
        Assertions.assertTrue(book1.equals(book4), "Titles are equal");
        Assertions.assertFalse(book1.equals(book2), "Titles are not equal");
        Assertions.assertFalse(book1.equals(null), "Null is not equal to object");
        Assertions.assertNotEquals(book1.hashCode(), book2.hashCode(), "different books, different hash codes");
        assertEquals(book1.hashCode(), book4.hashCode(), "Same books, same hash code");
    }

    @Test
    public void bookTitleByPosition() {
        Book bookAtPos = lib.getBookByPosition(0);
        assertEquals("Book 1", bookAtPos.getTitle());
    }

    @Test
    public void listOkWhenAddBook() {
        lib.addBook(new Book("Book 4", "Autor 4", "978-84-322-2787-4"));
        Assertions.assertEquals(4,lib.getBookSet().size());
    }

    @Test
    public void listOkWhenRemoveBook() {
        lib.removeBook("Book 1");
        Assertions.assertEquals(2,lib.getBookSet().size());
    }

    @Test
    public void AlphabeticalOrderWhenModifying() {
        List<Book> listOfBooks = new ArrayList<>(lib.getBookSet());
        List<Book> AlphabeticalList = new ArrayList<>(listOfBooks);
        AlphabeticalList.sort(Comparator.comparing(Book::getTitle));

        Assertions.assertEquals("Book 1",AlphabeticalList.get(0).getTitle());
        Assertions.assertEquals("Book 2",AlphabeticalList.get(1).getTitle());

        AlphabeticalList.add(new Book("A Book 1", "Autor 1", "978-84-322-2787-1"));
        AlphabeticalList.sort(Comparator.comparing(Book::getTitle));
        Assertions.assertEquals("A Book 1",AlphabeticalList.get(0).getTitle());
    }
}



