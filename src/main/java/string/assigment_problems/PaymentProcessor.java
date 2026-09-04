package string.assigment_problems;

class Payment {

    public double pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
        return amount;
    }
}

class CardPayment extends Payment {

    public double payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);

        System.out.println("Charged (card, incl. fee): Rs "
                + total);

        return total;
    }
}

public class PaymentProcessor {

    public void processTransaction(Payment payment, double amount) {

        if (payment instanceof CardPayment) {

            CardPayment cardPayment =
                    (CardPayment) payment;

            cardPayment.payWithProcessingFee(amount);

        } else {
            payment.pay(amount);
        }
    }

    public static void main(String[] args) {

        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {
            100, 50, 200, 75, 120
        };

        PaymentProcessor processor =
                new PaymentProcessor();

        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {

            if (payments[i] instanceof CardPayment) {
                totalCollected += amounts[i]
                        + (amounts[i] * 0.02);
            } else {
                totalCollected += amounts[i];
            }

            processor.processTransaction(
                    payments[i], amounts[i]);
        }

        System.out.println("Total Collected: Rs "
                + totalCollected);
    }
}
