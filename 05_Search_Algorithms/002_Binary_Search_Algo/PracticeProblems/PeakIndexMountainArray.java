public class PeakIndexMountainArray {
    public static void main(String args[]) {
        int arr[] = {24,69,100,99,79,78,67,36,26,19};
        System.out.println("The peak index is :" + getPeakIndex(arr));

    }

    static int getPeakIndex(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int middle = (start + end) / 2;

        do {
            if (arr[middle + 1] - arr[middle] < 0) {
                if (arr[middle] - arr[middle-1] > 0) {
                    return middle;
                }else{
                    end=middle-1;
                    middle=(start+end)/2;
                }
            } else if (arr[middle + 1] - arr[middle] >= 0) {
                start = middle + 1;
                middle = (start + end) / 2;
            }
        } while (!(start > end));
        return -1;
    }

}
