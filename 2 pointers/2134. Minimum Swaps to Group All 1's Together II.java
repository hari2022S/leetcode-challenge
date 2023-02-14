class Solution {
    public int minSwaps(int[] nums) {
        int numOfOnes = 0;
        for( int i=0; i<nums.length; i++){
            if(nums[i]==1) numOfOnes++;
        }

        int start = 0;
        int end = 0;
        int curr_window_ones = 0;
        
        while( end < numOfOnes ){
            if(nums[end] == 1){
                curr_window_ones++;
            }
            end++;
        }
        int ans = numOfOnes - curr_window_ones;
        while( end < 2*nums.length){
            if(nums[end%nums.length] == 1){
                curr_window_ones++;
            }
            if(nums[start%nums.length] == 1){
                curr_window_ones--;
            }

            ans = Math.min(ans,numOfOnes-curr_window_ones);
            start++;
            end++;
        }

        return ans;
    }
}
