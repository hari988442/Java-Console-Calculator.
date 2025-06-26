import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}

// User class
class User {
    String name;
    ArrayList<Book> issuedBooks;

    public User(String name) {
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}

// Library class
class Library {
    ArrayList<Book> books;
    ArrayList<User> users;
    Scanner scanner;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public void addUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        users.add(new User(name));
        System.out.println("User added successfully!");
    }

    public void issueBook() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        User user = findUser(userName);
        Book book = findBook(bookTitle);

        if (user != null && book != null && !book.isIssued) {
            book.isIssued = true;
            user.issuedBooks.add(book);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book or user not found, or book is already issued!");
        }
    }

    public void returnBook() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();

        User user = findUser(userName);
        Book book = findBook(bookTitle);

        if (user != null && book != null && book.isIssued && user.issuedBooks.contains(book)) {
            book.isIssued = false;
            user.issuedBooks.remove(book);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book or user not found, or book is not issued!");
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private User findUser(String name) {
        for (User user : users) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        return null;
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void run() {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Display Users");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    displayBooks();
                    break;
                case 6:
                    displayUsers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.run();
    }
}

