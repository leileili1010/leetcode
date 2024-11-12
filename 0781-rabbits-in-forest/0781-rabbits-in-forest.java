class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int ans: answers) {
           map.put(ans, map.getOrDefault(ans, 0)+1);
        }

        for (HashMap.Entry<Integer, Integer> e: map.entrySet()) {
            int numPerGroup = e.getKey()+1;
            int replyCnt = e.getValue();
            int numOfGroup = replyCnt / numPerGroup;
           
            if (replyCnt % numPerGroup != 0) {
                numOfGroup++;
            }
            
            count += numPerGroup * numOfGroup;
        }

        return count;
    }
}