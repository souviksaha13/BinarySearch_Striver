/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        preorder(root, mp);
        
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> m : mp.entrySet()){
            max = Math.max(max, m.getValue());
        }
        
        List<Integer> ls = new ArrayList<>();
        for(Map.Entry<Integer, Integer> m : mp.entrySet()){
            if(m.getValue() == max) ls.add(m.getKey());
        }
        
        int[] arr = ls.stream().mapToInt(i -> i).toArray();
        return arr;
    }
    
    public void preorder(TreeNode root, HashMap<Integer, Integer> mp){
        if(root == null) return;
        
        mp.put(root.val, mp.getOrDefault(root.val, 0)+1);
        preorder(root.left, mp);
        preorder(root.right, mp);
    }
}