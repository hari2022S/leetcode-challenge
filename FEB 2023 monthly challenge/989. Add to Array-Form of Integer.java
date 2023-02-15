//input :  num {1,2,0,0} k = 34 
// output : {1,2,3,4}
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        int digi = 0;
        int i = num.length-1;

        while( i>=0 || k>0 || carry>0){
            digi = carry;
            if(i>=0) digi+=num[i--];
            if(k>0) digi+=k%10;
            ans.add(digi % 10);
            k/=10;
            carry=digi/10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
