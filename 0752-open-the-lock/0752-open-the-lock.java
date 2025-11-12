class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1; // 初始状态死锁

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();  // 当前层的节点数
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(target)) return steps;
                if (dead.contains(cur)) continue;  // 遇到死锁跳过

                for (String next : getNextStates(cur)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }

        return -1; // 找不到路径
    }

    // 生成当前状态的所有下一步状态
    private List<String> getNextStates(String cur) {
        List<String> res = new ArrayList<>();
        char[] arr = cur.toCharArray();

        for (int i = 0; i < 4; i++) {
            char ch = arr[i];
            // +1
            arr[i] = ch == '9' ? '0' : (char)(ch + 1);
            res.add(new String(arr));
            // -1
            arr[i] = ch == '0' ? '9' : (char)(ch - 1);
            res.add(new String(arr));
            // 恢复
            arr[i] = ch;
        }
        return res;
    }
}
