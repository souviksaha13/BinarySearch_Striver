class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        return check(n);
    }

    public boolean check(int n){
        if(n==1) return true;
        return (n%4 == 0) && check(n/4);
    }
}