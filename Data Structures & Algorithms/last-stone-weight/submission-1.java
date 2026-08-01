class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int len = stones.length;
        for(int i = 0; i < len; i++) {
            pq.offer(stones[i]);
        }

        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if(x == y){}
            else if(x < y) {
                pq.offer(y - x);
            }
            else{
                pq.offer(x - y);
            }
        }
        if(pq.size() == 0) return 0;
        return pq.peek();
    }
}
