class Solution {
    public int compress(char[] chars) {
        int st = 0;
        for(int i=0; i<chars.length; i++){
            char curr = chars[i];
            int j = i+1;
            int cnt = 1;
            while(j < chars.length && chars[j] == curr){
                j++;
                cnt++;
            }

            chars[st++] = curr;

            if(cnt != 1){
                String count = String.valueOf(cnt);

                for(int k=0; k<count.length(); k++){
                    chars[st++]=count.charAt(k);
                }
            }

            i=j-1;
        }

        return st;
    }
}
