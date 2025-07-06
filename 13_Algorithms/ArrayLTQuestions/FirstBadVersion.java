public class FirstBadVersion {
    public static void main(String[] args) {

    }

    static int firstBadVerion(int n) {
        // All the versions are in the sorted orders
        int s = 1;
        int e = n;
        int m = s + (e - s) / 2;

        while (s < e) {
            m =(s+e)/2;
            if(isBadVersion(m) && !isBadVersion(m-1)){
                return m;
            }else if (isBadVersion(m) && isBadVersion(m-1)) {
                e =m-1;;
            }else{
                s=m+1;
            }
        }

        return -1;

    }

    static boolean isBadVersion(int number){
        return true | false;
    }
}
