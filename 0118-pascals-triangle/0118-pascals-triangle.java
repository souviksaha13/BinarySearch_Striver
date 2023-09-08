class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            List<Integer> lsa = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) lsa.add(1);
                else {
                    int temp = ls.get(i-1).get(j-1) + ls.get(i-1).get(j);
                    lsa.add(temp);
                }
            }
            ls.add(lsa);
        }
        return ls;
    }
}