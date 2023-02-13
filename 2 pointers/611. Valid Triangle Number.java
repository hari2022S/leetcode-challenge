// TC O(nlogn)
/*Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3*/
class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for(int i=2; i<nums.length; i++){
            int first = 0;
            int second = i-1;
            while(first < second){
                if(nums[first]+nums[second] > nums[i]){
                    count+= second - first;
                    second--;
                }else{
                    first++;
                }
            }
        }

        return count;
    }
}
