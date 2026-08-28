package string.class_problems;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf(
                    "%d      | %.2f       | %.2f       | %.2f | %s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi)
            );
        }
    }

    public static void main(String[] args) {

        double[] heights = {
            1.75, 1.60, 1.80, 1.65, 1.70,
            1.55, 1.72, 1.68, 1.82, 1.58
        };

        double[] weights = {
            70, 90, 65, 80, 55,
            45, 75, 68, 95, 60
        };

        printWellnessReport(heights, weights);
    }
}