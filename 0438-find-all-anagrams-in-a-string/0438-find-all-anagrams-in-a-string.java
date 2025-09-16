class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int[] count = new int[26];
        int[] temp = new int[26];
        
        for (char c: p.toCharArray()) {
            count[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i)-'a']++;
            
            while(i-left+1 > p.length()) {
                temp[s.charAt(left)-'a']--;
                left++;
            }
            
            if (i-left+1 == p.length() && Arrays.equals(temp, count)) res.add(left);
        }
        return res;
    }
}