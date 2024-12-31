/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        // 倍增法求end边界
        int end = 1;
        while (reader.get(end) < target) {
            end = end * 2;
        }

        // 套模板binary search
        int start = end/2;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) return start;
        if (reader.get(end) == target) return end;
        return -1;
    }
}