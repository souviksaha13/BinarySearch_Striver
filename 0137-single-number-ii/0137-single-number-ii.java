class Solution {
    // // Brute Force (using Map)
    // public int singleNumber(int[] nums) {
    //     HashMap<Integer, Integer> mp  = new HashMap<>();

    //     for(Integer el : nums) {
    //         // count the frequency of the element in the array
    //         mp.put(el, mp.getOrDefault(el, 0)+1);
    //         // if frequency is 3 -> remove th element
    //         mp.remove(el, 3);
    //     }

    //     for(Integer ans : mp.keySet()) return ans;
    //     return 0;
    // }

    // Brute Force (using hashset)
    // public int singleNumber(int[] nums) {
    //     HashSet<Integer> ones = new HashSet<>();
    //     HashSet<Integer> twos = new HashSet<>();

    //     for(Integer el : nums) {
    //         // element appears for the first time
    //         if(!ones.contains(el) && !twos.contains(el)) ones.add(el);
    //         // element appears for the second time
    //         else if(ones.contains(el)) {
    //             ones.remove(el);
    //             twos.add(el);
    //         }
    //         // element appears thrice
    //         else {
    //             twos.remove(el);
    //         }
    //     }

    //     for(Integer el : ones) return el;
    //     return 0;
    // }

    // Optimized Solution
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        // when element appears once -> it is stored in ones
        // when element appears twice -> it is removed from ones and stored in twos
        // when element appears thrice -> it is removed from twos
        for(int el : nums) {
            ones = (ones ^ el) & (~twos);
            twos = (twos ^ el) & (~ones);
        }

        return ones;
    }
}