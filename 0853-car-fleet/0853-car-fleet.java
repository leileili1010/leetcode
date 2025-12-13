class Car {
    int speed;
    int position;
    int timeToDestination;

    Car (int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
            int distance = target-position[i];
            cars[i].timeToDestination = distance % speed[i] == 0? distance/speed[i]: distance/speed[i] + 1;
        }

        // cars: (0,1,12), (3,3,3), (5,1,7), (8,4,1), (10,2,1)

        Arrays.sort(cars, (a,b) -> (a.position - b.position));

        Deque<Car> stack = new ArrayDeque<>();

        for (Car car: cars) {
            while (!stack.isEmpty() && stack.peek().timeToDestination <= car.timeToDestination) {
                Car prev = stack.pop(); 
                car = prev.speed < car.speed? prev: car;
            }
            
            stack.push(car); // (0,1,12), (5,1,7), (10,2,1)
        }

        return stack.size();
    }
}