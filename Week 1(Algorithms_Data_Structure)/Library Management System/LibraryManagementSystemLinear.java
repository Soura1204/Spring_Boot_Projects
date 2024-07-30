import java.util.ArrayList;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class LibraryManagementSystemLinear {
    private List<Book> books;

    public LibraryManagementSystemLinear() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public void displayBooks(List<Book> bookList) {
        if (bookList.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Books found:");
            for (Book book : bookList) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystemLinear lms = new LibraryManagementSystemLinear();

        
        lms.addBook(new Book(1, "Java Programming", "John Doe"));
        lms.addBook(new Book(2, "Data Structures", "Jane Smith"));
        lms.addBook(new Book(3, "Operating System", "Alice Johnson"));

        
        String searchTitle = "Java Programming";
        List<Book> foundBooks = lms.searchByTitle(searchTitle);

        
        lms.displayBooks(foundBooks);
    }
}
