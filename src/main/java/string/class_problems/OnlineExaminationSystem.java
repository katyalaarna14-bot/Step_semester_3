package string.class_problems;

import java.util.ArrayList;
import java.util.List;

abstract class Question {
    protected String text;
    protected int marks;

    Question(String text, int marks) {
        this.text = text;
        this.marks = marks;
    }

    abstract int evaluate(String answer);
}

class MCQQuestion extends Question {
    private String correctAnswer;

    MCQQuestion(String text, int marks, String correctAnswer) {
        super(text, marks);
        this.correctAnswer = correctAnswer;
    }

    int evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer) ? marks : 0;
    }
}

class TrueFalseQuestion extends Question {
    private String correctAnswer;

    TrueFalseQuestion(String text, int marks, String correctAnswer) {
        super(text, marks);
        this.correctAnswer = correctAnswer;
    }

    int evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer) ? marks : 0;
    }
}

class ShortAnswerQuestion extends Question {
    private String correctAnswer;

    ShortAnswerQuestion(String text, int marks, String correctAnswer) {
        super(text, marks);
        this.correctAnswer = correctAnswer;
    }

    int evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim()) ? marks : 0;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Examination {
    String title;
    List<Question> questions = new ArrayList<>();

    Examination(String title) {
        this.title = title;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }
}

class Attempt {
    private Student student;
    private Examination exam;
    private List<String> answers = new ArrayList<>();
    private boolean submitted = false;

    Attempt(Student student, Examination exam) {
        this.student = student;
        this.exam = exam;
    }

    void answerQuestion(int index, String answer) {
        if (submitted) {
            System.out.println("Attempt is locked.");
            return;
        }

        while (answers.size() <= index) {
            answers.add("");
        }

        answers.set(index, answer);
    }

    void submit() {
        if (submitted) {
            System.out.println("Attempt already submitted.");
            return;
        }

        submitted = true;
        int total = 0;

        System.out.println("Results for " + student.name);
        for (int i = 0; i < exam.questions.size(); i++) {
            String answer = i < answers.size() ? answers.get(i) : "";
            int score = exam.questions.get(i).evaluate(answer);
            total += score;
            System.out.println("Question " + (i + 1) + ": " + score
                    + "/" + exam.questions.get(i).marks);
        }

        System.out.println("Total score: " + total);
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Student student = new Student("Aarna");
        Examination exam = new Examination("Java Basics");

        exam.addQuestion(new MCQQuestion(
                "Java runs on which platform?", 2, "JVM"));
        exam.addQuestion(new TrueFalseQuestion(
                "Java supports inheritance.", 1, "true"));
        exam.addQuestion(new ShortAnswerQuestion(
                "Keyword for creating an object?", 2, "new"));

        Attempt attempt = new Attempt(student, exam);
        attempt.answerQuestion(0, "JVM");
        attempt.answerQuestion(1, "true");
        attempt.answerQuestion(2, "new");
        attempt.submit();
        attempt.answerQuestion(0, "wrong");
        attempt.submit();
    }
}