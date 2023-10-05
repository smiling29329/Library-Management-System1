import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create books
        Book book1 = new Book(1, "The Catcher in the Rye", "J.D. Salinger");
        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee");

        // Create library
        Library library = new Library();

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);

        // Create users
        User user1 = new User("john_doe", "password123");
        Admin admin1 = new Admin("admin_user", "admin_password");

        // Simulate user login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(user1.getUsername()) && password.equals(user1.getPassword())) {
            // Simulate user interactions
            System.out.println("Logged in as User: " + user1.getUsername());
            library.displayAvailableBooks();

            // Borrow a book
            Book borrowedBook = library.borrowBook(1);
            if (borrowedBook != null) {
                System.out.println("Book borrowed: " + borrowedBook.getTitle());
            } else {
                System.out.println("Book not available for borrowing.");
            }

            // Display available books after borrowing
            library.displayAvailableBooks();

            // Return the borrowed book
            library.returnBook(borrowedBook);
            System.out.println("Book returned: " + borrowedBook.getTitle());

            // Display available books after returning
            library.displayAvailableBooks();

        } else if (username.equals(admin1.getUsername()) && password.equals(admin1.getPassword())) {
            // Simulate admin interactions
            System.out.println("Logged in as Admin: " + admin1.getUsername());

            // Admin-specific actions can be added here

        } else {
            System.out.println("Invalid username or password.");
        }

        // Close scanner to prevent resource leak
        scanner.close();
    }
}
