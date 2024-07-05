class Solution {
    public int minFlips(String target) {
        int flips = 0;
        char current = '0'; // initial character of the initial string

        for (char c : target.toCharArray()) {
            if (c != current) {
                flips++;
                current = c;
            }
        }

        return flips;
    }
}