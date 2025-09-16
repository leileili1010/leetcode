class Solution {
    public int totalFruit(int[] fruits) {
         int left = 0, max = 0;
         Set<Integer> set = new HashSet<>();

         for (int i = 0; i < fruits.length; i++) { // i = 3
            set.add(fruits[i]); // set: 2, 3

            while (set.size() > 2) { // F, left = 1
                set.remove(fruits[left++]); // set: 2, 3
            }

            max = Math.max(max, i-left+1); // max = 3
         }
         return max;
    }
}

 // set: 