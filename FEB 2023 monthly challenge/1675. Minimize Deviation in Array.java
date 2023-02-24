class Solution {
/*Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.*/
    public int minimumDeviation(int[] nums) {
        //declare max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // track min value in the array and push odd element by multiply 2
        int minimumOfArray = Integer.MAX_VALUE;
        for(int num : nums){
            if((num % 2) == 1){
                num*=2;
            }
            pq.offer(num);
            minimumOfArray = Math.min(minimumOfArray,num);
        }

        int minDeviation = Integer.MAX_VALUE;
        while(true){
            int maxOfArray = pq.remove(); // remove max ele
            minDeviation = Math.min(minDeviation,maxOfArray-minimumOfArray);
            if(maxOfArray % 2 == 1){// if it is even my ans decrease
                break;
            }
            maxOfArray/=2;
            minimumOfArray = Math.min(minimumOfArray,maxOfArray);
            pq.offer(maxOfArray);
        }

        return minDeviation;
    }
}
