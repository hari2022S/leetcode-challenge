class Solution {
    public int strStr(String haystack, String needle) {
        int hay = haystack.length();
        int need = needle.length();
        if(hay < need) return -1;

        for(int i=0; i<=hay-need; i++){
            int j=0;
            while(j<need && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
                if(j == need) return i;
            }
        }
        return -1;
    }
}
