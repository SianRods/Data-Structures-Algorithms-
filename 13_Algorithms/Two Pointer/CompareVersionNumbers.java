import java.util.Arrays;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        String v1 = "1.2";
        String v2 = "1.10";
        System.out.println(compareVersion(v1, v2));
    }

    public static int compareVersion(String version1, String version2) {
        String ver1[] = version1.split("\\.");
        String ver2[] = version2.split("\\.");
        int i = 0;
        int j = 0;
        int n1 = ver1.length;
        int n2 = ver2.length;
        while (i < n1 && j < n2) {
            if (Integer.parseInt(ver1[i]) == Integer.parseInt(ver2[j])) {
                i++;
                j++;
            }

            if (Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[j])) {
                return 1;
            }

            if (Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[j])) {
                return -1;
            }
        }

        // Checking the remaning part of the version if either of the traversal over an
        // array is remaining
        while (i < n1) {
            if (Integer.parseInt(ver1[i]) != 0)
                return 1;
            i++;
        }

        while (j < n2) {
            if (Integer.parseInt(ver2[j]) != 0)
                return -1;
            j++;
        }

        return 0;
    }

}
