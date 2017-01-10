public class Lab11c {
    public static String getGrade(int value) {
        String grade = "";
        if (value >= 75) {
            grade = "Above Average";
        }
        else if (value < 60) {
            grade = "Failing";
        }
        else {
            grade = "Passing";
        }
        return grade;
    }

    public static void main(String[] args) {
        int grade = 88;
        String s = getGrade(grade);
        System.out.println(s);
    }
}
