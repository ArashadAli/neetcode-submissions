class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class DistPair {
    int dist;
    Pair p;
    DistPair(int dist, Pair p) {
        this.dist = dist;
        this.p = p;
    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        int[][] res = new int[k][2];
        PriorityQueue<DistPair> pq = new PriorityQueue<>(Comparator.comparingInt((DistPair d) -> d.dist).reversed());
        for(int i = 0; i < len; i++) {
            int x = points[i][0];
            int y = points[i][1];
            Pair p = new Pair(x, y);
            int dist = ((x * x) + (y * y));
            DistPair dp = new DistPair(dist, p);
            pq.offer(dp);
            if(pq.size() > k) pq.poll();
        }
        int i = 0;
        while(!pq.isEmpty()) {
            DistPair dp = pq.poll();
            res[i][0] = dp.p.x;
            res[i][1] = dp.p.y;
            i++;
        }
        return res;
    }
}