package Exercise1;

import java.util.*;

public class Library {
    private Book[] books;
    LinkedHashSet<Book> bookSet;

    public Library() {
        this.books = books;
        bookSet = new LinkedHashSet<>();
    }

    public LinkedHashSet<Book> getBookSet() {
        return bookSet;
    }

    public void addBook(Book book) {
        if (bookSet.add(book)){
            System.out.println(book.getTitle() + ", agregado con éxito!");
        } else {
            System.out.println(book.getTitle() + ", ya existente en la biblioteca!");
        }
    }

    public void removeBook(String title) {
        Iterator<Book> iterator = bookSet.iterator();
        boolean remove = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println(book + ": Book removed successfully.");
                remove = true;
                break;
            }
        }
        if (!remove) {
            System.out.println("The book " + title + " no está en la biblioteca");
        }
    }

    public LinkedHashSet<Book> getAllBooks() {
        System.out.println("All books:" + bookSet);
        return new LinkedHashSet<>(bookSet); //es new, para evitar que se modifique el original
    }

    public LinkedHashSet<Book> getBookByTitle(String title) throws NotFoundException {
        if (bookSet.isEmpty()) {
            throw new NotFoundException("Library empty!");
        }
        for (Book book : bookSet) {
            if (title != null && title.equalsIgnoreCase(book.getTitle())) {
                System.out.println("The book " +book+ " is in the library");
                return new LinkedHashSet<>(Collections.singleton(book));
            }
        }
        throw new NotFoundException("The introduced title is incorrect or does not exist");
    }

    public Book getBookByPosition(int position) throws IndexOutOfBoundsException {
        if (bookSet.isEmpty()) {
            throw new IndexOutOfBoundsException("The library is empty.");
        }
        List<Book> bookList = new ArrayList<>(bookSet);
        if (position < 0 || position >= bookList.size()) {
            throw new IndexOutOfBoundsException("Position is out of bounds");
        }
        System.out.println("The book in position " + position + " is: " + bookList.get(position));

        return bookList.get(position);
    }

    public void addBookByPosition(List<Book> books, int position, String title, String author, String isbn) {
        if (position < 0 || position > bookSet.size()) {
            throw new IndexOutOfBoundsException("Position is out of bounds");
        }

        // Crear un nuevo libro con la información proporcionada
        Book positionBook = new Book(title, author, isbn);

        // Crear un nuevo LinkedHashSet temporal para reconstruir el conjunto
        LinkedHashSet<Book> updatedBookSet = new LinkedHashSet<>(books);

        int index = 0;
        for (Book book : bookSet) {
            // Insertar el nuevo libro en la posición indicada
            if (index == position) {
                updatedBookSet.add(positionBook);
            }
            updatedBookSet.add(book);
            index++; //Sin esto el bucle if nunca avanza de posicion en los elemento de la lista
            //Al no tener indice el LinkedHashSet se usa esto
        }

        // Si la posición es igual al tamaño del conjunto, insertar al final
        if (position == bookSet.size()) {
            updatedBookSet.add(positionBook);
        }

        // Limpiar el conjunto original y añadir los elementos actualizados
        bookSet.clear();
        bookSet.addAll(updatedBookSet);

        System.out.println(positionBook +  "added successfully in position " + position + ".");
    }

    public void getLibrarySize(){
        System.out.println("The library size is: " + bookSet.size());
    }

}
