class Solution {
    /*Input: nums = [4,2,5,7]
      Output: [4,5,2,7]
      Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


    List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i]%2 == 0){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0){
                ans[i]=l1.remove(0);
            }else{
                ans[i]=l2.remove(0);
            }
        }

        return ans;*/
    public int[] sortArrayByParityII(int[] nums) {
        int oddNoAtEvenIndex= 0;
        int evenNoAtOddIndex = 1;
        int n = nums.length;
        while (oddNoAtEvenIndex < n && evenNoAtOddIndex < n) {
            while (oddNoAtEvenIndex < n && nums[oddNoAtEvenIndex] % 2 == 0) {
                oddNoAtEvenIndex += 2;
            }
            while (evenNoAtOddIndex < n && nums[evenNoAtOddIndex] % 2 == 1) {
                evenNoAtOddIndex += 2;
            }
            if (evenNoAtOddIndex < n && oddNoAtEvenIndex < n) {
                swap(nums, oddNoAtEvenIndex, evenNoAtOddIndex);
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        if(i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
