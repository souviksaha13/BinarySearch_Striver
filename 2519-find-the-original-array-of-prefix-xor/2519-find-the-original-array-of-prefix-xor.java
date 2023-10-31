class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];
        int xor = pref[0];
        
        for(int i=1; i<arr.length; i++){
            xor = xor^pref[i];
            arr[i] = xor;
            xor = pref[i];
        }
        return arr;
    }
}