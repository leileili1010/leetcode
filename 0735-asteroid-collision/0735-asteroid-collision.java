class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();

        for (int num : asteroids) {
            // int size = stack.size();
            while (stack.size() > 0 && num < 0 && stack.get(stack.size() - 1) > 0) {
                int diff = num + stack.get(stack.size() - 1);
                if (diff < 0) {
                    stack.remove(stack.size() - 1);
                    // size--; // Update the size after removing an element
                } else if (diff > 0) {
                    num = 0;
                } else {
                    stack.remove(stack.size() - 1);
                    num = 0;
                    // size--; // Update the size after removing an element
                }
            }

            if (num != 0) {
                stack.add(num);
            }
        }

        int[] result = new int[stack.size()];
        for (int j = 0; j < stack.size(); j++) {
            result[j] = stack.get(j);
        }

        return result;
    }
}
