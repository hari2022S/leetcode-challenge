class Solution {
    public int maxTurbulenceSize(int[] arr) {
        // tc o(n)
        int n = arr.length;
        if(n < 2) return n;

        int i = 0;
        int j = 0;
        int ans = 1;

        while(i+1 < n){
            if(arr[i] == arr[i+1]){
                i++;
                continue;
            }
            j = i + 1;
            while( j+1 < n && isTurbulent(arr, j)){
                j++;
            }
            ans = Math.max(ans, j - i + 1);
            i=j;
        }

        return ans;
    }

    public boolean isTurbulent(int[] arr, int end){
        if((arr[end]>arr[end-1] && arr[end]>arr[end+1]) || (arr[end]<arr[end+1] && arr[end]<arr[end-1])){
            return true;
        }
        return false;
    }
}
