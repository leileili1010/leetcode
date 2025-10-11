class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>(); // <val, index>
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
  public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);

        // ✅ 1️⃣ swap 目标元素与最后一个元素
        Collections.swap(list, idx, lastIdx);

        // ✅ 2️⃣ 更新最后一个元素在 map 中的新索引
        map.put(lastVal, idx);

        // ✅ 3️⃣ 删除最后一个元素
        list.remove(lastIdx);

        // ✅ 4️⃣ 删除 val 的映射
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int end = list.size();
        int idx = rand.nextInt(end);
        
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */