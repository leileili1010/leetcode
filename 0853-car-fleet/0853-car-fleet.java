class Car {
    int position;
    double timeToTarget;
    int speed;

    Car(int position, int speed) {
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
            cars[i].timeToTarget = (double) (target-position[i])/speed[i];
        }  

        Arrays.sort(cars, (a,b) -> (a.position-b.position));

        int res = 1;
        for (int i = n-1; i > 0; i--) {
            if (cars[i].timeToTarget < cars[i-1].timeToTarget) res++;
            else cars[i-1] = cars[i]; //  后面的车追上之后变成一个车队了
        }

        return res;
    }
}