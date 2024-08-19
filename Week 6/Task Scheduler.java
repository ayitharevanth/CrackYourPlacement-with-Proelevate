class Solution {
    class Task {
        int freq, lastUsed = -1;
        public Task(int f) { freq = f; }
    }

    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        
        Map<Character, Task> map = new HashMap<>();
        for(char c: tasks) {
            map.putIfAbsent(c, new Task(0));
            map.get(c).freq++;
        }
        
        PriorityQueue<Task> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

        Queue<Task> cooling = new LinkedList<>();
        
        pq.addAll(map.values());
        int count = 0;
        
        while(!pq.isEmpty() || !cooling.isEmpty()) {
            if(pq.isEmpty()) count = cooling.peek().lastUsed + n + 1;
            
            while(!cooling.isEmpty() && count > cooling.peek().lastUsed + n) {
                pq.add(cooling.poll());
            }
            
            Task t = pq.poll();
            t.lastUsed = count++;
            t.freq--;
            
            if(t.freq != 0) cooling.add(t);
        }
        
        return count;
    }
}
