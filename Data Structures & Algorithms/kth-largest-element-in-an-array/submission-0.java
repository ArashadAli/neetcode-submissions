class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            pq.offer(nums[i]);
            if(pq.size() > k) pq.poll();
        }

        if(pq.size() == 0) return 0;
        return pq.peek();
    }
}
