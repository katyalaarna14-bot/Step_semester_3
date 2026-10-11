
package string.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountWithdrawalSystem {

    static class BankAccount {
        String id;
        String type;
        int balance;

        BankAccount(String id, String type, int balance) {
            this.id = id;
            this.type = type;
            this.balance = balance;
        }

        void withdraw(int amount) {
            if (type.equals("Savings") && balance - amount < 1000) {
                System.out.println(id + " rejected: minimum balance 1000");
            } else if (type.equals("Current") && balance - amount < -5000) {
                System.out.println(id + " rejected: overdraft limit 5000");
            } else {
                balance -= amount;
                System.out.println(id + " balance " + balance);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("Savings") || operation.equals("Current")) {
                String id = sc.next();
                int balance = sc.nextInt();

                accounts.put(id, new BankAccount(id, operation, balance));

            } else if (operation.equals("WITHDRAW")) {
                String id = sc.next();
                int amount = sc.nextInt();

                if (accounts.containsKey(id)) {
                    accounts.get(id).withdraw(amount);
                } else {
                    System.out.println("Account not found");
                }
            }
        }

        sc.close();
    }
}
