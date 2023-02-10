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
        
        // approch 2 using queue
        int n = nums.length;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int jumps = 0;

        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int idx = q.remove();
                if(idx == n-1) return jumps;
                for(int jump=1; jump <= nums[idx]; jump++){
                    
                    if(idx + jump >= n){
                        break;
                    }

                    if(vis[idx + jump] == false){
                        q.add(idx+jump);
                        vis[idx + jump] = true;
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
}
