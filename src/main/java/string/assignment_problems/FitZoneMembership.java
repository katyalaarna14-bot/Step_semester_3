package string.assignment_problems;

class FitnessMember {
    private String name;

    public FitnessMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum MembershipStatus {
    ACTIVE, FROZEN, EXPIRED
}

class MembershipPlan {
    private String name;
    private int months;
    private double discount;

    public MembershipPlan(String name, int months, double discount) {
        this.name = name;
        this.months = months;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double calculatePrice() {
        return 1000 * months * (1 - discount);
    }
}

class FitnessMembership {
    private FitnessMember member;
    private MembershipPlan plan;
    private MembershipStatus status;

    public FitnessMembership(FitnessMember member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        status = MembershipStatus.ACTIVE;
    }

    public void checkIn() {
        if (status == MembershipStatus.ACTIVE) {
            System.out.println(member.getName() + " checked in successfully.");
        } else {
            System.out.println("Check-in denied. Membership is " + status + ".");
        }
    }

    public void freeze() {
        if (status == MembershipStatus.ACTIVE) {
            status = MembershipStatus.FROZEN;
            System.out.println("Membership frozen.");
        } else {
            System.out.println("Cannot freeze membership: " + status + ".");
        }
    }

    public void unfreeze() {
        if (status == MembershipStatus.FROZEN) {
            status = MembershipStatus.ACTIVE;
            System.out.println("Membership activated.");
        } else {
            System.out.println("Cannot unfreeze membership: " + status + ".");
        }
    }

    public void expire() {
        status = MembershipStatus.EXPIRED;
        System.out.println("Membership expired.");
    }

    public void displayDetails() {
        System.out.println("Member: " + member.getName());
        System.out.println("Plan: " + plan.getName());
        System.out.println("Price: Rs. " + plan.calculatePrice());
        System.out.println("Status: " + status);
        System.out.println();
    }
}

public class FitZoneMembership {
    public static void main(String[] args) {
        MembershipPlan monthly = new MembershipPlan("Monthly", 1, 0);
        MembershipPlan quarterly = new MembershipPlan("Quarterly", 3, 0.10);
        MembershipPlan annual = new MembershipPlan("Annual", 12, 0.25);

        System.out.println("Available Membership Plans:");
        System.out.println("Monthly: Rs. " + monthly.calculatePrice());
        System.out.println("Quarterly: Rs. " + quarterly.calculatePrice());
        System.out.println("Annual: Rs. " + annual.calculatePrice());
        System.out.println();

        FitnessMember member = new FitnessMember("Aarna");
        FitnessMembership membership = new FitnessMembership(member, quarterly);

        membership.displayDetails();
        membership.checkIn();

        membership.freeze();
        membership.checkIn();

        membership.unfreeze();
        membership.checkIn();

        membership.expire();
        membership.checkIn();
        membership.unfreeze();
    }
}