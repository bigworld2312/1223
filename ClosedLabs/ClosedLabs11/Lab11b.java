public class Lab11b {
    public static void main(String[] args) {
        int[] x = {3, 5, -7, 4, -2};

        for (int i = 0; i < x.length; i++) {
            int evenCheck = x[i] % 2;
            String s;
            if (evenCheck == 0 ) {
                s = "Even!";
            }
            else {
                s = "Odd!";
            }
            System.out.println(s);
        }
    }
}
