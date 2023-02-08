// sample test case --> nums[]={3 4 2 1 1 3 5 2 1};
// return min jumps = 3

class Solution {
    public int jump(int[] nums) {
        // greedy algo
        // TC O(N) sc O(1)
        int max = 0;
        int curr = 0;
        int jumps = 0;

        for(int i = 0; i < nums.length-1; i++){
            max = Math.max(max, i+nums[i]);

            if(curr == i){
                curr = max;
                jumps++;
            }
            if(curr > nums.length){
                return jumps;
            }
        }
        return jumps;
    }
}
