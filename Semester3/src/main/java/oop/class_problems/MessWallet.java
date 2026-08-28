public class MessWallet {

    String studentName;
    double balance;

    MessWallet(String studentName, double balance) {
        this.studentName = studentName;
        this.balance = balance;
    }

    void addMoney(double amount) {
        balance += amount;
    }

    void spend(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void showBalance() {
        System.out.println(studentName + " -> Balance: " + balance);
    }

    public static void main(String[] args) {

        MessWallet w1 = new MessWallet("Ravi", 500);
        MessWallet w2 = new MessWallet("Anitha", 300);

        w1.addMoney(200);
        w1.spend(150);

        w2.spend(350);

        w1.showBalance();
        w2.showBalance();
    }
}