class Solution {
    public int totalFruit(int[] fruits) {
         int left = 0, max = 0;
         HashMap<Integer, Integer> map = new HashMap<>(); // <num, count>

         for (int i = 0; i < fruits.length; i++) { // i = 4
            map.put(fruits[i], map.getOrDefault(fruits[i], 0)+1); // set: 3, 1, 2

            while (map.size() > 2) { // T, left = 0
                int fruit = fruits[left];
                map.put(fruit, map.get(fruit)-1); // set:
                if (map.get(fruit) == 0) map.remove(fruit);
                left++; 
            }

            max = Math.max(max, i-left+1); // max = 4
         }
         return max;
    }
}

 // set: 