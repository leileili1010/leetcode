class Solution {
    public int[] sortByBits(int[] arr) {
        // Define a custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                int countA = countBits(a);
                int countB = countBits(b);
                
                if (countA != countB) {
                    return countA - countB; // Sort by number of 1 bits
                } else {
                    return a - b; // If counts are the same, sort by value
                }
            }
        });
        
        for (int num: arr) {
            pq.add(num);
        }

        int i = 0;
        while (!pq.isEmpty()) {
            arr[i] = pq.poll();
            i++;
        } 

        return arr;
    }
    
    // Helper function to count number of 1 bits in an integer
    private int countBits(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}


