public class BookAllocation {
    public static void main(String[] args) {
        int arr[] = { 12, 34, 67, 90 };
        int m = 2;
        System.out.println(solution2(arr, m, arr.length));
    }

    // Implementing a brute force solution where we return the minimum
    // Minimum of maximum number of pages each student can hold for multiple books
    // from the books arrays
    // We start exploring from Maximum of the book pages because we want
    // each student to atleast have a single book
    // if no of students required for each of the upper limit is more than m
    // that solution won't work and we would have to just keep exploring
    public static int solution1(int books[], int students, int n) {
        // check if each of the student can atleast have a single book
        if (students > n) {
            return -1;
        }
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        // int n = books.length;

        for (int i = 0; i < n; i++) {
            sum += books[i];
            maxi = Math.max(maxi, books[i]);
        }

        for (int i = maxi; i <= sum; i++) {

            if (noOfStudents(books, i) == students) {
                return i;
            }

        }

        // also if no lower bound value is found we would simply just return the maxi
        // which would atleast allow all the students to carry single book
        return maxi;

    }

    private static int noOfStudents(int[] books, int maxpages) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < books.length; i++) {
            if (sum + books[i] <= maxpages) {
                sum += books[i];

            } else {
                count++;
                sum = books[i];
            }

        }

        // here count denotes total number of students that would be required to grab
        // all the books
        // for a given maximum limit ;
        return count;
    }

    /**
     * 
     * Implementing the binary search solution of the above problem
     * 
     * @param books   array of book ith book with books[i] pages
     * @param student number of students allowed to grab all the possible books
     * @param n       number of books
     * @return
     */
    public static int solution2(int[] books, int students, int n) {
        if (students > n) {
            return -1;
        }
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        // int n = books.length;

        for (int i = 0; i < n; i++) {
            sum += books[i];
            maxi = Math.max(maxi, books[i]);
        }

        // here we have to minimize the maximum number of pages assigned to a student
        int low = maxi;
        int high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int required = noOfStudents(books, mid);
            if (required <= students) {
                high = mid - 1;
            } else if (required > students) {
                low = mid + 1;
            }

        }

        // also if no lower bound value is found we would simply just return the maxi
        // which would atleast allow all the students to carry single book
        return low;

    }

}
