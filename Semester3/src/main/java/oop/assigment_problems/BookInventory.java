public class BookInventory {

    String isbn;
    String title;
    int quantity;
    double price;

    BookInventory(String isbn, String title, int quantity, double price) {
        this.isbn = isbn;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    double inventoryValue() {
        return quantity * price;
    }

    void restock(int amount) {
        quantity += amount;
    }

    void sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
        } else {
            System.out.println("Sell rejected: insufficient stock");
        }
    }

    void printStock() {
        System.out.println(
            isbn + " | " + title + " | qty=" + quantity + " | value=" + inventoryValue()
        );
    }

    public static void main(String[] args) {

        BookInventory book = new BookInventory(
            "978-0134685991", "Effective Java", 10, 45.00
        );

        book.restock(5);
        book.sell(12);
        book.printStock();
    }
}
