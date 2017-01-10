
public class Lab14a {

    /*
     * A simple program used to test the SimpleStringBuilder class
     */
    public static void main(String[] args) {
        SimpleStringBuilder myBuilder = new SimpleStringBuilder("Hello World");
        System.out.println(myBuilder.toString());

        // Code below this comment will not work until you complete Exercise 1
        System.out.println(myBuilder.length());
        System.out.println(myBuilder.charAt(3));
        myBuilder.replaceCharAt(3, 'p');
        System.out.println(myBuilder.toString());

        // Code below this comment will not work until you complete Exercise 2
       myBuilder.append('!');
       System.out.println(myBuilder.toString());
       myBuilder.deleteCharAt(3);
       System.out.println(myBuilder.toString());
       System.out.println(myBuilder.length());
       myBuilder.insert(3, 'z');
       System.out.println(myBuilder.toString());
       System.out.println(myBuilder.length());

    }

}
