package string.assignment_problems;

class GymMember {

    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    private int[] lateFeeHistory = new int[10];
    private int feeCount;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null ||
            memberId.trim().isEmpty() ||
            memberId.length() < 4) {
            throw new IllegalArgumentException();
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }

    protected void chargeLateFee(int amount) {
        if (feeCount < 10)
            lateFeeHistory[feeCount++] = amount;
    }

    public int[] getLateFeeHistory() {
        int[] copy = new int[feeCount];

        for (int i = 0; i < feeCount; i++)
            copy[i] = lateFeeHistory[i];

        return copy;
    }

    public int getTotalLateFees() {
        int total = 0;

        for (int i = 0; i < feeCount; i++)
            total += lateFeeHistory[i];

        return total;
    }

    static String signUpBatch(String[] memberIds, int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp +
               " | Rejected: " + rejected;
    }
}

class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee,
                         String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName +
               " | Sessions: " + getSessionsAttended();
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class GymMembership {
}