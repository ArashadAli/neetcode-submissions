class Solution {
    class Task{
        int time;
        int freq;
        public Task(int time, int freq) {
            this.time = time;
            this.freq = freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] frequenecy = new int[26];
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return -Integer.compare(t1.freq, t2.freq);
            }
        });
        for(char task : tasks) {
            frequenecy[task - 'A']++;
        }

        for(int i = 0; i < 26; i++) {
            if(frequenecy[i] >= 1) pq.offer(new Task(0, frequenecy[i]));
        }

        Queue<Task> que = new LinkedList<>();
        while(!pq.isEmpty() || !que.isEmpty()) {
            if(!que.isEmpty() && time - que.peek().time > n) {
                pq.offer(que.remove());
            }

            if(!pq.isEmpty()) {
                Task t = pq.poll();
                t.freq--;
                t.time = time;

                if(t.freq > 0) que.offer(t);
            }
            time++;
        }
        return time;
    }
}
