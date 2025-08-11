package Weekly

462;

public class MaxKSortPermutation {
    public int sortPermutation(int[] nums) {
        int k;
        for(int i=0;i<nums.length;i++){
                if(nums[i]!=i){
                    k=Math.max(k, i & nums[i]);
                }
        }

        return k;
    }
}
