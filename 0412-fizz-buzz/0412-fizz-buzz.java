class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = i+1;
            if (num % 3 == 0 && num % 5 == 0) {
                res.add("FizzBuzz");
            } else if ( num % 3 == 0) {
                res.add("Fizz");
            } else if (num % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(num));
            }
        }
        return res;
    }
}