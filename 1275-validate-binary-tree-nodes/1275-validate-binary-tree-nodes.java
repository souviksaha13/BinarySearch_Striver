class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        TreeNode[] arr = new TreeNode[n];

        for(int i=0; i<n; i++) {
            arr[i] = new TreeNode(i);
        }

        Set<Integer> hs = new HashSet<>();

        for(int i=0; i<n; i++) {
            if(leftChild[i] != -1) {
                arr[i].left = arr[leftChild[i]];
                hs.add(leftChild[i]);
            }

            if(rightChild[i] != -1) {
                arr[i].right = arr[rightChild[i]];
                hs.add(rightChild[i]);
            }
        }
        if(hs.size() != n-1) return false;
        int root = -1;
        for(int i=0; i<n; i++) {
            if(!hs.contains(i)) root = i;
        }
        boolean[] vis = new boolean[n];

        boolean check = inorder(arr[root], vis);
        if(!check) return false;

        for(int i=0; i<n; i++) {
            if(!vis[i]) return false;
        }

        return true;
    }

    public boolean inorder(TreeNode root, boolean[] vis) {
        if(root == null) return true;
        if(vis[root.val]) return false;
        vis[root.val] = true;
        boolean l = inorder(root.left, vis);
        boolean r = inorder(root.right, vis);

        return (l && r);
    }
}