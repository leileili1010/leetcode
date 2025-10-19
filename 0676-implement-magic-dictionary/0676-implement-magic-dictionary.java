class MagicDictionary {
    private Map<Integer, List<String>> map = new HashMap<>();

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            map.computeIfAbsent(word.length(), x -> new ArrayList<>()).add(word);
        }
    }

    public boolean search(String searchWord) {
        if (!map.containsKey(searchWord.length())) return false;
        for (String w : map.get(searchWord.length())) {
            int diff = 0;
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) != searchWord.charAt(i)) diff++;
                if (diff > 1) break;
            }
            if (diff == 1) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */