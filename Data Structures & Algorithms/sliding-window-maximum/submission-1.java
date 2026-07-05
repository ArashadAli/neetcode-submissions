class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i <= len - k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            list.add(max);
        }
        int[] store = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            store[i] = list.get(i);
        }
        return store;
    }
}
