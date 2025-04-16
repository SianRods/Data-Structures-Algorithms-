import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(createTriangle(5));
    }

    static List<List<Integer>> createTriangle(int numRows) {
        List<List<Integer>> tr = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            tr.add(i,new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                  tr.get(i).add(j,1);
                } else {
                    if(i>1){
                    tr.get(i).add(j,tr.get(i-1).get(j-1)+tr.get(i-1).get(j));
                    }
                }
            }
        }

        return tr;
    }

}
