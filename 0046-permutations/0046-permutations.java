class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(nums, 0, ans);
        return ans;
    }

    public void rec(int[] nums, int idx, List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> ls = new ArrayList<Integer>();
            for(int el : nums){
                ls.add(el);
            }
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=idx; i<nums.length; i++){
            nums = swap(nums, idx, i);
            rec(nums, idx+1, ans);
            nums = swap(nums, idx, i);
        }
    }

    public int[] swap(int[] nums, int idx, int dest){
        int temp = nums[idx];
        nums[idx] = nums[dest];
        nums[dest] = temp;
        return nums;
    }
}