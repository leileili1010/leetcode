class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid: asteroids) {
            boolean alive = true;

            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();
                // case 1: asteroid abs > top, top explode
                if (top < -asteroid) {
                    stack.pop();
                    continue;
                } else if (top == -asteroid) {
                    // case 2: top == abs asteroid
                    stack.pop();
                } 
                    
                // case 3: top > -asteroid && case 2
                    alive = false;
                    break;
            }

            if (alive) stack.push(asteroid);
        }

        int n = stack.size();
        int[] res = new int[n];
        for (int i = n-1; i >= 0 && n > 0; i--) {
            res[i] = stack.pop();
        }   

        return res;
    }
}