class Solution {
    public boolean checkZeroOnes(String s) {
        int one = 0, zero = 0, max_one = 0, max_zero = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                one = 0;
                zero++;
                max_zero = Math.max(max_zero, zero);
            }
            else {
                one++;
                zero = 0;
                max_one = Math.max(max_one, one);
            }
        }

        return (max_one > max_zero);
    }
}