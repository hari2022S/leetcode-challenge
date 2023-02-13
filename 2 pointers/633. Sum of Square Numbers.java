/*Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5*/


class Solution {
    public boolean judgeSquareSum(int c) {
        long a = 0;
        long b = (long)Math.sqrt(c);

        while(a<=b){
            long sumOftwonumbers = (a*a)+(b*b);
            if(sumOftwonumbers == c){
                return true;
            }else if(sumOftwonumbers>c){
                b--;
            }else{
                a++;
            }
        }

        return false;
    }
}
