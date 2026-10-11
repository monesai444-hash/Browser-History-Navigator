import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * A simple console-based browser history simulator using ArrayDeque.
 * Compatible with Java 8 and later.
 */
public class BrowserHistoryNavigator {
    private final Deque<String> backStack = new ArrayDeque<>();
    private final Deque<String> forwardStack = new ArrayDeque<>();
    private String currentPage = "https://www.google.com";

    private void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
        System.out.println("Opened: " + currentPage);
    }

    private void goBack() {
        if (backStack.isEmpty()) {
            System.out.println("No previous page in history.");
            return;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        System.out.println("Current page: " + currentPage);
    }

    private void goForward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No forward page in history.");
            return;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        System.out.println("Current page: " + currentPage);
    }

    private void showCurrentPage() {
        System.out.println("Current page: " + currentPage);
    }

    private void showHistory() {
        System.out.println("\n--- Back History (most recent first) ---");
        if (backStack.isEmpty()) {
            System.out.println("No previous pages.");
        } else {
            for (String page : backStack) {
                System.out.println(page);
            }
        }

        System.out.println("--- Current Page ---");
        System.out.println(currentPage);

        System.out.println("--- Forward History (next first) ---");
        if (forwardStack.isEmpty()) {
            System.out.println("No forward pages.");
        } else {
            for (String page : forwardStack) {
                System.out.println(page);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BrowserHistoryNavigator browser = new BrowserHistoryNavigator();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Browser History Navigator ===");
                System.out.println("1. Visit a website");
                System.out.println("2. Back");
                System.out.println("3. Forward");
                System.out.println("4. Show current page");
                System.out.println("5. Show full history");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        System.out.print("Enter website URL: ");
                        String url = scanner.nextLine().trim();
                        if (url.isEmpty()) {
                            System.out.println("URL cannot be empty.");
                        } else {
                            if (!url.matches("^[a-zA-Z][a-zA-Z0-9+.-]*://.*")) {
                                url = "https://" + url;
                            }
                            browser.visit(url);
                        }
                        break;
                    case "2":
                        browser.goBack();
                        break;
                    case "3":
                        browser.goForward();
                        break;
                    case "4":
                        browser.showCurrentPage();
                        break;
                    case "5":
                        browser.showHistory();
                        break;
                    case "0":
                        System.out.println("Thanks for using Browser History Navigator!");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            }
        }
    }
}
