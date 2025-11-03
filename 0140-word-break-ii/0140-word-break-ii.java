import java.util.*;

class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        // 记忆化缓存：存储每个 startIndex 开始的所有可能句子
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, wordSet, 0, memo);
    }

    private List<String> backtrack(
        String s,
        Set<String> wordSet,
        int startIndex,
        Map<Integer, List<String>> memo
    ) {
        // 如果缓存中已经有结果，直接返回
        if (memo.containsKey(startIndex)) {
            return memo.get(startIndex);
        }

        List<String> results = new ArrayList<>();

        // base case：到达字符串末尾
        if (startIndex == s.length()) {
            results.add("");
            return results;
        }

        // 枚举所有可能的结束位置
        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String word = s.substring(startIndex, endIndex);

            // 如果当前子串是一个单词
            if (wordSet.contains(word)) {
                // 递归得到从 endIndex 开始的所有句子
                List<String> nextList = backtrack(s, wordSet, endIndex, memo);

                // 将当前单词与后续句子组合
                for (String next : nextList) {
                    if (next.isEmpty()) {
                        results.add(word);
                    } else {
                        results.add(word + " " + next);
                    }
                }
            }
        }

        // 结果存入缓存
        memo.put(startIndex, results);
        return results;
    }
}
