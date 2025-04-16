import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfArrays {
    public static void main(String[] args) {
        // int nums1[] = {1,2,2,1};
        // int nums2[] = {2,2};
        int nums1[] = {4,9,5};
        int nums2 [] = {9,4,9,8,4};
        System.out.println("The Intersection of both the arrays "+Arrays.toString(intersect(nums1, nums2)));
    }

    static int [] intersect(int nums1[], int nums2[]) {
        // Sort 1 --> apply binary search on it 
        // another one use to check the existence of the same element
        Arrays.sort (nums1);
        Arrays.sort(nums2);

        int i =0;
        int j=0;
        ArrayList<Integer> sol = new ArrayList<>();
        
        // while(i! nums1.length-1 && j!=nums2.length-1){
            do{
            if (nums1[i]==nums2[j]){
                if(!sol.isEmpty() && nums1[i]==sol.getLast()){
                    continue;
                }else{
                    sol.add (nums1[i]);
                    i++;
                    j++;
                }
            }
            else if (nums1[i]>nums2[j]){
                j++;
            }else{
                i++;    
            }
        }while(i!=nums1.length && j!=nums2.length);



        return  sol.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
