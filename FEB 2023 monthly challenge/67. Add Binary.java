class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while(i>=0 || j>=0 || carry!=0){
            if(i>=0){
                carry+=a.charAt(i)-'0';
                i--;
            }

            if(j>=0){
                carry+=b.charAt(j)-'0';
                j--;
            }

            sb.append(carry%2);
            carry=carry/2;
        }

        return sb.reverse().toString();
    }
}
