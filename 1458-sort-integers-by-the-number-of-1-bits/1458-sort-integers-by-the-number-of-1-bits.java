class Solution {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0; i<14; i++){
            ls.add(new ArrayList<>());
        }

        for(int el : arr){
            ls.get(count(el)).add(el);
        }

        int i=0;
        for(int j=0; j<ls.size(); j++){
            for(int k=0; k<ls.get(j).size(); k++){
                if(i<arr.length) arr[i++] = ls.get(j).get(k);
            }
        }
        return arr;
    }

    public int count(int n){
        int ans = 0;
        while(n != 0){
            if(n%2 != 0) ans++;
            n /= 2;
        }
        return ans;
    }
}
