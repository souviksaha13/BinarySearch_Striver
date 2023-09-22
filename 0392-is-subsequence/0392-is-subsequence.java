class Solution {
    public boolean isSubsequence(String s, String t) {
        int cnt = 0;

        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        for(int i=0; i<t.length(); i++) {
            if(s.charAt(cnt) == t.charAt(i)) {
                cnt++;
                if(cnt == s.length()) break;
            }
        }

        if(cnt < s.length()) return false;
        return true;
    }
}