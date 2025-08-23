class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        // base case: 1st row is always 1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i-1); //[1]
            
            // first element always 1
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }

            // last element always 1
            row.add(1);
        
            triangle.add(row);
        }
        return triangle;
    }
}