class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // two pointers, pointed to the first list of each array
        // compare start and end
            // if max(s1, s2) <= min(e1, e2), there is a overlap, put it in res
            // find the smaller end, move pointer to next list

        List<int[]> res = new ArrayList<>();
        int p1 = 0, p2 = 0; // two pointers 
        int m = firstList.length, n = secondList.length;

        while (p1 < m && p2 < n) {
            int start1 = firstList[p1][0], end1 = firstList[p1][1];
            int start2 = secondList[p2][0], end2 = secondList[p2][1];
            int maxStart = Math.max(start1, start2);
            int minEnd = Math.min(end1, end2);

            if (maxStart <= minEnd) res.add(new int[]{maxStart, minEnd});

            if (end1 < end2) {
                p1++;
            } else {
                p2++;
            }
        }
        return res.toArray(new int[0][]); 
    }
}