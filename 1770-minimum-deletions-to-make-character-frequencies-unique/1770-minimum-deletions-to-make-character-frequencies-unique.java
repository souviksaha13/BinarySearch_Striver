class Solution {
    public int minDeletions(String s) {
        int[] ch = new int[26];

        for(int i=0; i<s.length(); i++) {
            ch[s.charAt(i)-'a']++;
        }
        Arrays.sort(ch);
        int ans = 0;

        for(int i=24; i>=0; i--) {
            if(ch[i] == 0) continue;
            if(ch[i] >= ch[i+1]) {
                ans += ch[i]-ch[i+1]+1;
                ch[i] = ch[i+1]-1;
                if(ch[i+1] == 0) {
                    ch[i] = 0;
                    ans--;
                }
            }
        }

        return ans;
    }
}