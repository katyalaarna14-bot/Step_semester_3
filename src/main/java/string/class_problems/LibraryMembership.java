package string.class_problems;

class LibraryMember {

    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;

    private int[] fineHistory = new int[10];
    private int fineCount;

    private static int membersEnrolled = 0;
    final String memberNumber;

    public LibraryMember(String memberId, int borrowLimit) {

        if (memberId == null ||
            memberId.trim().isEmpty() ||
            memberId.length() < 4) {
            throw new IllegalArgumentException();
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;

        membersEnrolled++;
        memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public LibraryMember(int borrowLimit) {
        this.borrowLimit = borrowLimit;

        membersEnrolled++;
        memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit)
            booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String displayInfo() {
        return "General Member | Books Borrowed: " + booksBorrowed;
    }

    protected void chargeFine(int amount) {

        if (fineCount < 10)
            fineHistory[fineCount++] = amount;
    }

    public int[] getFineHistory() {

        int[] copy = new int[fineCount];

        for (int i = 0; i < fineCount; i++)
            copy[i] = fineHistory[i];

        return copy;
    }

    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++)
            total += fineHistory[i];

        return total;
    }

    static String enrollBatch(String[] memberIds, int borrowLimit) {

        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {

            try {
                new LibraryMember(id, borrowLimit);
                enrolled++;
            }
            catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled +
               " | Rejected: " + rejected;
    }

    static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'R' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class StudentMember extends LibraryMember {

    private String course;

    public StudentMember(String memberId, int borrowLimit,
                         String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course +
               " | Books Borrowed: " + getBooksBorrowed();
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}