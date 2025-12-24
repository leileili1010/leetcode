class Car {
    int position;
    int speed;
    double time;

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
            Car car = new Car(position[i], speed[i]);
            car.time = (double)(target - position[i]) / speed[i];
            cars[i] = car;
        }  
        Arrays.sort(cars, (a,b) -> (a.position - b.position));

        int res = 1;
        for (int i = n - 1; i > 0; i--) {
            if (cars[i-1].time <= cars[i].time) {
                cars[i-1] = cars[i];
            } else {
                res++;
            }
        }  
        return res;
    }
}