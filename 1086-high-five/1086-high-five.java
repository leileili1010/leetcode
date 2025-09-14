class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a,b) -> (b[1] - a[1]));
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int[] item: items) {
            int id = item[0];
            int score = item[1];

            int[] arr = map.computeIfAbsent(id, k->new int[2]);
            if (arr[0] < 5) {
                arr[0] += 1;
                arr[1] += score;
            }
        }

        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (int key: map.keySet()) {
            res[idx][0] = key;
            res[idx][1] = map.get(key)[1] / 5;
            idx++;
        }

        return res;
    }
}