class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ans: answers) {
            int n = ans+1;
            if (!map.containsKey(n) || map.get(n) < n) {
                map.put(n, map.getOrDefault(n, 0)+1);
            } else {
                map.put(n, 1);
            }

            if (map.get(n) == 1) {
                count += n;
            }
        }

        return count;
    }
}