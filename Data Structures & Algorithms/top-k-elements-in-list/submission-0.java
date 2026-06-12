class Pair{
    int val;
    int count;
    Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Pair[] store = new Pair[map.size()];
        int ind = 0;
        for(Map.Entry<Integer, Integer> key : map.entrySet()){
            Pair p = new Pair(key.getKey(), key.getValue());
            store[ind++] = p;
        }

        Arrays.sort(store, (a, b) -> Integer.compare(b.count, a.count));
        int[] res = new int[k];

        for(int i = 0; i < k; i++) {
            Pair p = store[i];
            res[i] = p.val;
        }
        return res;
    }
}