package demo.dao;

import demo.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {

    private static final String PASSWORD = "demo";
    private static final String USERNAME = "demo";
    private static final String URL = "jdbc:mysql://localhost:3306/my-books";

    public static List<Book> loadAll() throws SQLException {
        System.out.println("------- load all ------");
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from books");
        List<Book> books = new ArrayList<Book>();
        while (rs.next()) {
            Book book = row2book(rs);
            books.add(book);
            System.out.println("Book: " + book);
        }
        conn.close();
        return books;
    }

    private static Book row2book(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        return new Book(id, title, description);
    }

    public static Book findById(Long bookId) throws SQLException {
        System.out.println("------- query by id ------");
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("select * from books where id=?");
        stmt.setLong(1, bookId);
        ResultSet rs = stmt.executeQuery();
        Book result = null;
        while (rs.next()) {
            result = row2book(rs);
            System.out.println("Book: " + result);
        }
        stmt.close();
        conn.close();
        return result;
    }

    public static Book save(Book book) throws SQLException {
        System.out.println("------- inserting ------");
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("insert into books(title, description) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getDescription());
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        book.setId(keys.getLong(1));
        stmt.close();
        conn.close();
        System.out.println("Saved book: " + book);
        return book;
    }

    public static void update(Book book) throws SQLException {
        System.out.println("------- update by id ------");
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("update books set title=?, description=? where id=?");
        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getDescription());
        stmt.setLong(3, book.getId());
        int updatedCount = stmt.executeUpdate();
        stmt.close();
        conn.close();
        System.out.println("Updated " + updatedCount + " rows");
    }

    public static void deleteById(Long id) throws SQLException {
        System.out.println("------- delete by id ------");
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("delete from books where id=?");
        stmt.setLong(1, id);
        int deletedCount = stmt.executeUpdate();
        stmt.close();
        conn.close();
        System.out.println("Delete " + deletedCount + " rows");
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
