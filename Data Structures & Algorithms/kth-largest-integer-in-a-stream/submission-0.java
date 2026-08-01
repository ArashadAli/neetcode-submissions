class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int Kth;
    public KthLargest(int k, int[] nums) {
        Kth = k;
        int len = nums.length;
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > Kth) pq.poll();

        return pq.peek();       
    }
}
