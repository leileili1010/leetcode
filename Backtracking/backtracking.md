# Backtracking Notes

Template:

```java
public void backtrack(Candidate candidate) {
        if (findSolution(candidate)) {
            output(candidate);
            return;
        }

        // Iterate all possible candidates.
        for (Candidate nextCandidate : listOfCandidates()) {
            if (isValid(nextCandidate)) {
                // Try this partial candidate solution.
                place(nextCandidate);
                // Given the candidate, explore further.
                backtrack(nextCandidate);
                // Backtrack.
                remove(nextCandidate);
            }
        }
```