public class RotateString {
    public static void main(String[] args) {

        String s = "abcde";
        String goal = "cdeab";
        System.out.println(isRotated(s, goal));

    }

    public static boolean isRotated(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        return (s + s).contains(goal);

    }

}
