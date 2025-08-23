class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i-1);
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j-1) + preRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }
        return triangle;

    }
}