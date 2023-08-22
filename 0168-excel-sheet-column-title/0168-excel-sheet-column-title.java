class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";

        while(columnNumber > 0) {
            if(columnNumber%26 == 0) {
                char c = 'Z';
                ans = Character.toString(c) + ans;
                columnNumber --;
            }
            else {
                int c = (columnNumber%26)+64;
                char car = (char)c;
                ans = Character.toString(car) + ans;
            }
            columnNumber /= 26;
        }
        return ans;
    }
}