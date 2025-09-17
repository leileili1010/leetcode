
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLen = words[0].length();          // 每个单词长度
        int wordCount = words.length;             // 单词总数
        int totalLen = wordLen * wordCount;       // 总拼接长度

        if (s.length() < totalLen) return result;

        // 1. 构建 words 的词频表
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String w : words) {
            wordCountMap.put(w, wordCountMap.getOrDefault(w, 0) + 1);
        }

        // 2. 遍历不同的起始偏移（0 到 wordLen-1）
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0; // 已匹配的单词数

            while (right + wordLen <= s.length()) {
                // 取出下一个单词
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // 如果这个单词在字典里
                if (wordCountMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // 如果超过需要的次数 → 缩小窗口
                    while (seen.get(word) > wordCountMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // 如果正好匹配 M 个单词
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // 不在字典 → 清空窗口
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
