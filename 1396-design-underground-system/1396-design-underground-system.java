class Trip {
    String start;
    String end;
    int startTime;
    int endTime;

    public Trip(String start, int startTime) {
        this.start = start;
        this.startTime = startTime;
    }
}


class UndergroundSystem {
    Map<Integer, Trip> customerTrips;
    Map<String, int[]> trips;

    public UndergroundSystem() {
        customerTrips = new HashMap<>();
        trips = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        customerTrips.put(id, new Trip(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Trip trip = customerTrips.get(id);
        String key = trip.start + "->" + stationName;
        if (!trips.containsKey(key)) {
            trips.put(key, new int[2]);
        }

        int[] time = trips.get(key);
        time[0] += t - trip.startTime;
        time[1] += 1;
        customerTrips.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        int[] tripStats = trips.get(key);
        return (double)tripStats[0] / tripStats[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */