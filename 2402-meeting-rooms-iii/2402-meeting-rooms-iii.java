class Solution {
    public int mostBooked(int n, int[][] meetings) {
        var cnt = new int[n];
        var idle = new PriorityQueue<Integer>();
        for (var i = 0; i < n; ++i) idle.offer(i);
        var using = new PriorityQueue<Pair<Long, Integer>>((a, b) -> !Objects.equals(a.getKey(), b.getKey()) ? Long.compare(a.getKey(), b.getKey()) : Integer.compare(a.getValue(), b.getValue()));
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        for (var m : meetings) {
            long st = m[0], end = m[1];
            while (!using.isEmpty() && using.peek().getKey() <= st) {
                idle.offer(using.poll().getValue()); // 维护在 st 时刻空闲的会议室
            }
            int id;
            if (idle.isEmpty()) {
                var p = using.poll(); // 没有可用的会议室，那么弹出一个最早结束的会议室（若有多个同时结束的，会弹出下标最小的）
                end += p.getKey() - st; // 更新当前会议的结束时间
                id = p.getValue();
            } else id = idle.poll();
            ++cnt[id];
            using.offer(new Pair<>(end, id)); // 使用一个会议室
        }
        var ans = 0;
        for (var i = 0; i < n; ++i) if (cnt[i] > cnt[ans]) ans = i;
        return ans;
    }
}
