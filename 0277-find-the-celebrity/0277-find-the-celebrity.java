/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // Step 1: Find the only possible candidate
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                // candidate knows i -> candidate cannot be celeb
                candidate = i;
            }
            // else i cannot be celeb, keep candidate
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;

            // Candidate must not know i
            if (knows(candidate, i)) return -1;

            // Everyone must know candidate
            if (!knows(i, candidate)) return -1;
        }

        return candidate;   // valid celebrity
    }
}