class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // 去掉首尾空格
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}