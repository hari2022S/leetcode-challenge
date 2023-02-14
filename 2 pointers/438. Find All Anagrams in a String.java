class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()) return ans;
        int unMatchedcount = p.length();

        // creating freq map;
        int[] map = new int[26];
        for( int i = 0; i<p.length(); i++){
            int index = p.charAt(i)-'a';
            map[index]++;
        }
        // s= c b a e b a b a c d p = abc ummatchedcount = 3;
        //    s     e 
        int start = 0;
        for( int end = 0; end < p.length(); end++){
            int idx = s.charAt(end)-'a';
            if(map[idx]>0){
                unMatchedcount--;
            }
            map[idx]--;
        }

        if(unMatchedcount == 0){
            ans.add(start);
        }
        int end = p.length();
        while(end < s.length()){
            int s_idx = s.charAt(start)-'a';
            if(map[s_idx] >= 0){
                unMatchedcount++;
            }
            map[s_idx]++;
            start++;

            int e_idx = s.charAt(end)-'a';
            if(map[e_idx]>0){
                unMatchedcount--;
            }
            map[e_idx]--;

            if(unMatchedcount == 0){
            ans.add(start);
            }
            end++;
        }

        return ans;
        
    }
}
