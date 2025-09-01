class ProductOfNumbers {
    List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }
    
    public void add(int num) {
        if (num != 0) {
            products.add(products.get(products.size()-1) * num);
        } else {
            products.clear();
            products.add(1);
        }
    }
    
    public int getProduct(int k) {
        int n = products.size();
        if (k >= n) return 0;
        return products.get(n-1)/products.get(n-1-k);        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */