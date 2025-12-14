class Car {
    int position;
    int speed;
    double timeToDestination;

    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Car[] cars = new Car[n];

        // 1. 构造 Car 对象
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
            cars[i].timeToDestination = (double)(target - position[i]) / speed[i];
        }

        // 2. 按 position 从小到大排序（靠后 → 靠前）
        Arrays.sort(cars, (a, b) -> a.position - b.position);

        // 3. 必须从右往左处理 → stack 只放 time
        Deque<Double> stack = new ArrayDeque<>();

        // 从最右边（靠近 target）开始
        for (int i = n - 1; i >= 0; i--) {
            double t = cars[i].timeToDestination;

            // 如果当前车时间 > stack.peek()，说明追不上 → 新车队
            if (stack.isEmpty() || t > stack.peek()) {
                stack.push(t);
            }
            // 否则（t <= stack.peek()），说明它能追上 → 属于现有车队
            else {
                // do nothing
            }
        }

        return stack.size();
    }
}

