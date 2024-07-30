import java.util.Arrays;

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

class LibraryManagementSystemBinary {
    private Book[] books;
    private int size;

    public LibraryManagementSystemBinary(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
            System.out.println("Book added: " + book);
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public void listBooks() {
        System.out.println("Book List:");
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystemBinary lms = new LibraryManagementSystemBinary(5);

        
        lms.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        lms.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        lms.addBook(new Book(3, "1984", "George Orwell"));
        lms.addBook(new Book(4, "Pride and Prejudice", "Jane Austen"));
        lms.addBook(new Book(5, "Moby Dick", "Herman Melville"));

        
        lms.sortBooksByTitle();

        
        lms.listBooks();

        
        String searchTitle = "1984";
        Book found = lms.binarySearchByTitle(searchTitle);
        if (found != null) {
            System.out.println("Book found: " + found);
        } else {
            System.out.println("Book not found with title: " + searchTitle);
        }
    }
}
