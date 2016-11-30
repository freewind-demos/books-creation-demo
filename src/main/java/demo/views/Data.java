package demo.views;

import demo.models.Book;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1L, "Java编程思想", "学Java的一本好书"));
        books.add(new Book(1L, "JavaScript语言精粹", "学JavaScript的一本好书"));
        return books;
    }

    public static Book findBookById(Long id) {
        for (Book book : Data.getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }


}
