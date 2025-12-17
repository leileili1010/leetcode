class Car {
    int speed;
    int position;
    double time;

    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
            cars[i].time = (double)(target-position[i]) / speed[i];
        }
        
        Arrays.sort(cars, (a,b) -> (a.position - b.position));

        int res = 1;
        for (int i = n-1; i > 0; i--) {
            Car car = cars[i];
            Car prev = cars[i-1];
            
            if (prev.time <= car.time) {
                cars[i-1] = car;
            } else {
                res++;
            }
        }
        return res;
    }
}