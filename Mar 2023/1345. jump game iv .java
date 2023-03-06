class Solution {
    public int minJumps(int[] arr) {
        // graph related
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(!hm.containsKey(arr[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hm.put(arr[i],list);
            }else{
                ArrayList<Integer> list = hm.get(arr[i]);
                list.add(i);
                hm.put(arr[i],list);
            }
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        vis[0] = true;
        int steps = 0;

        while(q.size() > 0){
           int size = q.size();

           for(int j=0; j<size; j++){
               int curr = q.remove();
               if(curr == n-1) return steps;

               ArrayList<Integer> list = hm.get(arr[curr]);
               list.add(curr+1);
               list.add(curr-1);
               for(int e : list){
                   if(e>=0 && e<n && !vis[e]){
                       vis[e] = true;
                       q.add(e);
                   }
               }
               list.clear();
           }

           steps++;
        }

        return -1;
    }
}
