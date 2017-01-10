public class Lab11d {
    public static void main(String[] args) {
        String s = "Hello";
        char c1 = 'x';
        char c2 = 'y';

        String s1 = c1 + s;
        String s2 = c2 + s;
        String s3 = "" + c1 + c2 + s;

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
