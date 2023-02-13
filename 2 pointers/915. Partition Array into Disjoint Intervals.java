/*Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]*/


class Solution {
    public int partitionDisjoint(int[] nums) {
        // leftmax should be less than rigthmin
        int n = nums.length;
        int leftmax[] = new int[n];// 5 5 5 8 8
        leftmax[0]=nums[0];
        for(int i=1; i<n; i++){
            leftmax[i]=Math.max(leftmax[i-1],nums[i]);
        }

        int[] rightmin = new int[n];// 0 0 3 6 6
        rightmin[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--){
            rightmin[i]=Math.min(rightmin[i+1],nums[i]);
        }

        for(int i=1 ;i<n; i++){
            if(leftmax[i-1]<=rightmin[i]){
                return i;
            }
        }

        return 0;
    }
}
