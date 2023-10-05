class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE, c1 = 0, c2 = 0;

        for(int el : nums){
            if(el == num1) c1++;
            else if(el == num2) c2++;

            else if(c1 == 0) {
                num1 = el;
                c1 = 1;
            }
            else if(c2 == 0){
                num2 = el;
                c2 = 1;
            }

            else {
                c1--;
                c2--;
            }
        }

        // if there is to exist majority elements, then it will surely be num1 or num2 or both, but it is not sure that they are the majority elements, so we need to check the count of their occurences

        c1=c2=0;
        for(int el : nums){
            if(el == num1) c1++;
            else if(el == num2) c2++;
        }
        List<Integer> ans = new ArrayList<>(2);
        if(c1 > nums.length/3) ans.add(num1);
        if(c2 > nums.length/3) ans.add(num2);

        return ans;
    }
}