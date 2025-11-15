/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] eleminated = new boolean[n];
        List<Integer>[] map = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && knows(i, j)) {
                    eleminated[i] = true;
                    map[j].add(i);
                }
               
            }
        }

        for (int i = 0; i < n; i++) {
            if (!eleminated[i] && map[i].size() == n-1) {
                return i;
            }
        }
        return -1;
    }
}