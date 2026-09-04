package string.class_problems;

class FeeAccount {

    public void pay(double amount) {
        System.out.println(
            "Paid in one go (day-scholar account)"
        );
    }
}

class HostelFeeAccount extends FeeAccount {

    @Override
    public void pay(double amount) {
        System.out.println(
            "Paid in two installments (hostel account)"
        );
    }
}

public class FeeAccountProcessor {

    public void processPayment(
            FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {

            HostelFeeAccount hostel =
                    (HostelFeeAccount) account;

            hostel.pay(amount);

        } else {
            account.pay(amount);
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        FeeAccountProcessor processor =
                new FeeAccountProcessor();

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (int i = 0; i < accounts.length; i++) {

            processor.processPayment(accounts[i], 60000);

            if (accounts[i] instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println(
            "Hostel accounts processed: " + hostelCount
            + " | Day-scholar accounts processed: "
            + dayScholarCount
        );
    }
}