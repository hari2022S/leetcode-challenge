class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        boolean minFound = false, maxFound = false;
        int minStart = 0,maxStart = 0;
        int start = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<minK || nums[i]>maxK){
                start = i+1;
                minFound = false;
                maxFound = false;
            } if(nums[i] == minK){
                minFound = true;
                minStart = i;
            } if(nums[i] == maxK){
                maxFound = true;
                maxStart = i;
            }if(minFound && maxFound){
                ans+=Math.min(minStart,maxStart)-start+1;
            }
        }

        return ans;
    }
}
