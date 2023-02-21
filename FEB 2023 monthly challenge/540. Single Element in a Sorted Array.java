class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }else if((nums[mid] == nums[mid+1] && mid % 2 == 0) || nums[mid] == nums[mid-1] && mid % 2 != 0){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }

        return nums[lo];
    }
}
