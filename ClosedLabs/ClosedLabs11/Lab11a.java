public class Lab11a {
    public static void main(String[] args) {
        String s = "";
        double x = 999.0;
        double y = 33.3 * 30.0;
        if (x - y < 0.0001) {
            s="They're equal";
        }
        else {
            s="Not equal!";
        }
        System.out.println(s);
    }
}
