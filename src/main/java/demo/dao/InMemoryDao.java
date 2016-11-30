package demo.dao;

import demo.models.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDao {

    private static List<Book> books = new ArrayList<Book>();

    static {
        save(new Book("Java编程思想", "学Java的一本好书"));
        save(new Book("JavaScript语言精粹", "学JavaScript的一本好书"));
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static Book findBookById(Long id) {
        for (Book book : InMemoryDao.getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public static void deleteById(Long id) {
        List<Book> books = getBooks();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId().equals(id)) {
                books.remove(i);
                return;
            }
        }
    }

    public static void save(Book book) {
        Long maxId = getMaxId();
        book.setId(maxId + 1);
        books.add(book);
    }

    public static void update(Book book) {
        Book found = findBookById(book.getId());
        found.setTitle(book.getTitle());
        found.setDescription(book.getDescription());
    }

    private static Long getMaxId() {
        Long maxId = 0L;
        for (Book book : books) {
            if (book.getId() > maxId) {
                maxId = book.getId();
            }
        }
        return maxId;
    }


}
