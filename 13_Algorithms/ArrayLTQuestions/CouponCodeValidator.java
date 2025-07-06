import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;

public class CouponCodeValidator {
    public static void main(String[] args) {

    }

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<List<String>> sol = new ArrayList<>();

        for (int i = 0; i < businessLine.length; i++) {
            if (code[i].matches("^\\w+$")
                    && (businessLine[i].equals("electronics") || businessLine[i].equals("grocery")
                            || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant"))
                    && isActive[i]) {
                sol.add(new ArrayList<>(List.of(businessLine[i], code[i])));
            }
        }

        // Sorting the list as per the mentioned condition
        Collections.sort(sol, (a, b) -> {
            int cmp = a.get(0).compareTo(b.get(0)); // compare first elements
            if (cmp != 0)
                return cmp;
            return a.get(1).compareTo(b.get(1)); // compare second elements if first are equal
        });

        List<String> res = new ArrayList<>();

        for (int i = 0; i < sol.size(); i++) {
            res.add(sol.get(i).get(1));
        }

        return res;

    }
}
