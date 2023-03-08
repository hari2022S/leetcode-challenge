class Solution {
    public boolean isPossible(int[] piles, int limit, int h){
        int hours = 0;

        for(int p : piles){
            int pileHours = p/limit;// maximum hours reqiured to complete piles[i]
            if(p%limit != 0) pileHours++;
            hours += pileHours;

            if(hours>h) return false;
        }

        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        int n = piles.length;

        for(int i=0; i<n; i++){
            hi = Math.max(hi,piles[i]);
        }

        int potentialAns = hi;
        while(lo <= hi){
            int mid = (lo + hi)/2;

            if(isPossible(piles,mid,h)){ // checking all piles are eating in given limit or not
                potentialAns = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        return potentialAns;
    }
}
