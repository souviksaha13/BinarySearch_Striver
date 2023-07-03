class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        if(s.equals(goal)) {
            HashSet<Character> hs = new HashSet<>();
            for(int i=0; i<s.length(); i++) {
                if(hs.contains(s.charAt(i))) return true;
                else hs.add(s.charAt(i));
            }
            return false;
        }

        else {
            int count = 0;
            int[] dif = new int[2];

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) != goal.charAt(i)) {
                    if(++count > 2) return false;
                    dif[count-1] = i;
                }
            }
            if(count != 2) return false;
            if(s.charAt(dif[0]) == goal.charAt(dif[1]) && s.charAt(dif[1]) == goal.charAt(dif[0])) return true;
        }

        return false;
    }
}