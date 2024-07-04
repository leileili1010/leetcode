class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        
        // Sort the list using the custom comparator
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                int val = countBits(a) - countBits(b);
                
                if (val != 0) {
                    return val; // Sort by number of 1 bits
                } else {
                    return a - b; // If counts are the same, sort by value
                }
            }
        });
        
        // Convert sorted list back to array
        int[] sortedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sortedArray[i] = list.get(i);
        }
        
        return sortedArray;
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


