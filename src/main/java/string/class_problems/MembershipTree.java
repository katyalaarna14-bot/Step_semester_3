package string.class_problems;

class HonorsStudentMember extends StudentMember {

    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit,
                               String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public String displayInfo() {
        return "Honors Student Member | Course: " + getCourse() +
               " | Bonus Limit: " + bonusLimit +
               " | Books Borrowed: " + getBooksBorrowed();
    }
}

class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(String memberId, int borrowLimit,
                         String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department +
               " | Books Borrowed: " + getBooksBorrowed();
    }
}

public class MembershipTree {

    static String classifyGeneration(LibraryMember member) {

        if (member instanceof HonorsStudentMember)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof FacultyMember)
            return "Hierarchical sibling (independent branch)";

        return "General Member";
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {

        int total = 0;

        for (LibraryMember member : members)
            total += member.getBooksBorrowed();

        return total;
    }
}