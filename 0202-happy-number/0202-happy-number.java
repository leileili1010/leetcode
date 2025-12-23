class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = powSum(n);
        }
        return n == 1;
    }

    public int powSum(int n) {
        int r = 0;
        int sum = 0;

        while (n != 0) {
            r = n % 10;
            n = n /10;
            sum += r * r;
        }

        return sum;
    }
}