/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left + 1 < right) {
            int mid = left + (right-left)/2;
            if (!isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(isBadVersion(left)) return left;
        if (isBadVersion(right)) return right;
        return -1;
    }
}