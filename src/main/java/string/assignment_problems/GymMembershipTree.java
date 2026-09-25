package string.assignment_problems;

class EliteMember extends PremiumMember {

    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee,
                       String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + getTrainerName() +
               " | Locker: " + lockerNumber +
               " | Sessions: " + getSessionsAttended();
    }
}

class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(String memberId, int monthlyFee,
                            String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className +
               " | Sessions: " + getSessionsAttended();
    }
}

public class GymMembershipTree {

    static String classifyGeneration(GymMember member) {

        if (member instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";

        return "General Member";
    }

    static int getTotalSessionsAttended(GymMember[] members) {

        int total = 0;

        for (GymMember member : members)
            total += member.getSessionsAttended();

        return total;
    }
}