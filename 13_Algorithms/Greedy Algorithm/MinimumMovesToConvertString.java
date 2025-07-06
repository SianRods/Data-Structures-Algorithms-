public class MinimumMovesToConvertString {
    public static void main(String[] args) {
        String sample="XXX";
        System.out.println(minimumMoves(sample));
    }


    // Important Test Case : "0X0X" OUTPUT => 1

    public static int minimumMoves(String s) {
        int i = 0;
        int cnt = 0;
        for (; i <= s.length() - 3; i+=3) {
            if(s.substring(i, i+3).indexOf('X')!=-1){
                cnt++;
            }
        }

        return cnt;
    }
}
